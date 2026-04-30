package com.duke.loan_system.user_context.application.command;

import com.duke.loan_system.user_context.domain.DDDUser;
import com.duke.loan_system.user_context.infrastructure.UserJpaEntity;

public record UserResponse(
        Long id,
        String  name,
        String phone
) {
    public static UserResponse from(DDDUser user){
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getPhone()
        );
    }
}
