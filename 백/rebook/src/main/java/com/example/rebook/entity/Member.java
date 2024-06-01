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
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //회원 번호

    @Column
    private String memberid; //회원 아이디

    @Column
    private String member_name;  //회원 이름

    @Column
    private String email;  //회원 이메일

    @Column
    private String member_password;  //회원 비밀번호

    @Column
    private String member_nickname;  //회원 닉네임

    @Column
    private String bank_name;  //회원 환불계좌은행

    @Column
    private String bankAccount;  //회원 환불계좌번호

    @Column
    private String bankMaster;  //회원 환불계좌예금주

    @Column
    private String member_phone;  //회원 연락처

    @Column
    private String member_addr;  //회원 주소

    @Column
    private String postcode;  //회원 우편번호

    @Column
    private String member_addr_2;  //회원 상세주소

    @Column
    private String member_addr_3;  //회원 지번 주소

    @Column
    private String member_message; //참고항목

    @Column
    private String recommend_id;  //추천인 아이디

    @Column
    private String member_detail;  //관리자가 적는 멤버에 대한 사항


    @Column
    private String e_money;  //이머니로 환불

    @Column
    private String bankRefund;  //계좌로 환불


    @Column
    private String member_role;  //사용자 권한

    @Column
    private String member_mileage;  //적립금


}
