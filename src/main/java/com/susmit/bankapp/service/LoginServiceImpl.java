package com.susmit.bankapp.service;

import com.susmit.bankapp.dtos.RegisterUserRequestDTO;
import com.susmit.bankapp.entity.UserLogin;
import com.susmit.bankapp.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService{

    private UserLoginRepository userLoginRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    LoginServiceImpl(UserLoginRepository userLoginRepository, PasswordEncoder passwordEncoder){
        this.userLoginRepository=userLoginRepository;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public void registerUser(RegisterUserRequestDTO registerUserRequestDTO) {
        List<UserLogin> userLogins=userLoginRepository.findByUsername(registerUserRequestDTO.getUsername());
        if(!userLogins.isEmpty()){
            throw new RuntimeException("User already exists : "+userLogins.get(0).getUsername());
        }
        String password=passwordEncoder.encode(registerUserRequestDTO.getPassword());
        UserLogin userLogin=UserLogin.builder()
                .username(registerUserRequestDTO.getUsername())
                .password(password)
                .permissions("read")
                .build();
        userLoginRepository.save(userLogin);
    }
}
