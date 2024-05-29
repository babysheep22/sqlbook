package com.example.rebook.dto;

import com.example.rebook.entity.Member;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class membersForm {
  private Long id; //회원 번호


  private String member_id; //회원 아이디


  private String member_name;  //회원 이름


  private String member_mail;  //회원 이메일


  private String member_password;  //회원 비밀번호


  private String member_nickname;  //회원 닉네임


  private String bank_name;  //회원 환불계좌은행


  private String bankAccount;  //회원 환불계좌번호


  private String member_phone;  //회원 연락처


  private String member_addr;  //회원 주소


  private String postcode;  //회원 우편번호


  private String member_addr_2;  //회원 상세주소


  private String recommend_id;  //추천인 아이디

  private String member_detail;  //추천인 아이디

  private String e_money;  //추천인 아이디

  private String member_role;  //사용자 권한

  private String member_mileage;  //적립금

  public Member toEntity() {
    return new Member(id, member_id, member_name, member_mail, member_password, member_nickname, bank_name, bankAccount, member_phone, member_addr, postcode, member_addr_2, recommend_id, member_detail, e_money, member_role, member_mileage);
  }
}
