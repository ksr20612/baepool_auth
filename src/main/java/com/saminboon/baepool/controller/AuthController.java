package com.saminboon.baepool.controller;

import com.saminboon.baepool.dto.SignInRequest;
import com.saminboon.baepool.dto.SignUpRequest;
import com.saminboon.baepool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    public UserService userService;

    @GetMapping("/baepool")
    public String baepool(){
        return "baepool";
    }

    @GetMapping("/signUp")
    public String signUp(SignUpRequest signUpRequest){
        userService.signUp(signUpRequest);
        return "Baepool의 회원이 되신 것을 환영합니다.";
    }

    @GetMapping("/signIn")
    public String signIn(SignInRequest signInRequest){
        return userService.signIn(signInRequest); // return : null -> throw exception, o -> token 전달
    }
}
