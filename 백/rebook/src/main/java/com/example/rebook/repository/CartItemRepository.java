package com.example.rebook.repository;

import com.example.rebook.dto.CartDetailDto;
import com.example.rebook.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByCartIdAndRegisterId(Long cartId, Long itemId);

    @Query("SELECT new com.example.rebook.dto.CartDetailDto(ci.id, r.book_id, r.sell_price, ci.count, ) " +
            "FROM CartItem ci" +
            "JOIN ci.book_id r" +
            "WHERE ci.cart.id = :cartId " +
            "ORDER BY ci.createdDate desc"
    )
    List<CartDetailDto> findCartDetailDtoList(Long cartId);
}
