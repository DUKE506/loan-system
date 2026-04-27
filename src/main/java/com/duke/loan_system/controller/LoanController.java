package com.duke.loan_system.controller;

import com.duke.loan_system.domain.Loan;
import com.duke.loan_system.dto.loan.ApplyLoanDTO;
import com.duke.loan_system.dto.loan.ResponseLoanDTO;
import com.duke.loan_system.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {
    private LoanService loanService;

    public LoanController(LoanService loanService){
        this.loanService = loanService;
    }


    //대출 신청
    @PostMapping()
    public ResponseEntity<ResponseLoanDTO> applyLoan(@RequestBody ApplyLoanDTO applyLoanDTO) {

        ResponseLoanDTO loan = loanService.applyLoan(applyLoanDTO);
        return ResponseEntity.status(201).body(loan);
    }

    // 사용자 전체 대출 이력조회
    @GetMapping("{rnn}")
    public ResponseEntity<List<ResponseLoanDTO>> findLoanListByApplicant(@PathVariable("rnn") String rnn ){
        List<ResponseLoanDTO> loanList = loanService.findLoanListByApplicant(rnn);
        return ResponseEntity.ok(loanList);
    }

}
