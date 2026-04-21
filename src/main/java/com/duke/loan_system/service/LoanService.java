package com.duke.loan_system.service;

import com.duke.loan_system.domain.Loan;
import com.duke.loan_system.domain.User;
import com.duke.loan_system.dto.loan.CreateLoanDTO;
import com.duke.loan_system.repository.LoanRepository;
import com.duke.loan_system.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
    private LoanRepository loanRepository;
    private UserRepository userRepository;

    public LoanService(LoanRepository loanRepository,UserRepository userRepository){
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
    }


    // 신청
    public Loan createLoan(CreateLoanDTO createLoanDTO){
        Loan createLoan = new Loan();
        createLoan.setAmount(createLoan.getAmount());
        //검증
//        User user  = userRepository.find

        return loanRepository.save(createLoan);
    }

    //상태 조회

}
