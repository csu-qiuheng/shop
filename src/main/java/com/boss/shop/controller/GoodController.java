package com.boss.shop.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.boss.shop.entity.Good;
import com.boss.shop.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "good",method = { RequestMethod.GET, RequestMethod.POST },
        produces = "application/json; charset=utf-8")
public class GoodController {

    @Autowired
    GoodService goodService;
    @RequestMapping(value = "addGoodToMall")
    String addGoodToMall(int goodId,String goodName,int goodPrice,int goodTotalNum){
        int i = goodService.addGoodToMall(goodId,goodName,goodPrice,goodTotalNum);
        if(i == -1){
            return "增加商品到商场失败！";
        }else {
            return "增加商品到商场成功！";
        }
    }

    @RequestMapping(value = "findGoodByGoodId")
    String findGoodByGoodId(int goodId){
        Good good = goodService.findGoodByGoodId(goodId);

        JSONObject resultJson = new JSONObject();
        resultJson.put(String.valueOf(good.getGoodId()),good);

        if(good == null){
            return "通过商品ID查询商品详情失败！" ;
        }else{
            return "通过商品ID查询商品详情成功！"+ resultJson;
        }
    }

    @RequestMapping(value = "listGood")
    List<Good> listGood(){
        return goodService.listGood();
    }
}
