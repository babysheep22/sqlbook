package com.example.rebook.repository;

import com.example.rebook.entity.Register;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface RegisterRepository extends CrudRepository<Register, Long> {
    @Override
    ArrayList<Register> findAll();
}
