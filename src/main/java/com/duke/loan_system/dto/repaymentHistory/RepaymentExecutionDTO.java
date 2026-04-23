package com.duke.loan_system.dto.repaymentHistory;

public class RepaymentExecutionDTO {
    //상환금
    private Integer repayment;

    //이름
    private String name;

    //주민번호
    private String rnn;

    public Integer getRepayment(){return repayment;}
    public String getName(){return name;}
    public String getRnn(){return rnn;}
}
