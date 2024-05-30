package com.example.rebook.Service;

import com.example.rebook.dto.QuestionForm;
import com.example.rebook.entity.Member;
import com.example.rebook.entity.Question;
import com.example.rebook.repository.MemberRepository;
import com.example.rebook.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private MemberRepository memberRepository;

    //질문게시글 생성
    @Transactional
    public QuestionForm create(Long memberId, QuestionForm form) {

        //질문게시글 조회 및 예외 발생
        Member member = memberRepository.findById(memberId)
                .orElseThrow(()  -> new IllegalArgumentException("게시글 생성 실패!" + "대상 회원 번호가 없습니다."));

        //회원번호로 질문 게시글 엔티티 생성
        Question question = Question.createQuestion(form, member);

        //질문 게시글 엔티티 db에 저장
        Question created = questionRepository.save(question);

        //form으로 변환해 반환
        return QuestionForm.createQuestionForm(created);
    }

    //질문게시글 조회 요청
    public List<QuestionForm> questions(Long memberId) {
        //질문게시글 조회
        List<Question> questions = questionRepository.findByMemberId(memberId);

        //엔티티 --> 폼 반환
        List<QuestionForm> forms = new ArrayList<QuestionForm>();
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            QuestionForm form = QuestionForm.createQuestionForm(q);
            forms.add(form);
        }

        //결과 반환
        return questionRepository.findByMemberId(memberId)
                .stream()
                .map(question -> QuestionForm.createQuestionForm(question))
                .collect(Collectors.toList());
    }



    //질문게시글 수정후 업데이트
    @Transactional
    public QuestionForm update(Long id, QuestionForm form) {
        //1.질문게시글 조회 및 예외 발생
        Question target = questionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("댓글 수정 실패!" + "대상 회원번호가 없습니다."));

        //2. 질문게시글 수정
        target.patch(form);

        //3. DB로 갱신
        Question updated = questionRepository.save(target);

        //4. 질문게시글 엔티티를 form으로 변환
        return QuestionForm.createQuestionForm(updated);
    }

    @Transactional
    public QuestionForm delete(Long id) {

        //1.질문게시글 조회 및 예외 발생
        Question target = questionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("질문게시글 수정 실패!" + "대상이 없습니다."));

        //2. 질문게시글 삭제
        questionRepository.delete(target);

        //3. 삭제 댓글을 form으로 변환 및 반환
        return QuestionForm.createQuestionForm(target);
    }

}
