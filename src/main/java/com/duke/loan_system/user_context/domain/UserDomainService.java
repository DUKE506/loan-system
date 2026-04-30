package com.duke.loan_system.user_context.domain;

import org.springframework.stereotype.Service;

@Service
public class UserDomainService {

    private final DDDUserRepository dddUserRepository;
    public UserDomainService(DDDUserRepository dddUserRepository){
        this.dddUserRepository = dddUserRepository;
    }

//    중복확인
    public void validateDuplicateRnn(String rnn){
        if(dddUserRepository.findByRnn(rnn).isPresent()){
            throw new IllegalArgumentException("이미 가입된 사용자입니다.");
        }
    }
}
