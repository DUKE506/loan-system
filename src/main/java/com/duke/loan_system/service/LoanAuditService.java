package com.duke.loan_system.service;

import com.duke.loan_system.domain.*;
import com.duke.loan_system.dto.loanAudit.ApprovalLoanAuditDTO;
import com.duke.loan_system.dto.loanAudit.RejectLoanAuditDTO;
import com.duke.loan_system.dto.loanAudit.ResponseLoanAuditDTO;
import com.duke.loan_system.repository.LoanAuditRepository;
import com.duke.loan_system.repository.LoanRepository;
import com.duke.loan_system.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoanAuditService {
    private LoanAuditRepository loanAuditRepository;
    private LoanRepository loanRepository;
    private UserRepository userRepository;

    public LoanAuditService( LoanAuditRepository loanAuditRepository,LoanRepository loanRepository,UserRepository userRepository){
        this.loanAuditRepository = loanAuditRepository;
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
    }

    //대출 심사 생성
    public LoanAudit createLoanAudit(Loan loan){
        LoanAudit createLoanAudit = new LoanAudit();
        createLoanAudit.setLoanInfo(loan);
        return loanAuditRepository.save(createLoanAudit);
    }

    //대출 심사 승인
    @Transactional
    public LoanAudit approvalLoan(Long id){
        // 1. 대출 조회
        Loan loan = loanRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("대출이 존재하지 않습니다."));
        // 2. 심사 조회
        LoanAudit loanAudit = loanAuditRepository.findByLoanInfo(loan)
                .orElseThrow(()-> new IllegalArgumentException("심사중인 대출이 존재하지않습니다."));
        // 3. 사용자 조회
        User user = userRepository.findById(loan.getApplicant().getId())
                .orElseThrow(()->new IllegalArgumentException("지급 대상이 존재하지않습니다."));

        // 4. 심사 승인
        loanAudit.setAuditStatus(LoanAuditStatus.APPROVED);
        // 4. 대출 상태 변경 / 대기 -> 실행
        loan.setStatus(LoanStatus.EXECUTED);


        int balance = user.getBalance();
        user.setBalance(balance+loan.getAmount());

        loanRepository.save(loan);
        userRepository.save(user);

        return loanAuditRepository.save(loanAudit);
    }

    //대출 심사 거부
    @Transactional
    public ResponseLoanAuditDTO rejectLoan(Long id, String message){
        // 1. 대출 조회
        Loan loan = loanRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("대출이 존재하지 않습니다."));
        // 2. 심사 조회
        LoanAudit loanAudit = loanAuditRepository.findByLoanInfo(loan)
                .orElseThrow(()-> new IllegalArgumentException("심사중인 대출이 존재하지않습니다."));


        // 3. 대출 상태 변경
        loan.setStatus(LoanStatus.REJECTED);
        loanRepository.save(loan);

        // 4. 심사 거부
        loanAudit.setAuditStatus(LoanAuditStatus.REJECTED);
        loanAudit.setNote(message);
        LoanAudit updatedLoanAudit = loanAuditRepository.save(loanAudit);

        // 5. 응답 객체 생성
        ResponseLoanAuditDTO response = new ResponseLoanAuditDTO(updatedLoanAudit);

        return response;
    }
}
