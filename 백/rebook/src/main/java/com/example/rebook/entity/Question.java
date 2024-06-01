package com.example.rebook.entity;

import com.example.rebook.dto.QuestionForm;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //질문게시판 번호

    @ManyToOne
    @JoinColumn(name = "memberid")
    private Member member;

    @Column
    private String qna_title; //질문게시판 제목

    @Column
    private String qna_content; //질문 내용

    public static Question createQuestion(QuestionForm form, Member member) {
        //예외 발생
        if (form.getId() != null)
            throw new IllegalArgumentException("질문게시글 생성 실패! 질문게시글의 id가 없어야 합니다.");
        if (form.getMemberid() !=member.getId())
        throw new IllegalArgumentException("댓글 생성 실패! 게시글의 id가 잘못되었습니다.");

        return new Question(
                form.getId(),
                member,
                form.getQna_title(),
                form.getQna_content()
        );
    }

    public void patch(QuestionForm form) {
        //예외 발생
        if (this.id != form.getId())
            throw new IllegalArgumentException("질문게시글 수정 실패! 잘못된 id가 입력되었습니다.");

        //객체 갱신
        if (form.getQna_title() != null) //수정할 닉네임 데이터가 있다면
            this.qna_title = form.getQna_title();
        if (form.getQna_content() !=null) //수정할 본문 데이터가 있다면
            this.qna_content = form.getQna_content(); //내용 반영
    }


}
