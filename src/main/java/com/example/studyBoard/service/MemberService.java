package com.example.studyBoard.service;

import com.example.studyBoard.domain.Member;
import com.example.studyBoard.dto.AddMemberRequest;
import com.example.studyBoard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor  // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service  // 빈으로 등록
public class MemberService {

    @Autowired
    MemberRepository memberRepository;  // 빈 주입


    // 로그인 추가
    public Member save(AddMemberRequest request) {
        return memberRepository.save(request.toEntity());
    }

    // JPA 지원 메서드인 findAll()을 호출해 Member 테이블에 저장되어 있는 모든 데이터 조회
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

}
