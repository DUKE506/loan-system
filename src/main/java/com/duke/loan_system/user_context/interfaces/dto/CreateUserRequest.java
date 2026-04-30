package com.duke.loan_system.user_context.interfaces.dto;

import com.duke.loan_system.user_context.application.command.CreateUserCommand;

public record CreateUserRequest(
        String name,
        String rnn,
        String phone
) {
    public CreateUserCommand toCommand(){
        return new CreateUserCommand(name, rnn, phone);
    }
}
