package com.duke.loan_system.service;

import com.duke.loan_system.domain.Loan;
import com.duke.loan_system.domain.RepaymentHistory;
import com.duke.loan_system.domain.User;
import com.duke.loan_system.dto.repaymentHistory.RepaymentExecutionDTO;
import com.duke.loan_system.repository.LoanRepository;
import com.duke.loan_system.repository.RepaymentHistoryRepository;
import com.duke.loan_system.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class RepaymentHistoryService {

    private RepaymentHistoryRepository repaymentHistoryRepository;
    private LoanRepository loanRepository;
    private UserRepository userRepository;

    public RepaymentHistoryService(RepaymentHistoryRepository repaymentHistoryRepository,LoanRepository loanRepository,UserRepository userRepository){
        this.repaymentHistoryRepository = repaymentHistoryRepository;
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
    }

    //원리금 상환
    @Transactional
    public RepaymentHistory repaymentExecute(RepaymentExecutionDTO repaymentExecutionDTO){
        //1. 사용자 조회
        User user = userRepository.findByRnn(repaymentExecutionDTO.getRnn())
                .orElseThrow(()-> new IllegalArgumentException("사용자가 존재하지 않습니다."));

        //2. 대출 조회
        List<Loan> loanList = loanRepository.findByApplicant(user);
        if(loanList.isEmpty()){
            throw new IllegalArgumentException("대출이 존재하지 않습니다.");
        }

        Loan loan = loanList.get(0);

        //3. 대출 잔액, 납부횟수 업데이트
        int balance = loan.getBalance() - repaymentExecutionDTO.getRepayment();
        loan.setBalance(balance);
        loan.setPaymentCount(loan.getPaymentCount()+1);

        loanRepository.save(loan);

        user.setBalance(balance);
        userRepository.save(user);

        //4. 상환이력 추가.
        RepaymentHistory history = new RepaymentHistory();
        history.setApplicant(user);
        history.setLoanInfo(loan);
        history.setRepayment(repaymentExecutionDTO.getRepayment());
        history.setRepaymentDate(new Date());

        return repaymentHistoryRepository.save((history));
    }

    //상환이력 전체 조회
    public List<RepaymentHistory> findAllRepaymentHistory(){
        return repaymentHistoryRepository.findAll();
    }
}
