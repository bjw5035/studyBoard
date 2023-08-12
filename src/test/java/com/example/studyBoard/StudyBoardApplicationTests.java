package com.example.studyBoard;

import com.example.studyBoard.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class StudyBoardApplicationTests {

	@Autowired
	protected MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private MemberRepository memberRepository;

	@BeforeEach  // 테스트 실행 전 실행하는 메서드
	public void mockMvcSetUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@AfterEach
	public void cleanUp() {
		memberRepository.deleteAll();
	}

	@DisplayName("getAllMembers: 아티클 조회에 성공한다.")
	@Test
	public void getAllMembers() throws Exception {

		// given
		final String url = "/test";
//		Member savedMember = memberRepository.save(new Member(2, "test1"));

		// when
//		final ResultActions result = mockMvc.perform(get(url) // 1
//				.accept(MediaType.APPLICATION_JSON)); // 2

		// then
//		result
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$[0].id").value(savedMember.getId()))
//				.andExpect(jsonPath("$[0].name").value(savedMember.getName()));
	}

//	void contextLoads() {
//	}

}
