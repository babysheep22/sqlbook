package com.example.rebook.dto;


import com.example.rebook.entity.BaseTimeEntity;
import com.example.rebook.entity.Purchase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@AllArgsConstructor
@Getter
@ToString
public class purchaseForm extends BaseTimeEntity {

    private Long id; //매입요청 번호

   private String purImgs; //매입요청 도서 표지

   private String purTitle; //매입 요청 책 제목

    private String purAuthor;  //매입 요청 도서 저자

    private String purPuB;  //매입 요청 도서 출판사

    private String purPubDate;  //매입 요청 도서 출판일

     private String purBookCondition;  //매입 요청 도서 상태(등급)

    private String purBookDetail;  //매입 요청 도서 상태 설명

    private int purReqPrice;  //매입 요청 도서 판매자가 원하는 가격


    public Purchase toEntity() {
        return new Purchase(id, purImgs, purTitle, purAuthor, purPuB, purPubDate,  purBookCondition, purBookDetail, purReqPrice);
    }


    public static purchaseForm createpurchaseForm(Purchase purchase) {  //createCommentDto()는 객체 생성 없이 객체를 만드는 생성메서드
        return new purchaseForm(
                purchase.getId(),
                purchase.getPurImgs(),
                purchase.getPurTitle(),
                purchase.getPurAuthor(),
                purchase.getPurPuB(),
                purchase.getPurPubDate(),
                purchase.getPurBookCondition(),
                purchase.getPurBookDetail(),
                purchase.getPurReqPrice()
        );
    }
}