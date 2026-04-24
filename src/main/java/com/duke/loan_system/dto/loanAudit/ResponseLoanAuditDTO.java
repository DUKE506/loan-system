package com.duke.loan_system.dto.loanAudit;


import com.duke.loan_system.domain.LoanAudit;
import com.duke.loan_system.domain.LoanAuditStatus;
import com.duke.loan_system.dto.loan.ResponseLoanDTO;

public class ResponseLoanAuditDTO {
    private Long id;
    private LoanAuditStatus loanAuditStatus;
    private String note;
    private ResponseLoanDTO loanInfo;


    public ResponseLoanAuditDTO(){};
    public ResponseLoanAuditDTO(LoanAudit loanAudit){
        this.id = loanAudit.getId();
        this.loanAuditStatus = loanAudit.getAuditStatus();
        this.note = loanAudit.getNote();
        this.loanInfo = new ResponseLoanDTO(loanAudit.getLoanInfo());
    };

    public Long getId(){return id;}
    public void setId(Long id){ this.id = id;}

    public LoanAuditStatus getLoanAuditStatus(){return loanAuditStatus;}
    public void setLoanAuditStatus(LoanAuditStatus loanAuditStatus) {this.loanAuditStatus = loanAuditStatus;}

    public String getNote(){return note;}
    public void setNote(String note){this.note = note;}

    public ResponseLoanDTO getLoanInfo(){return loanInfo;}
    public void setLoanInfo(ResponseLoanDTO loanInfo){this.loanInfo = loanInfo;}
}
