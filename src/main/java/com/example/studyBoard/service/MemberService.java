package com.example.studyBoard.service;

import com.example.studyBoard.domain.MemberEntity;
import com.example.studyBoard.dto.AddMemberRequest;
import com.example.studyBoard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor  // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service  // 빈으로 등록
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;  // 빈 주입
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    // 로그인 추가
    public String save(AddMemberRequest dto) {
        log.info("dto", dto);
        return memberRepository.save(dto.toEntity()).getId();
//        return memberRepository.save(Member.builder()
//                .id(dto.getId())
//                // 패스워드 암호화
//                // 패스워드 저장 시 시큐리티를 설정하며 패스워드 인코딩용으로 등록한 빈을 사용해서 암호화한 후 저장한다.
//                .pw(bCryptPasswordEncoder.encode(dto.getPw()))
//                .build()).getId();
    }

    // JPA 지원 메서드인 findAll()을 호출해 Member 테이블에 저장되어 있는 모든 데이터 조회
    public List<MemberEntity> findAll() {
        return memberRepository.findAll();
    }

}
