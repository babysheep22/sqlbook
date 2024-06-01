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

    @GetMapping("/event")
    public String eventMain() {
        return "Events/eventMain";
    }

    @GetMapping("/eventPrize")
    public String eventPrize() {
        return "Events/eventPrize";
    }

    @GetMapping("/event1")
    public String eventPrize1() {
        return "Events/event1";
    }

    @GetMapping("/event2")
    public String eventPrize2() {
        return "Events/event2";
    }

    @GetMapping("/event3")
    public String eventPrize3() {
        return "Events/event3";
    }

    @GetMapping("/event4")
    public String eventPrize4() {
        return "Events/event4";
    }

    @GetMapping("/event5")
    public String eventPrize5() {
        return "Events/event5";
    }
}
