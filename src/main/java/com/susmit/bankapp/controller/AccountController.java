package com.susmit.bankapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class AccountController {

    @GetMapping("/accounts")
    public String getAccounts(){
        return "Accounts";
    }
}
