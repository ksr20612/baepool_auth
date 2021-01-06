package com.saminboon.baepool.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// jpa의 구현체임; CRUD 메서드 자동 생성
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findAllByUserIdAndUserPasswd(String id, String pw);
}
