package com.example.studyBoard.service;

import com.example.studyBoard.domain.Member;

public interface MemberDetailService {
    // 사용자 이름(email)으로 사용자의 정보를 가져오는 메서드
    Member loadMemberByUsername(String id);
}
