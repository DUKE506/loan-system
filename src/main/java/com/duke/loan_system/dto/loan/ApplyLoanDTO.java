package com.duke.loan_system.dto.loan;


public class ApplyLoanDTO {
    //신청자명
    private String applicantName;

    //신청자 주민번호
    private String applicantRnn;

    //대출금
    private Integer amount;

    public String getApplicantName(){
        return applicantName;
    }
    public String getApplicantRnn() { return applicantRnn;}
    public Integer getAmount(){
        return amount;
    }
}


