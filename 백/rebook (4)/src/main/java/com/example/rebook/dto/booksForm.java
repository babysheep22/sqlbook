package com.example.rebook.dto;

import com.example.rebook.entity.Register;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@AllArgsConstructor
@ToString
public class booksForm {

    private Long id;  //도서 등록 번호
    private Long book_id;  //책 ISBN

    private String book_image;  //책표지

    private String book_title;  //책 제목

    private String book_author;  //저자

    private String publisher;  //출판사

    private String pub_date; //출판일

    private String major_kategory;  //대분류

    private String minor_kategory;  //소분류

    private int list_price;  //정가

    private int sell_price; //판매가

    private String book_condition;  //책등급

    private String book_detail;  //책 상태 설명

    private String book_infor;  //책 내용

    private int purchase_price;  //매입가격


    //    롬복의 리팩터링기능으로 @AllArgsConstructor가 생성자가 자동으로 만들어져서 아래 것은 필요없게 됨
//    public booksForm(Long id, Long book_id, String book_title, String book_image, String book_author, String publisher, String pub_date, String register_date, String major_kategory, String minor_kategory, int list_price, int sell_price, String book_condition, String book_detail, String book_infor, int purchase_price) {
//        this.id = id;
//        this.book_id = book_id;
//        this.book_image = book_image;
//        this.book_title = book_title;
//        this.book_author = book_author;
//        this.publisher = publisher;
//        this.pub_date = pub_date;
//        this.major_kategory = major_kategory;
//        this.minor_kategory = minor_kategory;
//        this.list_price = list_price;
//        this.sell_price = sell_price;
//        this.book_condition = book_condition;
//        this.book_detail = book_detail;
//        this.book_infor = book_infor;
//        this.purchase_price = purchase_price;
//
//    }


    //   롬복의 리팩터링기능으로 @ToString어노테이션이 toString()메서드를 대체함
//    @Override
//    public String toString() {
//        return "booksForm{" +
//                "id=" + id +
//                "book_id=" + book_id +
//                "book_image=" + book_image +
//                ", book_title='" + book_title + '\'' +
//                ", book_author='" + book_author + '\'' +
//                ", publisher='" + publisher + '\'' +
//                ", pub_date='" + pub_date + '\'' +
//                ", major_kategory='" + major_kategory + '\'' +
//                ", minor_kategory='" + minor_kategory + '\'' +
//                ", list_price=" + list_price +
//                ", sell_price=" + sell_price +
//                ", book_condition='" + book_condition + '\'' +
//                ", book_detail='" + book_detail + '\'' +
//                ", book_infor='" + book_infor + '\'' +
//                ", purchase_price=" + purchase_price +
//                '}';
//    }

    public Register toEntity() {
        return new Register(id, book_id, book_image, book_title, book_author, publisher, pub_date, major_kategory, minor_kategory, list_price, sell_price, book_condition, book_detail, book_infor, purchase_price);
    }
}