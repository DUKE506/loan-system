package com.duke.loan_system.domain;

import jakarta.persistence.*;

//대출 심사
@Entity
public class LoanAudit {
    //식별자
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //심사결과
    @Column
    @Enumerated(value = EnumType.STRING)
    private LoanResult result;
    //대출 식별자
    private Long loanId;

    //생성자
    public LoanAudit (){}

    //// 식별자 GETTER, SETTER
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public LoanResult getResult(){
        return result;
    }
    public void setResult(LoanResult result){
        this.result = result;
    }

    public Long getLoanId(){
        return loanId;
    }

    public void setLoadId(Long loanId){
        this.loanId = loanId;
    }
}
