package com.example.rebook.repository;


import com.example.rebook.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
    @Override
    ArrayList<Purchase> findAll();


}