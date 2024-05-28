package com.example.rebook.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //REST API용 컨트롤러
public class rebookApiController {

    @GetMapping("api/hello")
    public String hello() {
        return "Hello world!";
    }

}
