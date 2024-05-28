package com.example.rebook.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@AllArgsConstructor
@Getter
@Entity
@NoArgsConstructor
public class Item extends BaseTimeEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long book_id;


    @Column
    private String book_image;


    @Column //책 제목
    private String book_title;

    @Column //저자
    private String book_author;

    @Column //출판사
    private String publisher;

    @Column //출판일
    private String pub_date;

    @Column //대분류
    private String major_kategory;

    @Column //소분류
    private String minor_kategory;

    @Column // 정가
    private int list_price;

    @Column //판매가
    private int sell_price;

    @Column //책 상태
    private String book_condition;

    @Column
    private String book_detail;

    @Column
    private String book_infor;

    @Column
    private int purchase_price;



}

