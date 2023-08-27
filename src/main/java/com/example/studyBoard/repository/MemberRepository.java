package com.example.studyBoard.repository;

import com.example.studyBoard.domain.MemberEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/*
* 이 인터페이스는 DB에서 데이터를 가져오는 퍼시스턴트 계층 역할
* member이름의 테이블에 접근해 Member클래스에 매핑하는 구현체
* <엔티티 이름, 엔티티 기본키의 타입>
* */
@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, String> {
    Optional<MemberEntity> findById(String id);  // id로 사용자 정보를 가져옴

//    Optional<MemberEntity> save(String id, String pw);

    @Override
    <S extends MemberEntity> List<S> saveAll(Iterable<S> entities);
}
