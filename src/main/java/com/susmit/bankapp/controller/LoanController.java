package com.susmit.bankapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class LoanController {

    @GetMapping("/loans")
    public String getLoans(){
        return "Loans";
    }
}
