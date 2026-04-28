package com.duke.loan_system.service;

import com.duke.loan_system.domain.CreditGrade;
import com.duke.loan_system.domain.User;
import com.duke.loan_system.dto.user.CreateUserDTO;
import com.duke.loan_system.dto.user.ResponseUserDTO;
import com.duke.loan_system.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserService {
    //의존성 주입
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //전체 사용자조회
    public List<ResponseUserDTO> findAllUser(){
        log.info("[User][Service] 전체 조회");
        List<User> users = userRepository.findAll();

        // dto 생성자에서 User 객체를 받아서 한번에 생성. 또는 @Builder어노테이션 사용
        List<ResponseUserDTO> responseUsers = users.stream().map(user -> {
            ResponseUserDTO responseUser = new ResponseUserDTO();
            responseUser.setId(user.getId());
            responseUser.setName(user.getName());
            responseUser.setCreditGrade(user.getCreditGrade());
            responseUser.setBalance(user.getBalance());
            return responseUser;
        }).collect(Collectors.toList());

        return responseUsers;
    }

    //사용자 생성
    public ResponseUserDTO createUser(CreateUserDTO createUserDTO){
        String createUserName =createUserDTO.getName();
        String createUserRnn = createUserDTO.getRnn();


        if(createUserName.isBlank()){
            throw new IllegalArgumentException("사용자명이 누락 되었습니다.");
        }
        if(createUserRnn.isBlank()){
            throw new IllegalArgumentException("주민번호가 누락 되었습니다.");
        }

        User createUser = new User();

        createUser.setName(createUserName);
        createUser.setRnn(createUserRnn);
        // 최초 생성시 C등급
        createUser.setCreditGrade(CreditGrade.C);

        User createdUser = userRepository.save(createUser);

        ResponseUserDTO responseUser = new ResponseUserDTO(createdUser);


        return responseUser;
    }
}
