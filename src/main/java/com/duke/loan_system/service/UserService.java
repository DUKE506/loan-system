package com.duke.loan_system.service;

import com.duke.loan_system.domain.CreditGrade;
import com.duke.loan_system.domain.User;
import com.duke.loan_system.dto.CreateUserDTO;
import com.duke.loan_system.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    //의존성 주입
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //전체 사용자조회
    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    //사용자 생성
    public User createUser(CreateUserDTO createUserDTO){
        String createUserName =createUserDTO.getName();
        if(createUserName == "" || createUserName.isEmpty() ){
            throw new IllegalArgumentException("사용자명이 누락 되었습니다.");
        }

        User createUser = new User();
        createUser.setName(createUserDTO.getName());
        // 최초 생성시 C등급
        createUser.setCreditGrade(CreditGrade.C);


        return userRepository.save(createUser);
    }


}
