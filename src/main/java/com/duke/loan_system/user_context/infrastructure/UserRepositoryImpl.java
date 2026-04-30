package com.duke.loan_system.user_context.infrastructure;


import com.duke.loan_system.domain.User;
import com.duke.loan_system.user_context.domain.DDDUser;
import com.duke.loan_system.user_context.domain.DDDUserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements DDDUserRepository {

    private final UserJpaRepository userJpaRepository;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository){
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public List<DDDUser> findAll() {
        return userJpaRepository.findAll().stream().map(UserJpaEntity::toDomain).collect(Collectors.toList());
    }

    // 조회 구현체
    @Override
    public Optional<DDDUser> findById(Long userId) {
        return Optional.empty();
    }

    @Override
    public Optional<DDDUser> findByRnn(String rnn) {
        return userJpaRepository.findByRnn(rnn).map(UserJpaEntity::toDomain);
    }

    // 생성 구현체
    @Override
    public Long save(DDDUser user) {
        return userJpaRepository.save(UserJpaEntity.from(user)).getId();
    }
}
