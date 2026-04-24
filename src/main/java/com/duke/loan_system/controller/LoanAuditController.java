package com.duke.loan_system.controller;

import com.duke.loan_system.domain.LoanAudit;
import com.duke.loan_system.dto.loanAudit.ApprovalLoanAuditDTO;
import com.duke.loan_system.dto.loanAudit.RejectLoanAuditDTO;
import com.duke.loan_system.dto.loanAudit.ResponseLoanAuditDTO;
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
    @PatchMapping("/approval/{id}")
    public ResponseEntity<LoanAudit> approvalLoan(@PathVariable("id") Long id){
        LoanAudit loanAudit = loanAuditService.approvalLoan(id);
        return ResponseEntity.ok(loanAudit);
    }

    //심사 거부
    @PatchMapping("/reject/{id}")
    public ResponseEntity<ResponseLoanAuditDTO> rejectLoan(@PathVariable("id") Long id , @RequestBody RejectLoanAuditDTO rejectLoanAuditDTO){
        ResponseLoanAuditDTO loanAudit = loanAuditService.rejectLoan(id,rejectLoanAuditDTO.getRejectMessage());
        return ResponseEntity.ok(loanAudit);
    }

}
