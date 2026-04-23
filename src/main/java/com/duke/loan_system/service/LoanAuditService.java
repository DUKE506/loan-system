package com.duke.loan_system.service;

import com.duke.loan_system.domain.*;
import com.duke.loan_system.dto.loanAudit.ApprovalLoanAuditDTO;
import com.duke.loan_system.dto.loanAudit.RejectLoanAuditDTO;
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

    //대출 심사 승인
    @Transactional
    public LoanAudit approvalLoan(ApprovalLoanAuditDTO approvalLoanAuditDTO){
        //대출 조회
        Loan loan = loanRepository.findById(approvalLoanAuditDTO.getLoanId())
                .orElseThrow(()-> new IllegalArgumentException("대출이 존재하지 않습니다."));
        //심사 조회
        LoanAudit loanAudit = loanAuditRepository.findByLoanInfo(loan)
                .orElseThrow(()-> new IllegalArgumentException("심사중인 대출이 존재하지않습니다."));

        //심사 승인
        loanAudit.setAuditStatus(LoanAuditStatus.APPROVED);
        //대출 상태 변경 / 대기 -> 실행
        loan.setStatus(LoanStatus.EXECUTED);

        User user = userRepository.findById(loan.getApplicant().getId())
                .orElseThrow(()->new IllegalArgumentException("지급 대상이 존재하지않습니다."));
        int balance = user.getBalance();
        user.setBalance(balance+loan.getAmount());

        loanRepository.save(loan);
        userRepository.save(user);

        return loanAuditRepository.save(loanAudit);
    }

    //대출 심사 거부
    public LoanAudit rejectLoan(RejectLoanAuditDTO rejectLoanAuditDTO){
        //대출 조회
        Loan loan = loanRepository.findById(rejectLoanAuditDTO.getLoanId())
                .orElseThrow(()-> new IllegalArgumentException("대출이 존재하지 않습니다."));

        //심사 조회
        LoanAudit loanAudit = loanAuditRepository.findByLoanInfo(loan)
                .orElseThrow(()-> new IllegalArgumentException("심사중인 대출이 존재하지않습니다."));

        //심사 거부
        loanAudit.setAuditStatus(LoanAuditStatus.REJECTED);
        loanAudit.setNote(rejectLoanAuditDTO.getRejectMessage());

        //대출 상태 변경
        loan.setStatus(LoanStatus.REJECTED);
        loanRepository.save(loan);

        return loanAuditRepository.save(loanAudit);
    }
}
