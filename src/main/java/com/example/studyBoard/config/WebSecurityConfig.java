package com.example.studyBoard.config;

import com.example.studyBoard.service.MemberDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig {

    private final MemberDetailsService memberDetailsService;

    // 스프링 시큐리티 기능 비활성화
    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring()
                .requestMatchers(toH2Console())
                .requestMatchers("/static/**");
    }

    // 특정 HTTP 요청에 대한 웹 기반 보안 구성
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                // 인증, 인가 설정
                .authorizeRequests()  
                
                // requestMatchers : 특정요청과 일치하는 rul에 대한 엑세스 설정
                // permitAll: 누구나 접근이 가능하게 설정. 즉, "/login","/signup", "/user"로 요청이 오면 인증/인가 없이도 접근 가능
                .requestMatchers("/login", "/signup", "/user").permitAll()

                // anyRequest : 위에서 설정한 url 이외의 요청에 대해서 설정한다.
                // authenticated : 별도의 인가는 필요하지 않지만 인증이 성공된 상태여야 접근 가능하다.
                .anyRequest().authenticated()
                .and()

                // 폼 기반 로그인 설정
                .formLogin()

                // 로그인 페이지 경로를 설정한다.
                .loginPage("/login")

                // 로그인이 완료되었을 때 이동할 경로를 설정한다.
                .defaultSuccessUrl("/articles")
                .and()

                // 로그아웃 설정
                .logout()

                // 로그아웃이 완료되었을 때 이동할 경로를 설정한다.
                .logoutSuccessUrl("/login")

                // 로그아웃 이후에 세션을 전체 삭제할지 여부를 설정한다.
                .invalidateHttpSession(true)
                .and()

                // CSRF 공격 방지를 하기 위해선 활성화 하는게 좋음 (현재는 비활성화)
                .csrf().disable()
                .build();
    }

    // 인증 관리자 관련 설정
    // 사용자 정보를 가져올 서비스를 재정의하거나, 인증방법, 예)LDAP,JDBC기반 인증 등을 설정할 때 사용된다.
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, MemberDetailsService memberDetailsService) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                
                // 사용자 정보 서비스 설정
                // 설정하는 서비스 클래스는 반드시 MemberDetailsService를 상속받은 클래스 여야함
                .userDetailsService(memberDetailsService)

                // 비밀번호를 암호화하기 위한 인코더를 설정한다.
                .passwordEncoder(bCryptPasswordEncoder)
                .and()
                .build();
    }

    // 패스워드 인코더로 사용할 빈 등록
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
