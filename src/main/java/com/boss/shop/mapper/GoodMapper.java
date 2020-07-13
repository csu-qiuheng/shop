package com.boss.shop.mapper;

import com.boss.shop.entity.Good;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodMapper {

    //添加商品到商城
    int addGoodToMall(int goodId,String goodName,
                         int goodPrice,int goodTotalNum);

    //通过商品ID查询商品详情
    Good findGoodByGoodId(int goodId);

    //通过商品ID修改商品库存数量
    int updateGoodTotalNum(int goodId, int goodTotalNum);

    //展示商品
    List<Good> listGood();
}
