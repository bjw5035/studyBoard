package com.example.studyBoard.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController // HTTP Response Body에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
public class loginController {

    @GetMapping("/login.html")
    public String login(Model model) throws Exception{
        return "test";
    }
}
