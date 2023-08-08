package com.example.studyBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class loginController {

    @GetMapping("/login.html")
    @ResponseBody
    public String login(Model model) throws Exception{
        return "test";
    }
}
