package com.duke.loan_system.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class RepaymentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //상환금
    @Column
    private Integer repayment;

    //상황일
    @Column
    private Date repaymentDate;

    //대출
    @ManyToOne
    @JoinColumn(name = "loan")
    private Loan loanInfo;

    //사용자
    @ManyToOne
    @JoinColumn(name = "applicant")
    private User applicant;

    //생성자
    public RepaymentHistory(){}

    public Long getId(){ return id;}
    public void setId(Long id){this.id = id;}

    public Integer getRepayment(){return repayment;}
    public void setRepayment(Integer repayment){ this.repayment = repayment;}

    public Date getRepaymentDate(){return repaymentDate;}
    public void setRepaymentDate(Date repaymentDate){this.repaymentDate = repaymentDate;}

    public Loan getLoanInfo(){return loanInfo;}
    public void setLoanInfo(Loan loanInfo){this.loanInfo = loanInfo;}

    public User getApplicant(){return applicant;}
    public void setApplicant(User applicant){ this.applicant = applicant;}

}
