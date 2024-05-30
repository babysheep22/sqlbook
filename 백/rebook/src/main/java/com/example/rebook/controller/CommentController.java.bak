package com.example.rebook.controller;

import com.example.rebook.Service.CommentService;
import com.example.rebook.dto.CommentDto;
import com.example.rebook.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    //댓글 조회
    @GetMapping("/books/{registerId}/comments")
    public ResponseEntity<List<CommentDto>> comments(@PathVariable Long registerId) {
        //서비스에 위임
        List<CommentDto> dtos = commentService.comments(registerId);
        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }


    @PostMapping("/books/{registerId}/comments")
    public ResponseEntity<CommentDto> create(@PathVariable Long registerId, @RequestBody CommentDto dto)
    {
        CommentDto createdDto = commentService.create(registerId, dto);

        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }


    //댓글수정
    @PatchMapping("/comments/{id}")  //여기서 id는 regiserId가 아니라 수정 댓글의 id
    public ResponseEntity<CommentDto> update(@PathVariable Long id, @RequestBody CommentDto dto) {
        CommentDto updatedDto = commentService.update(id, dto);

        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }

    //댓글 삭제
    @DeleteMapping("/comments/{id}")
    public ResponseEntity<CommentDto> delete(@PathVariable Long id) {
        CommentDto deletedDto = commentService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body(deletedDto);
    }
}
