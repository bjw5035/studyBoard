package com.example.studyBoard.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "members")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor
@Getter
@Setter
@Entity  // 엔티티 지정
public class MemberEntity implements UserDetails {  // UserDetails를 상속받아 인증 객체로 사용

    @Id  // id 필드를  기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 자동으로 1씩 증가
    @Column(name = "id", updatable = false)  // 'id'라는 not null 컬럼과 매핑
    private String id;  // DB 테이블의 'id' 컬럼과 매칭

    @Column(name = "pw")
    private String pw;  // DB 테이블의 'pw' 컬럼과 매칭


    @Builder  // 빌더 패턴으로 객체 생성
    public MemberEntity(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public MemberEntity save(String id, String pw) {
        this.id = id;
        this.pw = pw;

        return save(id, pw);
    }

    @Override  // 권한 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("members"));
//        return null;
    }

    // 사용자의 패스워드 반환
    @Override
    public String getPassword() {
        return pw;
    }

    // 사용자의 id를 반환(고유한 값)
    @Override
    public String getUsername() {
        return id;
    }

    // 계정 만료 여부 반환
    @Override
    public boolean isAccountNonExpired() {
        // 만료되었는지 확인하는 로직
        return true;  // true -> 잠금되지 않았음을 뜻함
    }

    // 계정 잠금 여부 반환
    @Override
    public boolean isAccountNonLocked() {
        // 계정 잠금되었는지 확인하는 로직
        return true;  // true -> 잠금되지 않았음을 뜻함
    }

    // 패스워드의 만료 여부 반환
    @Override
    public boolean isCredentialsNonExpired() {
        // 패스워드가 만료되었는지 확인하는 로직
        return true;  // true -> 만료되지 않았음을 뜻함
    }

    // 계정 사용 가능 여부 반환
    @Override
    public boolean isEnabled() {
        // 계정이 사용 가능한지 확인하는 로직
        return true;  // true -> 사용 가능  
    }
}

