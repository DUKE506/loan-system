package com.duke.loan_system.service;

import com.duke.loan_system.domain.Loan;
import com.duke.loan_system.domain.LoanAudit;
import com.duke.loan_system.domain.User;
import com.duke.loan_system.dto.loan.ApplyLoanDTO;
import com.duke.loan_system.repository.LoanAuditRepository;
import com.duke.loan_system.repository.LoanRepository;
import com.duke.loan_system.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    private LoanRepository loanRepository;
    private UserRepository userRepository;
    private LoanAuditRepository loanAuditRepository;

    public LoanService(LoanRepository loanRepository,UserRepository userRepository,LoanAuditRepository loanAuditRepository){
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
        this.loanAuditRepository = loanAuditRepository;
    }


    // 신청
    public Loan applyLoan(ApplyLoanDTO applyLoanDTO){
        Loan createLoan = new Loan();
        createLoan.setAmount(createLoan.getAmount());
        // 1. 사용자 검증
        User user = userRepository.findByRnn(applyLoanDTO.getApplicantRnn())
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지않습니다."));

        /// 대출금
        createLoan.setAmount(applyLoanDTO.getAmount());
        /// 대출자
        createLoan.setApplicant(user);
        /// 대출기간
        createLoan.setPeriod(applyLoanDTO.getPeriod());
        /// 대출금리
        createLoan.setInterestRate(applyLoanDTO.getInterestRate());
        /// 초기 잔액
        createLoan.setBalance(applyLoanDTO.getAmount());


        // 2. 대출생성
        Loan createdLoan = loanRepository.save(createLoan);

        // 3. 대출심사 생성
        LoanAudit createLoanAudit = new LoanAudit();
        createLoanAudit.setLoanInfo(createdLoan);
        loanAuditRepository.save(createLoanAudit);

        return createdLoan;
    }

    //상태 조회
    public List<Loan> findLoanListByApplicant(String rnn){
        //1. 사용자 조회
        User user = userRepository.findByRnn(rnn)
                .orElseThrow(()->new IllegalArgumentException("사용자가 존재하지않습니다."));

        //2. 대출이력 조회
        List<Loan> loanList = loanRepository.findByApplicant(user);

        return loanList;
    }

}
