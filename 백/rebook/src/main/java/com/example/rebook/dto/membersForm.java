package com.example.rebook.dto;

import com.example.rebook.entity.Member;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class membersForm {
  private Long id; //회원 번호


  private String memberid; //회원 아이디


  private String member_name;  //회원 이름


  private String email;  //회원 이메일


  private String member_password;  //회원 비밀번호


  private String member_nickname;  //회원 닉네임


  private String bank_name;  //회원 환불계좌은행


  private String bankAccount;  //회원 환불계좌번호

  private String bankMaster; //회원 환불계좌예금주




  private String member_phone;  //회원 연락처


  private String member_addr;  //회원 주소


  private String postcode;  //회원 우편번호


  private String member_addr_2;  //회원 상세주소

  private String member_addr_3;  //회원 지번 주소

  private String member_message; //회원 참고항목

  private String recommend_id;  //추천인 아이디

  private String member_detail;  //관리자가 고객에 대한 참고사항 기록

  private String e_money;  //이머니로 환불


  private String bankRefund;  //계좌로 환불

  private String member_role;  //사용자 권한

  private String member_mileage;  //적립금

  public Member toEntity() {
    return new Member(id, memberid, member_name, email, member_password, member_nickname, bank_name, bankAccount, bankMaster, member_phone, member_addr, postcode, member_addr_2, member_addr_3, member_message, recommend_id, member_detail, e_money, bankRefund, member_role, member_mileage);
  }
}
