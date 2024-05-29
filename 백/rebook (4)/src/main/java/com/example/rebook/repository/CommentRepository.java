package com.example.rebook.repository;

import com.example.rebook.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>{

    //게시글의 모든 댓글 조회
    @Query(value = "SELECT * " +
            "FROM comment " +
            "WHERE register_id" +
            "= :registerId",
            nativeQuery = true)
    List<Comment> findByRegisterId(Long registerId);


    //특정 닉네임의 모든 댓글 조회
    List<Comment> findByNickname(String nickname); //findBy메소드를 수행할 퀴리를 XML에 작성

}
