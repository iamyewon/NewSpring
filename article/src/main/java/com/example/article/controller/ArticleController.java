package com.example.article.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// 그냥 Controller 는 html을 띄우는 용도
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("/write")
    public String writeForm(){
        return "write"; // 그냥 Controller이기 때문에 write.html 을 띄워줌
    }


}
