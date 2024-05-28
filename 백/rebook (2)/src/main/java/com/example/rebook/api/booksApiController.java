package com.example.rebook.api;

import com.example.rebook.entity.Item;
import com.example.rebook.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class booksApiController {
    @Autowired
    private RegisterRepository regiRepository;

    @GetMapping("/api/register")
    public List<Item> index() {
        return regiRepository.findAll();
    }
}
