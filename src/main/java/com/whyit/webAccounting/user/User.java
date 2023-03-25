package com.whyit.webAccounting.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User {
    @GetMapping("/user")
    public String findAll(){
        return "User page";
    }
}
