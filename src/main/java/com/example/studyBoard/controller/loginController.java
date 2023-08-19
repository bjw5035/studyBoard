package com.example.studyBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class loginController {

    @GetMapping("/login")
    public String login() {

//        Logger.info("test");
        return "login";
    }

//    @PostMapping("/login")
//    public String signup(AddMemberRequest request) {
////        memberService.save(request);  // 회원 가입 메서드 호출
//        return "redirect:/login";  // 회원 가입이 완료된 이후에 로그인 페이지로 이동
//    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
}
