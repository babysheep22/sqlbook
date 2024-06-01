package com.example.rebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class needIforsController {

    @GetMapping("/needInfors/bookGrade")
    public String needIfors1() {
        return "needInfors/bookGrade";
    }

    @GetMapping("/needInfors/comIntro")
    public String needIfors2() {
        return "needInfors/comIntro";
    }


    @GetMapping("/needInfors/servicePolicy")
    public String needIfors3() {
        return "needInfors/servicePolicy";
    }


    @GetMapping("/needInfors/youthPolicy")
    public String needIfors4() {
        return "needInfors/youthPolicy";
    }




}
