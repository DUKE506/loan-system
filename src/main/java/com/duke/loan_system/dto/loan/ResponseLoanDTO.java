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
    private Long userId;
    private String userName;


    // 생성자
    public ResponseLoanDTO(){};


    //정적 메서드
    public static ResponseLoanDTO from(Loan loan){
        ResponseLoanDTO dto = new ResponseLoanDTO();
        dto.id = loan.getId();
        dto.amount = loan.getAmount();
        dto.loanStatus = loan.getLoanStatus();
        dto.balance = loan.getBalance();
        dto.period = loan.getPeriod();
        dto.paymentCount = loan.getPaymentCount();
        dto.interestRate = loan.getInterestRate();
        dto.userId = loan.getApplicant().getId();
        dto.userName = loan.getApplicant().getName();

        return dto;
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

    public Long getUserId(){return userId;}
    public void setUserId(Long userId){this.userId = userId;}

    public String getUserName(){return userName;}
    public void setUserName(String userName) {this.userName = userName;}

//    public ResponseUserDTO getUser(){return user;}
//    public void setUser(ResponseUserDTO user){this.user = user;}
}
