package com.boss.shop.entity;

public class Good {
    private int goodId;
    private String goodName;
    private int goodPrice;
    private int goodTotalNum;

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(int goodPrice) {
        this.goodPrice = goodPrice;
    }

    public int getGoodTotalNum() {
        return goodTotalNum;
    }

    public void setGoodTotalNum(int goodTotalNum) {
        this.goodTotalNum = goodTotalNum;
    }
}
