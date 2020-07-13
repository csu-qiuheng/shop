package com.boss.shop.controller;

import com.boss.shop.entity.Cart;
import com.boss.shop.mapper.CartMapper;
import com.boss.shop.service.CartService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//若不加返回路径，加了返回函数类型
@RequestMapping(value = "/cart",
        method = { RequestMethod.GET, RequestMethod.POST },
        produces = "application/json; charset=utf-8")
public class CartController {

    @Autowired
    CartService cartService;
    @RequestMapping(value = "/addGood",method = RequestMethod.POST)
    public String addGood(int userId, int goodId, int goodNum){
        return cartService.addGood(userId,goodId,goodNum);
    }

    @RequestMapping(value = "/listCart",method = RequestMethod.GET)
    public List<Cart> listcart(){
        return cartService.listCart();
    }

    @RequestMapping(value = "/listCartByUserId",method = RequestMethod.GET)
    public String listCartByUserId(int userId){
        return cartService.listCartByUserId(userId);
    }

    @RequestMapping(value = "/updateCartByUserIdAndGoodId")
    public String updateCartByGoodId(int userId, int goodId,int goodNum){
        return cartService.updateCartByUserIdAndGoodId(userId,goodId,goodNum);
    }



}
