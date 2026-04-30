package com.duke.loan_system.user_context.application.command;

public record CreateUserCommand(
        String name,
        String rnn,
        String phone
) {

}
