package com.example.rebook.repository;

import com.example.rebook.entity.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface RegisterRepository extends CrudRepository<Item, Long> {
    @Override
    ArrayList<Item> findAll();
}
