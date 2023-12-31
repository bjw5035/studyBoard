package com.example.studyBoard.controller;

import com.example.studyBoard.domain.MemberEntity;
import com.example.studyBoard.dto.AddMemberRequest;
import com.example.studyBoard.repository.MemberRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest  // 테스트용 애플리케이션 컨텍스트
@AutoConfigureMockMvc  // MockMVC 생성 및 자동 구성
class loginApiControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper; // 직렬화, 역직렬화를 위한 클래스

    @Autowired
    private WebApplicationContext context;

    @Autowired
    MemberRepository memberRepository;

    @BeforeEach  // 테스트 실행 전 실행하는 메서드
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
//        MemberRepository.deleteAll();
    }

    @DisplayName("addMember : 로그인 성공한다.")
    @Test
    public void addMember() throws Exception {
        // given
        final String url = "/api/login";
        final String id = "id";
        final String pw = "pw";
        final AddMemberRequest userRequest = new AddMemberRequest(id, pw);

        // 객체 JSON으로 직렬화
        final String requestBody = objectMapper.writeValueAsString(userRequest);

        // when
        // 설정한 내용을 바탕으로 요청 전송
        ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody));

        // then
        result.andExpect(status().isCreated());

        List<MemberEntity> memberEntities = memberRepository.findAll();

        assertThat(memberEntities.size()).isEqualTo(1);  // 크기가 1인지 검증
        assertThat(memberEntities.get(0).getId()).isEqualTo(id);
        assertThat(memberEntities.get(0).getPw()).isEqualTo(pw);

    }

}