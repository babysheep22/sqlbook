package com.example.rebook.repository;

import com.example.rebook.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByCartIdAndRegisterId(Long cartId, Long itemId);
}
