package com.example.studyBoard.dto;

import com.example.studyBoard.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor  // 기본 생성자 추가
@AllArgsConstructor  // 모든 필드 값을 파라미터로 받는 생성자 추가
@Getter
@Setter
public class AddMemberRequest {

    private String id;
    private String pw;

    public Member toEntity() {  // 생성자를 사용해 객체 생성
        return Member.builder()
                .id(id)
                .pw(pw)
                .build();
    }
}
