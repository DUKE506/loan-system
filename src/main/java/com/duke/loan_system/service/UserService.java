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
        String createUserRnn = createUserDTO.getRnn();
//        System.out.println("[User][Service] 주민번호 : "+ createUserRnn);

        if(createUserName == "" || createUserName.isEmpty() ){
            throw new IllegalArgumentException("사용자명이 누락 되었습니다.");
        }
        if(createUserRnn == "" || createUserRnn.isEmpty() ){
            throw new IllegalArgumentException("주민번호가 누락 되었습니다.");
        }

        User createUser = new User();

        createUser.setName(createUserName);
        createUser.setRnn(createUserRnn);
        // 최초 생성시 C등급
        createUser.setCreditGrade(CreditGrade.C);

//        System.out.println("[User][Service] 생성 객체 주민번호 : "+ createUser.getRnn());


        return userRepository.save(createUser);
    }


}
