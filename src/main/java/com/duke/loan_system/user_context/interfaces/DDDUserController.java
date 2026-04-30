package com.duke.loan_system.user_context.interfaces;

import com.duke.loan_system.user_context.application.DDDUserService;
import com.duke.loan_system.user_context.application.command.UserResponse;
import com.duke.loan_system.user_context.interfaces.dto.CreateUserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ddd-users")
public class DDDUserController {

    private final DDDUserService dddUserService;

    public DDDUserController(DDDUserService dddUserService){
        this.dddUserService = dddUserService;
    }

    //사용자가입
    @PostMapping()
    public ResponseEntity<Long> createUser(@RequestBody CreateUserRequest createUserRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(dddUserService.createUser(createUserRequest.toCommand()));
    }

    //사용자 전체 조회
    @GetMapping()
    public ResponseEntity<List<UserResponse>> findAll(){
        return ResponseEntity.ok(dddUserService.findAll());
    }
}
