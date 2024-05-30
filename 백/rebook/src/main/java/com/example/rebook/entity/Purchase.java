package com.example.rebook.entity;

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
public class Purchase extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //매입요청 번호

    @Column
    private String purImgs; //매입요청 도서 이미지들

    @Column
    private String purTitle; //매입 요청 책 제목

    @Column
    private String purAuthor;  //매입 요청 도서 저자


    @Column
    private String purPuB;  //매입 요청 도서 출판사

    @Column
    private String purPubDate;  //매입 요청 도서 출판일

    @Column
    private String purBookCondition;  //매입 요청 도서 상태(등급)

    @Column
    private String purBookDetail;  //매입 요청 도서 상태 설명(예상 등급)

    @Column
    private int purReqPrice;  //매입 요청 도서 판매자가 원하는 가격(예상 가격)


}
