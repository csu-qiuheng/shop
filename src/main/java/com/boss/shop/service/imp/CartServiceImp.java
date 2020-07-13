package com.boss.shop.service.imp;

import com.alibaba.fastjson.JSONArray;
import com.boss.shop.entity.Cart;
import com.boss.shop.mapper.CartMapper;
import com.boss.shop.mapper.GoodMapper;
import com.boss.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImp implements CartService {

    @Autowired
    CartMapper cartMapper;

    @Autowired
    GoodMapper goodMapper;
    @Override
    public String addGood(int userId, int goodId, int goodNum) {
        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setGoodId(goodId);
        cart.setGoodNum(goodNum);

        int i = cartMapper.addGood(cart);
        if(i == -1){
            return "添加商品失败！";
        }else{
            return " 添加商品成功";
        }
    }

    @Override
    public List<Cart> listCart() {
        return cartMapper.listCart();
    }

    @Override
    public String updateCartByUserIdAndGoodId(int userId, int goodId, int goodNum) {
        if((goodNum > 0) && (goodNum < goodMapper.findGoodByGoodId(goodId).getGoodTotalNum())){
            //查询当前商品库存数量
            int now = goodMapper.findGoodByGoodId(goodId).getGoodTotalNum();

            //修改购买的商品数量
            cartMapper.updateCartByUserIdAndGoodId(userId,goodId,goodNum);

            //修改商品库存数量
            goodMapper.updateGoodTotalNum(goodId,now - goodNum);

            //查询剩余商品数量
            int remain = goodMapper.findGoodByGoodId(goodId).getGoodTotalNum();

            return "通过用户ID和商品ID修改购物车中商品数量成功！该商品剩余数量为：" + remain;
        }else{
            return "通过用户ID和商品ID修改购物车中商品数量失败！原因：该商品数量不足！";
        }
    }

    @Override
    public String listCartByUserId(int userId) {
        List<Cart> cart = cartMapper.listCartByUserId(userId);

        JSONArray resultJson=new JSONArray();
        resultJson.add(cart); //.add()可以添加List，转化为json

        if(cart != null){
            return "通过用户ID展示购物车成功！" + resultJson;
        }else {
            return "通过用户ID展示购物车失败！";
        }
    }
}
