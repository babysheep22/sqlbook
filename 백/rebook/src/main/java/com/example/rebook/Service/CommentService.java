package com.example.rebook.Service;

import com.example.rebook.dto.CommentDto;
import com.example.rebook.entity.Comment;
import com.example.rebook.entity.Register;
import com.example.rebook.repository.CommentRepository;
import com.example.rebook.repository.RegisterRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RegisterRepository regiRepository;



    //댓글 조회 요청
    public List<CommentDto> comments(Long registerId) {
        //댓글 조회
        List<Comment> comments = commentRepository.findByRegisterId(registerId);

        //엔티티 --> dto반환
        List<CommentDto> dtos = new ArrayList<CommentDto>();
        for (int i = 0; i < comments.size(); i++) { //조회한 댓글엔티티 수만큼 반복하기
            Comment c = comments.get(i); //조회한 댓글 엔티티 하나씩 가져오기
            CommentDto dto = CommentDto.createCommentDto(c);
            dtos.add(dto);
        }

        //결과 반환
        return commentRepository.findByRegisterId(registerId)//댓글 엔티티 목록 조회
                .stream() //댓글 엔티티목록을 스트림으로 변환
                .map(comment -> CommentDto.createCommentDto(comment))  //엔티티를 dto로 매핑
                .collect(Collectors.toList());  //스트림을 리스트로 변환
    }

    //게시글과 게시글에 댓글 달기
    @Transactional
    public CommentDto create(Long registerId, CommentDto dto) {

        //게시글 조회 및 예외 발생
        Register register = regiRepository.findById(registerId)
                .orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패!" + "대상 게시글이 없습니다."));

        //댓들 엔티티 생성
        Comment comment = Comment.createComment(dto, register);

        //댓글 엔티티 DB에 저장
        Comment created = commentRepository.save(comment);

        //DTO로 변환해 반환
        return CommentDto.createCommentDto(created);
    }


    //댓글 수정후 업데이트
    @Transactional
    public CommentDto update(Long id, CommentDto dto) {
        //1.댓글 조회 및 예외 발생
        Comment target = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("댓글 수정 실패!" +
                "대상 댓글이 없습니다."));

        //2. 댓글 수정
        target.patch(dto);

        //3. DB로 갱신
        Comment updated = commentRepository.save(target);

        //4. 댓글 엔티티를 DTO로 변환
        return CommentDto.createCommentDto(updated);
    }


    //댓글 삭제
    @Transactional
    public CommentDto delete(Long id) {
        //1.댓글 조회 및 예외 발생
        Comment target = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패! " + "대상이 없습니다."));

        //2. 댓글 삭제
        commentRepository.delete(target);

        //3. 삭제 댓글을 dto로 변환 및 반환
        return CommentDto.createCommentDto(target);
    }
}

