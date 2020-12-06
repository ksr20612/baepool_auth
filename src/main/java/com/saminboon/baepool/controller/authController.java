package com.saminboon.baepool.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class authController {

    @GetMapping("/baepool")
    public String baepool(){
        return "baepool";
    }

    @GetMapping("/signUp")
    public String signUp(){
        return "signUp";
    }

    @GetMapping("/signIn")
    public String signIn(){
        return "signIn";
    }
}
