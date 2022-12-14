package com.example.securitydb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // html 표시
//@RestController = 글자 등..
public class UserController {
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/users")
    public String users(){
        return "users";
    }
}
