package com.saminboon.baepool.controller;

import com.saminboon.baepool.dto.SignInRequest;
import com.saminboon.baepool.dto.SignUpRequest;
import com.saminboon.baepool.dto.Tokens;
import com.saminboon.baepool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AuthController {

    @Autowired
    public UserService userService;

    @RequestMapping(value="/baepool")
    public String baepool(){
        return "index.html";
    }

    @RequestMapping(value="/join")
    public String join() {
        return "information.html";
    }

    @GetMapping("/signUp")
    public String signUp(SignUpRequest signUpRequest){
        userService.signUp(signUpRequest);
        return "Baepool의 회원이 되신 것을 환영합니다.";
    }

    @GetMapping("/signIn")
    public Tokens signIn(SignInRequest signInRequest){
        return userService.signIn(signInRequest); // return : null -> throw exception, o -> token 전달
    }
}
