package com.duke.loan_system.dto.loanAudit;

public class RejectLoanAuditDTO {
    //대출 식별자
    private Long loanId;
    //거부 사유
    private String rejectMessage;

    public Long getLoanId(){return loanId;}
    public String getRejectMessage(){return rejectMessage;}
}
