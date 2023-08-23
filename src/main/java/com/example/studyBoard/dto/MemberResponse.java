package com.example.studyBoard.dto;

import com.example.studyBoard.domain.MemberEntity;
import lombok.Getter;

@Getter
public class MemberResponse {

    private final String id;
    private final String pw;

    // 엔티티를 인수로 받는 생성자 추가
    public MemberResponse(MemberEntity memberEntity) {
        this.id = memberEntity.getId();
        this.pw = memberEntity.getPw();
    }
}
