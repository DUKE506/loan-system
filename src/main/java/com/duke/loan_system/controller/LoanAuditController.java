package com.duke.loan_system.controller;

import com.duke.loan_system.domain.LoanAudit;
import com.duke.loan_system.dto.loanAudit.ApprovalLoanAuditDTO;
import com.duke.loan_system.dto.loanAudit.RejectLoanAuditDTO;
import com.duke.loan_system.service.LoanAuditService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/loanAudit")
public class LoanAuditController {
    private LoanAuditService loanAuditService;

    public LoanAuditController(LoanAuditService loanAuditService){
        this.loanAuditService = loanAuditService;
    }

    //심사 승인
    @PatchMapping("/approval")
    public ResponseEntity<LoanAudit> approvalLoan(@RequestBody ApprovalLoanAuditDTO approvalLoanAuditDTO){
        LoanAudit loanAudit = loanAuditService.approvalLoan(approvalLoanAuditDTO);
        return ResponseEntity.ok(loanAudit);
    }

    //심사 거부
    @PatchMapping("/reject")
    public ResponseEntity<LoanAudit> rejectLoan(@RequestBody RejectLoanAuditDTO rejectLoanAuditDTO){
        LoanAudit loanAudit = loanAuditService.rejectLoan(rejectLoanAuditDTO);
        return ResponseEntity.ok(loanAudit);
    }

}
