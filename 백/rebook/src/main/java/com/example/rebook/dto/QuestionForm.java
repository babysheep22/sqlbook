package com.example.rebook.dto;

import com.example.rebook.entity.Member;
import com.example.rebook.entity.Question;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class QuestionForm {


    private Long id; //질문게시판 번호

    private Long memberid;

    private String qna_title; //질문게시판 제목


    private String qna_content; //질문 내용

    public static QuestionForm createQuestionForm(Question question) {
        return new QuestionForm(
                question.getId(),
                question.getMember().getId(),
                question.getQna_title(),
                question.getQna_content()
        );
    }


}

