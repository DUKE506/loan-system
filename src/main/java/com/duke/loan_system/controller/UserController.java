package com.duke.loan_system.controller;

import com.duke.loan_system.domain.User;
import com.duke.loan_system.dto.CreateUserDTO;
import com.duke.loan_system.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    // 사용자 생성
    @PostMapping("/create")
    public ResponseEntity<User> createUser (@RequestBody CreateUserDTO createUserDto) {
        System.out.println("===============================");
        System.out.println("[User][Controller] 사용자명 : "+createUserDto.getName());
        System.out.println("[User][Controller] 주민번호 : "+createUserDto.getRnn());
        User user = userService.createUser(createUserDto);
        return ResponseEntity.status(201).body(user);
    }
    // 사용자 전체 조회
    @GetMapping("/findAll")
    public List<User> findAllUser(){
        return userService.findAllUser();
    }

}
