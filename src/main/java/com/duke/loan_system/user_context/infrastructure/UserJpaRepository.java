package com.duke.loan_system.user_context.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository  extends JpaRepository<UserJpaEntity,Long> {

    Optional<UserJpaEntity> findByRnn(String rnn);
}
