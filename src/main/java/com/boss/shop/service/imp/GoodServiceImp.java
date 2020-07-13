package com.boss.shop.service.imp;

import com.boss.shop.entity.Good;
import com.boss.shop.mapper.GoodMapper;
import com.boss.shop.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImp implements GoodService {

    @Autowired
    GoodMapper goodMapper;
    @Override
    public int addGoodToMall(int goodId, String goodName, int goodPrice, int goodTotalNum) {
        return goodMapper.addGoodToMall(goodId,goodName,goodPrice,goodTotalNum);
    }

    @Override
    public Good findGoodByGoodId(int goodId) {
        return goodMapper.findGoodByGoodId(goodId);
    }

    @Override
    public int updateGoodTotalNum(int goodId, int goodTotalNum) {
        return goodMapper.updateGoodTotalNum(goodId, goodTotalNum);
    }

    @Override
    public List<Good> listGood() {
        return goodMapper.listGood();
    }
}
