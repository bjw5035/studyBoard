package com.example.studyBoard.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.Builder;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor
@Getter
@Setter
@Entity  // 엔티티 지정
public class Member {

    @Id  // id 필드를  기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 자동으로 1씩 증가
    @Column(name = "id", updatable = false)  // 'id'라는 not null 컬럼과 매핑
    private String id;  // DB 테이블의 'id' 컬럼과 매칭

    @Column(name = "pw", nullable = false)
    private String pw;  // DB 테이블의 'pw' 컬럼과 매칭


    @Builder  // 빌더 패턴으로 객체 생성
    public Member(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public void save(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

}
