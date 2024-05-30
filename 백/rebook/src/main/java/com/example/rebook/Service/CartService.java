package com.example.rebook.Service;

import com.example.rebook.dto.CartItemDto;
import com.example.rebook.entity.Cart;
import com.example.rebook.entity.CartItem;
import com.example.rebook.entity.Register;
import com.example.rebook.entity.Member;
import com.example.rebook.repository.CartRepository;
import com.example.rebook.repository.CartItemRepository;
import com.example.rebook.repository.RegisterRepository;
import com.example.rebook.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;


//장바구니에 상품을 담는 로직 생성

@Service
@RequiredArgsConstructor
@Transactional
public class CartService{
    private final RegisterRepository registerRepository;
    private final MemberRepository memberRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public Long addCart(CartItemDto cartItemDto, String email){
        Register register = registerRepository.findById(cartItemDto.getItemId())
                .orElseThrow(EntityNotFoundException::new);
        Member member = memberRepository.findByEmail(email);

        Cart cart = cartRepository.findByMemberId(member.getId());
        if(cart == null){
            cart = Cart.createCart(member);
            cartRepository.save(cart);
        }

        CartItem savedCartItem =
                cartItemRepository.findByCartIdAndRegisterId(cart.getId(), register.getId());
        if(savedCartItem != null){
            savedCartItem.addCount(cartItemDto.getCount());
            return savedCartItem.getId();
        } else{
            CartItem cartItem =
                    CartItem.createCartItem(cart,register,cartItemDto.getCount());
                    cartItemRepository.save(cartItem);
                    return cartItem.getId();
        }
    }
}
