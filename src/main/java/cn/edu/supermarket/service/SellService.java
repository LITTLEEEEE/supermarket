package cn.edu.supermarket.service;

import cn.edu.supermarket.entity.Sell;

import java.util.List;

public interface SellService {
    /**
     * 购买商品时，往sell表中插记录
     */
    int addSell(Sell sell);

    /**
     * 根据用户id查询购买记录
     */
    List<Sell> getUserSell(Integer uid);
}
