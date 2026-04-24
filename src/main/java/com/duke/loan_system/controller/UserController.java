package com.duke.loan_system.controller;

import com.duke.loan_system.domain.User;
import com.duke.loan_system.dto.user.CreateUserDTO;
import com.duke.loan_system.dto.user.ResponseUserDTO;
import com.duke.loan_system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    // 사용자 생성
    // POST : /users
    @PostMapping()
    public ResponseEntity<User> createUser (@RequestBody CreateUserDTO createUserDto) {
        log.info("===============================");
        log.info("[User][Controller] 사용자명 : "+createUserDto.getName());
        log.info("[User][Controller] 주민번호 : "+createUserDto.getRnn());

        User user = userService.createUser(createUserDto);
        return ResponseEntity.status(201).body(user);
    }
    // 사용자 전체 조회
    // GET : /users
    @GetMapping()
    public ResponseEntity<List<ResponseUserDTO>> findAllUser(){
        log.info("===============================");
        log.info("[User][Controller] 전체 조회");
        List<ResponseUserDTO> users = userService.findAllUser();
        return ResponseEntity.ok(users);
    }


    // 단일 조회
    // GET : /users/{rnn}
    @GetMapping("{rnn}")
    public void findUserByRnn(@PathVariable("rnn") String rnn){
        log.info("===============================");
        log.info("[User][Controller] 주민번호 : "+rnn);

    }

}
