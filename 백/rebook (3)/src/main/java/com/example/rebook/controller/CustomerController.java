package com.example.rebook.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class CustomerController {

    @Autowired
    //커스터머레파지토리 생성하기

    @GetMapping("/customerCenter")
    public String customerCenter() {
        return "Customers/CustomerCenter";
    }

    @GetMapping("/customerFql")
    public String customerFql() {
        return "Customers/customerFql";
    }
}
