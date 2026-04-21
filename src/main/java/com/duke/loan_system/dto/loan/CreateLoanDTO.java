package com.duke.loan_system.dto.loan;


public class CreateLoanDTO {
    //신청자명
    private String applicantName;
    //대출금
    private Integer amount;

    public String getApplicantName(){
        return applicantName;
    }
    public Integer getAmount(){
        return amount;
    }
}


