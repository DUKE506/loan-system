package com.duke.loan_system.user_context.domain;



import com.duke.loan_system.user_context.infrastructure.UserJpaEntity;

import java.util.List;
import java.util.Optional;

public interface DDDUserRepository {

    // 사용자 조회
    Optional<DDDUser> findById(Long userId);

    // 사용자 조회(주민번호)
    Optional<DDDUser> findByRnn(String rnn);

    // 전체조회
    List<DDDUser> findAll();

    // 사용자 저장
    Long save(DDDUser user);
}
