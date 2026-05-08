package com.duke.loan_system.loan_context.interfaces.dto;

import lombok.Getter;

@Getter
public class ApplyLoanDTO {
    //대출금
    private int amount;

    //이름
    private String name;

    //주민번호
    private String rnn;

    //이율
    private float interestRate;
}
