package com.boss.shop.service;

import com.boss.shop.entity.Cart;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CartService {
    String addGood(int userId, int goodId, int goodNum);

    List<Cart> listCart();

    String updateCartByUserIdAndGoodId(int userId, int goodId, int goodNum);

    String listCartByUserId(int userId);

}
