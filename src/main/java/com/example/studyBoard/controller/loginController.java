package com.example.studyBoard.controller;

import com.example.studyBoard.domain.Member;
import com.example.studyBoard.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
@RestController // HTTP Response Body에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
public class loginController {

    @Autowired
    MemberService memberService;

    @GetMapping("/test")
    public List<Member> getAllMembers() {
        List<Member> members = memberService.getAllMembers();
        return members;
    }

    @GetMapping("/login.html")
    public String login(Model model) throws Exception{
        return "test";
    }
}
