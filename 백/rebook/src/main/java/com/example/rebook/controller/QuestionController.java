package com.example.rebook.controller;

import com.example.rebook.Service.QuestionService;
import com.example.rebook.dto.QuestionForm;
import com.example.rebook.dto.purchaseForm;
import com.example.rebook.entity.Purchase;
import com.example.rebook.entity.Question;
import com.example.rebook.repository.PurchaseRepository;
import com.example.rebook.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    //질문 게시판 요청
    @GetMapping("/question/{memberId}/qnaBoard")
    public ResponseEntity<List<QuestionForm>> questions(@PathVariable Long memberId) {
        //서비스에 위임
        List<QuestionForm> forms = questionService.questions(memberId);
        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(forms);
    }


    //질문게시글 생성
    @PostMapping("/question/{memberId}/qnaBoard")
    public ResponseEntity<QuestionForm> create(@PathVariable Long memberId, @RequestBody QuestionForm form)
    {
        QuestionForm createdForm = questionService.create(memberId, form);
        return ResponseEntity.status(HttpStatus.OK).body(createdForm);
    }


    //질문게시글 수정
    @PostMapping("/question/{Id}")
    public ResponseEntity<QuestionForm> update(@PathVariable Long id, @RequestBody QuestionForm form) {
        QuestionForm updatedForm = questionService.update(id, form);

        return ResponseEntity.status(HttpStatus.OK).body(updatedForm);
    }

    @DeleteMapping("/question/{Id}")
    public ResponseEntity<QuestionForm> delete(@PathVariable Long id) {
        QuestionForm deletedForm = questionService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body(deletedForm);
    }



}
