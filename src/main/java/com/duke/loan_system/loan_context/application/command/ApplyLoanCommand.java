package com.duke.loan_system.loan_context.application.command;

public record ApplyLoanCommand(
        int amount,
        String name,
        String rnn,
        float interestRate

) {
}
