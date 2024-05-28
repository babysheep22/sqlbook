package com.example.rebook.entity;

import com.example.rebook.dto.CommentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  //상품 고유 번호(도서 번호와는 다름)

    @ManyToOne  //상품과 댓글의 다대일 관계
    @JoinColumn(name = "register_id") //외래키 생성, 레지스터 엔티티의 기본키(id)와 매핑
    private Item register; //댓글이 달리는 상품

    @Column
    private String nickname; //댓글 단 사람

    @Column
    private String body; //댓글

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd/HH:mm")  //초까지 나오게 하려면 맨 뒤에 /ss
    private LocalDateTime createdDate;

    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd/HH:mm") //초까지 나오게 하려면 맨 뒤에 /ss
    private LocalDateTime modifiedDate;

    public static Comment createComment(CommentDto dto, Item register) {
        //예외 발생
        if (dto.getId() !=null)
            throw new IllegalArgumentException("댓글 생성 실패! 댓글의 id가 없어야 합니다.");
        if (dto.getRegisterId() != register.getId())
            throw new IllegalArgumentException("댓글 생성 실패! 게시글의 id가 잘못되었습니다.");

        //엔티티 생성 및 반환
        return new Comment(
                dto.getId(),
                register,
                dto.getNickname(),
                dto.getBody(),
                dto.getCreatedDate(),
                dto.getModifiedDate()
        );
    }

    public void patch(CommentDto dto) {
        //예외 발생
        if (this.id != dto.getId())
            throw new IllegalArgumentException("댓글 수정 실패! 잘못된 id가 입력되었습니다.");

        //객체 갱신
        if (dto.getNickname() !=null) //수정할 닉네임 데이터가 있다면
            this.nickname = dto.getNickname();
        if (dto.getBody() != null)  //수정할 본문 데이터가 있다면
            this.body = dto.getBody(); //내용 반영
    }
}


