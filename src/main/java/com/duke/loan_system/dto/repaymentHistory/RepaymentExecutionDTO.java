package com.duke.loan_system.dto.repaymentHistory;

public class RepaymentExecutionDTO {
    //대출 식별자
    private Long loanId;

    //상환금
    private int repayment;

    //이름
    private String name;

    //주민번호
    private String rnn;

    public Long getLoanId(){return loanId;}
    public int getRepayment(){return repayment;}
    public String getName(){return name;}
    public String getRnn(){return rnn;}
}
