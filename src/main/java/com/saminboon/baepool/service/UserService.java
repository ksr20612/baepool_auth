package com.saminboon.baepool.service;

import com.saminboon.baepool.domain.User;
import com.saminboon.baepool.domain.UserRepository;
import com.saminboon.baepool.dto.SignInRequest;
import com.saminboon.baepool.dto.SignUpRequest;
import com.saminboon.baepool.dto.Tokens;
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
                    .userId(signUpRequest.getUser_id())
                    .userPasswd(signUpRequest.getUser_passwd())
                    .userAge(signUpRequest.getUser_age())
                    .userBirthday(signUpRequest.getUser_birthday())
                    .userGender(signUpRequest.getUser_gender())
                    .userMail(signUpRequest.getUser_mail())
                    .userName(signUpRequest.getUser_name())
                    .userPhone(signUpRequest.getUser_phone())
                    .userBirthyear(signUpRequest.getUser_birthday())
                    .compName(signUpRequest.getComp_name())
                    .teamName(signUpRequest.getTeam_name())
                    .userToken(jwtUtil.createRefreshToken(signUpRequest.getUser_id())) // 토큰 생성해서 넣어줌
                    .userImg(signUpRequest.getUser_img())
                    .userRole(signUpRequest.getUser_role())
                    .build();

        if (userRepository.save(user) == null) {
            throw new IllegalArgumentException("가입에 실패하였습니다. 잠시 후 다시 가입해주세요.");
        }
    }

    public Tokens signIn(SignInRequest signInRequest){

        List<User> userResults;
        String refreshToken;
        String accessToken;

        // refresh Token 가져오기
        userResults = userRepository.findAllByUserIdAndUserPasswd(signInRequest.getUser_id(), signInRequest.getUser_passwd());
        if(userResults.isEmpty()) {
            throw new IllegalArgumentException("NO id and Passwd matching");
        }else{
            refreshToken = userResults.get(0).getUserToken();
            if(refreshToken == null || refreshToken.length() == 0){

                // refreshToken이 없을 경우 다시 refreshToken 생성

            }
        }

        // access Token 생성하기
        accessToken = jwtUtil.createAccessToken(signInRequest.getUser_id());

        return Tokens.builder()
                .refreshToken(refreshToken)
                .accessToken(accessToken)
                .build();
    }

    private void checkAlreaySignUp(String user_id, String user_passwd) {
        if(userRepository.findAllByUserIdAndUserPasswd(user_id,user_passwd) != null){
            throw new IllegalArgumentException("이미 가입된 사용자입니다.");
        }
    }
}
