package com.saminboon.baepool.service;

import com.saminboon.baepool.domain.User;
import com.saminboon.baepool.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private JwtUtil jwtUtil; // jwt 생성, 검사
    @Autowired
    private UserRepository userRepository;

    public void signUp(SignUpRequest signUpRequest){

        User user = User.builder()
                .user_id(signUpRequest.getUser_id())
                .user_passwd(signUpRequest.getUser_passwd())
                .user_age(signUpRequest.getUser_age())
                .user_birthday(signUpRequest.getUser_birthday())
                .user_gender(signUpRequest.getUser_gender())
                .user_mail(signUpRequest.getUser_mail())
                .user_name(signUpRequest.getUser_name())
                .user_phone(signUpRequest.getUser_phone())
                .user_birthyear(signUpRequest.getUser_birthday())
                .comp_name(signUpRequest.getComp_name())
                .team_name(signUpRequest.getTeam_name())
                .build();
    }

}
