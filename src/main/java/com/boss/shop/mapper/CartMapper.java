package com.boss.shop.mapper;

import com.boss.shop.entity.Cart;
import com.boss.shop.entity.Good;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    //添加商品到购物车
    int addGood(Cart cart);

    //展示购物车
    List<Cart> listCart();

    //通过商品Id修改购物车中商品数量
    int updateCartByUserIdAndGoodId(int userId, int goodId, int goodNum);

    //通过用户ID展示购物车
    List<Cart> listCartByUserId(int userId);
}
