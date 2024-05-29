package com.example.rebook.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;


@ToString
@AllArgsConstructor
@Getter
@Entity
@NoArgsConstructor
@Table(name = "items")
public class Register extends BaseTimeEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long book_id;


    @Column
    private String book_image;


    @Column
    private String book_title;

    @Column
    private String book_author;

    @Column
    private String publisher;

    @Column
    private String pub_date;

    @Column
    private String major_kategory;

    @Column
    private String minor_kategory;

    @Column
    private int list_price;

    @Column
    private int sell_price;

    @Column
    private String book_condition;

    @Column
    private String book_detail;

    @Column
    private String book_infor;

    @Column
    private int purchase_price;



}

