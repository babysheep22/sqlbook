package com.example.rebook.dto;

import com.example.rebook.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CommentDto {

    private Long id;  //상품 고유 번호(도서 번호와는 다름)

    private Long registerId; //댓글이 달리는 상품id

    private String nickname; //댓글 단 사람

    private String body; //댓글

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd/HH:mm")  //초까지 나오게 하려면 맨 뒤에 /ss
    private LocalDateTime createdDate;

    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd/HH:mm") //초까지 나오게 하려면 맨 뒤에 /ss
    private LocalDateTime modifiedDate;

    public static CommentDto createCommentDto(Comment comment) {  //createCommentDto()는 객체 생성 없이 객체를 만드는 생성메서드
        return new CommentDto(
                comment.getId(),
                comment.getRegister().getId(),
                comment.getNickname(),
                comment.getBody(),
                comment.getCreatedDate(),
                comment.getModifiedDate()
        );
    }
}
