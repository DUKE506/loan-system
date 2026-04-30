package com.duke.loan_system.user_context.application;


import com.duke.loan_system.user_context.application.command.CreateUserCommand;
import com.duke.loan_system.user_context.application.command.UserResponse;
import com.duke.loan_system.user_context.domain.DDDUser;
import com.duke.loan_system.user_context.domain.DDDUserRepository;
import com.duke.loan_system.user_context.domain.UserDomainService;
import com.duke.loan_system.user_context.infrastructure.UserJpaEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DDDUserService {

    private final UserDomainService userDomainService;
    private final DDDUserRepository dddUserRepository;

    public DDDUserService (UserDomainService userDomainService,DDDUserRepository dddUserRepository){
        this.userDomainService = userDomainService;
        this.dddUserRepository = dddUserRepository;

    }

//    사용자 생성
    @Transactional
    public Long createUser(CreateUserCommand createUserCommand){

        /// 1. 사용자 중복확인
        userDomainService.validateDuplicateRnn(createUserCommand.rnn());

        /// 2. 객체 생성
        DDDUser user = DDDUser.createUser(createUserCommand.name(), createUserCommand.rnn(), createUserCommand.phone());

        /// 3. 저장
        return dddUserRepository.save(user);
    }

//    사용자 전체 조회
    public List<UserResponse> findAll(){

        return dddUserRepository.findAll().stream()
                .map(UserResponse::from).toList();
    }
}
