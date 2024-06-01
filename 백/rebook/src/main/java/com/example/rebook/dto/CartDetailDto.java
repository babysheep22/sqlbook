package com.example.rebook.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CartDetailDto {

    private Long cartItemId;

    private String bookid;

    private int sell_price;

    private int count;

   // private String imgUrl;

    public CartDetailDto(Long cartItemId, String bookid, int sell_price,
                         int count){
        this.cartItemId = cartItemId;
        this.bookid = bookid;
        this.sell_price = sell_price;
        this.count = count;
        //this.imgUrl = imgUrl; 이미지주소 아직 구현안됨
    }
}
