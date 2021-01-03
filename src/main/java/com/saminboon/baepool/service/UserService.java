package com.saminboon.baepool.service;

import com.saminboon.baepool.domain.User;
import com.saminboon.baepool.domain.UserRepository;
import com.saminboon.baepool.dto.SignInRequest;
import com.saminboon.baepool.dto.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private JwtUtil jwtUtil; // jwt 생성, 검사
    @Autowired
    private UserRepository userRepository;

    public void signUp(SignUpRequest signUpRequest){

        // 중복된 가입자인지 체크
        checkAlreaySignUp(signUpRequest.getUser_id(), signUpRequest.getUser_passwd());

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
                    .user_token(jwtUtil.createToken()) // 토큰 생성해서 넣어줌
                    .build();

        if (userRepository.save(user) == null) {
            throw new IllegalArgumentException("가입에 실패하였습니다. 잠시 후 다시 가입해주세요.");
        }
    }

    public String signIn(SignInRequest signInRequest){

        List<User> userResults;
        userResults = userRepository.findByUserInfo(signInRequest.getUser_id(), signInRequest.getUser_passwd());
        if(userResults.isEmpty()) {
            throw new IllegalArgumentException("아이디와 비밀번호를 다시 확인해주세요");
        }else{
            String token = userResults.get(0).getUser_token();
            if(token == null || token.length() == 0){

                // 다시 토큰 생성

            }
            return token;
        }
    }

    private void checkAlreaySignUp(String user_id, String user_passwd) {
        if(userRepository.findByUserInfo(user_id,user_passwd) != null){
            throw new IllegalArgumentException("이미 가입된 사용자입니다.");
        }
    }
}
