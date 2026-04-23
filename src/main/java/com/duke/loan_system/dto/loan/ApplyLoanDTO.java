package com.duke.loan_system.dto.loan;


public class ApplyLoanDTO {
    //신청자명
    private String applicantName;

    //신청자 주민번호
    private String applicantRnn;

    //대출금
    private int amount;

    //대출기간
    private int period;

    //대출금리
    private float interestRate;

    public String getApplicantName(){
        return applicantName;
    }
    public String getApplicantRnn() { return applicantRnn;}
    public int getAmount(){
        return amount;
    }
    public int getPeriod(){return period;}
    public float getInterestRate(){return interestRate;}
}


