package com.duke.loan_system.domain;

import jakarta.persistence.*;
import org.springframework.boot.context.event.SpringApplicationEvent;

import java.util.Date;

@Entity
public class RepaymentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //상환금
    @Column
    private int repayment;

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

    //정적 메서드
    public static RepaymentHistory create(int repayment, Loan loan, User user){
        RepaymentHistory repaymentHistory = new RepaymentHistory();
        repaymentHistory.repayment = repayment;
        repaymentHistory.repaymentDate = new Date();
        repaymentHistory.loanInfo = loan;
        repaymentHistory.applicant = user;

        return repaymentHistory;
    }

    public Long getId(){ return id;}
    public void setId(Long id){this.id = id;}

    public int getRepayment(){return repayment;}
    public void setRepayment(int repayment){ this.repayment = repayment;}

    public Date getRepaymentDate(){return repaymentDate;}
    public void setRepaymentDate(Date repaymentDate){this.repaymentDate = repaymentDate;}

    public Loan getLoanInfo(){return loanInfo;}
    public void setLoanInfo(Loan loanInfo){this.loanInfo = loanInfo;}

    public User getApplicant(){return applicant;}
    public void setApplicant(User applicant){ this.applicant = applicant;}

}
