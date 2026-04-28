package com.duke.loan_system.domain;

import com.duke.loan_system.dto.loan.ApplyLoanDTO;
import jakarta.persistence.*;

@Entity
public class Loan {
    //식별자
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //대출금액
    @Column
    private int amount;

    //대출상태 ( PENDING, APPROVED, REJECTED, EXECUTED)
    @Column
    @Enumerated(value = EnumType.STRING)
    private LoanStatus status = LoanStatus.PENDING;

    //잔액
    @Column
    private int balance;

    //대출기간 (개월수)
    @Column
    private int period;

    //납부횟수
    @Column
    private int paymentCount = 0;

    //대출금리
    @Column
    private float interestRate;

    //사용자 -< 대출 1:N 관계
    @ManyToOne
    @JoinColumn(name = "applicant")
    private User applicant;

    // 기본 생성자
    public Loan(){}

    // 대출 생성시 정적메서드
    public static Loan createLoan(int amount, int period, float interestRate, User user){
        Loan loan = new Loan();
        loan.amount = amount;
        loan.period = period;
        loan.interestRate = interestRate;
        loan.balance = 0;
        loan.applicant=user;
        return loan;
    }


    /// 식별자 GETTER, SETTER
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    /// 대출금액 GETTER, SETTER
    public int getAmount(){
        return amount;
    }
    public void setAmount(Integer amount){
        this.amount = amount;
    }

    /// 대출상태 GETTER, SETTER
    public LoanStatus getLoanStatus(){
        return status;
    }
    public void setStatus(LoanStatus status){
        this.status = status;
    }

    /// 대출 신청자
    public User getApplicant(){
        return applicant;
    }
    public void setApplicant(User applicant){
        this.applicant = applicant;
    }

    /// 잔액
    public int getBalance(){return balance;}
    public void setBalance(int balance){this.balance = balance;}

    /// 대출기간
    public int getPeriod(){return period;}
    public void setPeriod(int period){ this.period = period;}

    /// 납부횟수
    public int getPaymentCount(){return paymentCount;}
    public void setPaymentCount(int frequency){this.paymentCount = frequency;}

    /// 대출금리
    public float getInterestRate(){return interestRate;}
    public void setInterestRate(float interestRate){this.interestRate = interestRate;}

    //메서드
    /// 승인
    public void approve(){
        if (this.status == LoanStatus.REJECTED) {
            throw new IllegalArgumentException("이미 거부된 대출입니다.");
        }
        this.status = LoanStatus.APPROVED;
    }
    /// 실행
    public void execute(){
        if (this.status == LoanStatus.REJECTED) {
            throw new IllegalArgumentException("이미 거부된 대출입니다.");
        }
        this.status = LoanStatus.EXECUTED;
        //실행 시 잔액이생김
        this.balance = this.amount;
    }
    /// 거부
    public void reject(){
        this.status = LoanStatus.REJECTED;
    }

    /// 납부
    public void repayment(int amount){
        if(this.balance <= 0){
            throw new IllegalArgumentException("이미 완납된 대출입니다.");
        }

        if(amount <= 0 ){
            throw new IllegalArgumentException("금액은 0보다 커야 합니다.");
        }

        this.balance -= amount;
        this.paymentCount++;
    }
}

