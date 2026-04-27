package com.duke.loan_system.domain;

import jakarta.persistence.*;

//대출 심사
@Entity
public class LoanAudit {
    //식별자
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //심사상태
    @Column
    @Enumerated(value = EnumType.STRING)
    private LoanAuditStatus auditStatus = LoanAuditStatus.PENDING;

    //거부사유 등
    @Column
    private String note;

    //대출
    @OneToOne
    @JoinColumn(name = "loanInfo")
    private Loan loanInfo;

    //생성자
    public LoanAudit (){}

    //// 식별자 GETTER, SETTER
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public LoanAuditStatus getAuditStatus(){
        return auditStatus;
    }
    public void setAuditStatus(LoanAuditStatus auditStatus){
        this.auditStatus = auditStatus;
    }

    public String getNote() {return note;}
    public void setNote(String message){ this.note= message;}

    public Loan getLoanInfo(){
        return loanInfo;
    }
    public void setLoanInfo(Loan loanInfo){
        this.loanInfo = loanInfo;
    }

    //메서드
    /// 승인
    public void approve(){
        if(this.auditStatus == LoanAuditStatus.REJECTED){
            throw new IllegalArgumentException("이미 거부된 대출입니다.");
        }
        this.auditStatus = LoanAuditStatus.APPROVED;
    }

    /// 거부
    public void reject(String message){
        this.auditStatus = LoanAuditStatus.REJECTED;
        this.note = message;

    }
}
