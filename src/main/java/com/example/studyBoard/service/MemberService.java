package com.example.studyBoard.service;

import com.example.studyBoard.domain.Member;
import com.example.studyBoard.dto.AddMemberRequest;
import com.example.studyBoard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor  // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service  // 빈으로 등록
public class MemberService {

    @Autowired
    MemberRepository memberRepository;  // 빈 주입

    // 로그인 add
    public Member save(AddMemberRequest request) {
//        return MemberRepository.class (save(request.toEntity()));
        return memberRepository.save(request.toEntity());
    }

//    public List<Member> getAllMembers() {
//        return memberRepository.findAll();  //멤버 목록 얻기
//    }


}
