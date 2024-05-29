package com.example.rebook.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class EventController {

    @Autowired
    //이벤트 레파지토리 생성하기

    @GetMapping("event")
    public String eventMain() {
        return "Events/eventMain";
    }

    @GetMapping("eventPrize")
    public String eventPrize() {
        return "Events/eventPrize";
    }
}
