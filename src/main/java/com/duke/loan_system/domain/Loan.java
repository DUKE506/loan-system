package com.duke.loan_system.domain;

import jakarta.persistence.*;

@Entity
public class Loan {
    //식별자
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //대출금액
    @Column
    private Integer amount;

    //대출상태 ( PENDING, APPROVED, REJECTED, EXECUTED)
    @Column
    @Enumerated(value = EnumType.STRING)
    private LoanStatus status = LoanStatus.PENDING;

    //사용자 -< 대출 1:N 관계
    @ManyToOne
    @JoinColumn(name = "applicant")
    private User applicant;

    // 기본 생성자
    public Loan(){}

    //// 식별자 GETTER, SETTER
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    //// 대출금액 GETTER, SETTER
    public Integer getAmount(){
        return amount;
    }
    public void setAmount(Integer amount){
        this.amount = amount;
    }

    //// 대출상태 GETTER, SETTER
    public LoanStatus getLoanStatus(){
        return status;
    }
    public void setStatus(LoanStatus status){
        this.status = status;
    }

    //// 대출 신청자
    public User getApplicant(){
        return applicant;
    }
    public void setApplicant(User applicant){
        this.applicant = applicant;
    }
}
