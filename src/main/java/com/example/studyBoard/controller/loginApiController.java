package com.example.studyBoard.controller;

import com.example.studyBoard.dto.AddMemberRequest;
import com.example.studyBoard.dto.MemberResponse;
import com.example.studyBoard.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController // HTTP Response Body에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
public class loginApiController {

    private final MemberService memberService;

    @PostMapping("/api/login")
    public String signup(AddMemberRequest request) {
        memberService.save(request);  // 회원 가입 메서드 호출
        return "redirect:/login";  // 회원 가입이 완료된 이후에 로그인 페이지로 이동
    }
    
//    @PostMapping("/api/login")  // HTTP 메서드가 POST일 때 전달받은 URL과 동일하면 메서드로 매핑
//    // @RequestBody로 요청 본문 값 매핑
//    public ResponseEntity<Member> addLoin(@RequestBody AddMemberRequest request) {
//        Member saveMember = memberService.save(request);
//
//        // 요청한 자원이 성공적으로 생성되었으며 저장된 블로그 글 정보를 응답 객체에 담아 전송
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(saveMember);
//    }

    @GetMapping("/api/login")
    public ResponseEntity<List<MemberResponse>> findAllMembers() {
        List<MemberResponse> memberResponses = memberService.findAll()
                .stream()
                .map(MemberResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(memberResponses);

    }


    // ----------------------------------------------test

    //    @Autowired
//    MemberService memberService;

//    @GetMapping("/test")
//    public List<Member> getAllMembers() {
//        List<Member> members = memberService.save();
//        return members;
//    }
//
//    @GetMapping("/login_bak.html")
//    public String login(Model model) throws Exception{
//        return "test";
//    }
}
