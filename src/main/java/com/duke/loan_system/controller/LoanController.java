package com.duke.loan_system.controller;

import com.duke.loan_system.domain.Loan;
import com.duke.loan_system.dto.loan.ApplyLoanDTO;
import com.duke.loan_system.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {
    private LoanService loanService;

    public LoanController(LoanService loanService){
        this.loanService = loanService;
    }


    //대출 신청
    @PostMapping("/apply")
    public ResponseEntity<Loan> applyLoan(@RequestBody ApplyLoanDTO applyLoanDTO) {
        System.out.println("===============================");
        System.out.println("[Loan][Controller] 사용자명 : "+applyLoanDTO.getApplicantName());
        System.out.println("[Loan][Controller] 주민번호 : "+applyLoanDTO.getApplicantRnn());
        System.out.println("[Loan][Controller] 대출금 : "+applyLoanDTO.getAmount());
        Loan loan = loanService.applyLoan(applyLoanDTO);
        return ResponseEntity.status(201).body(loan);
    }

    //대출 이력조회
    @GetMapping("/findApplicant")
    public ResponseEntity<List<Loan>> findLoanListByApplicant(@RequestParam String rnn ){
        List<Loan> loanList = loanService.findLoanListByApplicant(rnn);
        return ResponseEntity.ok(loanList);
    }
}
