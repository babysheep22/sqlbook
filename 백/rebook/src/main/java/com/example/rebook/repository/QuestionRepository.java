package com.example.rebook.repository;

import com.example.rebook.entity.Question;
import com.example.rebook.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
   //모든 질문게시글 조회
    @Query(value = "SELECT * " +
            "FROM question " +
            "WHERE memberid" +
            "= :memberId",
            nativeQuery = true)

    List<Question> findByMemberId(Long memberId);
}
