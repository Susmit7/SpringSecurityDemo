package com.susmit.bankapp.repository;

import com.susmit.bankapp.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin,Long> {
    List<UserLogin> findByUsername(String username);
}
