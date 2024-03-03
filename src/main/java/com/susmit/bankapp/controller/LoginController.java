package com.susmit.bankapp.controller;

import com.susmit.bankapp.dtos.RegisterUserRequestDTO;
import com.susmit.bankapp.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class LoginController {

    private LoginService loginService;

    @Autowired
    LoginController(LoginService loginService){
        this.loginService=loginService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody RegisterUserRequestDTO registerUserRequestDTO){
        ResponseEntity<String> response;
        try{
        loginService.registerUser(registerUserRequestDTO);
        response= ResponseEntity.status(HttpStatus.CREATED).body("User Registration Successful");

        }catch (Exception ex){
            response=ResponseEntity.internalServerError().body("Internal Server Error : "+ex.getMessage());

        }
        return response;
    }
}
