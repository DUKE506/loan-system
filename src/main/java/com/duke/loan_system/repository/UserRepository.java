package com.duke.loan_system.repository;

import com.duke.loan_system.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    //주민번호로 조회
    Optional<User> findByRnn(String rnn);


}
