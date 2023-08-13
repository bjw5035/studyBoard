package com.example.studyBoard.service;

import com.example.studyBoard.domain.Member;
import com.example.studyBoard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
// 스프링 시큐리티에서 사용자 정보를 가져오는 인터페이스
public class MemberDetailsService implements MemberDetailService{

    private final MemberRepository memberRepository;

    // 사용자 이름(email)으로 사용자의 정보를 가져오는 메서드
    @Override
    public Member loadMemberByUsername(String id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException((id)));
    }

}