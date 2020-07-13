package com.boss.shop.service;

import com.boss.shop.entity.Good;

import java.util.List;

public interface GoodService {
    int addGoodToMall(int goodId, String goodName,
                      int goodPrice, int goodTotalNum);

    Good findGoodByGoodId(int goodId);

    int updateGoodTotalNum(int goodId, int goodTotalNum);

    List<Good> listGood();

    int deleteGoodByGoodId(int goodId);
}
