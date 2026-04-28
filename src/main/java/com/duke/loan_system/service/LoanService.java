package com.duke.loan_system.service;

import com.duke.loan_system.domain.Loan;
import com.duke.loan_system.domain.LoanAudit;
import com.duke.loan_system.domain.User;
import com.duke.loan_system.dto.loan.ApplyLoanDTO;
import com.duke.loan_system.dto.loan.ResponseLoanDTO;
import com.duke.loan_system.repository.LoanAuditRepository;
import com.duke.loan_system.repository.LoanRepository;
import com.duke.loan_system.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {
    private LoanRepository loanRepository;
    private UserRepository userRepository;
    private LoanAuditRepository loanAuditRepository;
    private LoanAuditService loanAuditService;

    public LoanService(LoanRepository loanRepository,UserRepository userRepository, LoanAuditService loanAuditService){
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
        this.loanAuditService = loanAuditService;
    }


    // 신청
    @Transactional
    public ResponseLoanDTO applyLoan(ApplyLoanDTO applyLoanDTO){
        // 1. 사용자 검증
        User user = userRepository.findByRnn(applyLoanDTO.getApplicantRnn())
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지않습니다."));
        
        // 정적 메서드 활용 객체 생성
        Loan createLoan = Loan.createLoan(applyLoanDTO.getAmount(), applyLoanDTO.getPeriod(),applyLoanDTO.getInterestRate(),user);
        // 2. 대출생성
        Loan createdLoan = loanRepository.save(createLoan);

        // 3. 대출심사 생성 -> 책임 혼재. 분리할 것인가? 분리한다면 LoanAuditService
        loanAuditService.createLoanAudit(createdLoan);

        return ResponseLoanDTO.from(createdLoan);
    }

    //상태 조회
    public List<ResponseLoanDTO> findLoanListByApplicant(String rnn){
        //1. 사용자 조회
        User user = userRepository.findByRnn(rnn)
                .orElseThrow(()->new IllegalArgumentException("사용자가 존재하지않습니다."));

        //2. 대출이력 조회
        List<Loan> loanList = loanRepository.findByApplicant(user);

        return loanList.stream()
                .map(ResponseLoanDTO::from)
                .collect(Collectors.toList());
    }

}
