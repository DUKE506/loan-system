package com.duke.loan_system.dto.loan;

import com.duke.loan_system.domain.Loan;
import com.duke.loan_system.domain.LoanStatus;
import com.duke.loan_system.dto.user.ResponseUserDTO;

public class ResponseLoanDTO {
    private Long id;
    private int amount;
    private LoanStatus loanStatus;
    private int balance;
    private int period;
    private int paymentCount;
    private float interestRate;
    private ResponseUserDTO user;

    // 생성자
    public ResponseLoanDTO(){};
    public ResponseLoanDTO(Loan loan){
        this.id = loan.getId();
        this.amount = loan.getAmount();
        this.loanStatus = loan.getLoanStatus();
        this.balance = loan.getBalance();
        this.period = loan.getPeriod();
        this.paymentCount = loan.getPaymentCount();
        this.interestRate = loan.getInterestRate();
        this.user = new ResponseUserDTO(loan.getApplicant());
    }

    // GETTER, SETTER
    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public int getAmount(){return amount;}
    public void setAmount(int amount){this.amount = amount;}

    public LoanStatus getLoanStatus(){return loanStatus;}
    public void setLoanStatus(LoanStatus amount){this.loanStatus = loanStatus;}

    public int getBalance(){return balance;}
    public void setBalance(int balance){this.balance = balance;}

    public int getPeriod(){return period;}
    public void setPeriod(int period){this.period = period;}

    public int getPaymentCount(){return paymentCount;}
    public void setPaymentCount(int paymentCount){this.paymentCount = paymentCount;}

    public float getInterestRate(){return interestRate;}
    public void setInterestRate(float interestRate){this.interestRate = interestRate;}

    public ResponseUserDTO getUser(){return user;}
    public void setUser(ResponseUserDTO user){this.user = user;}
}
