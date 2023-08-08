package com.example.studyBoard.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class loginController {

    @GetMapping("/login")
    @ResponseBody
    public String login(Model model) throws Exception{
        return "login.html";
    }
}
