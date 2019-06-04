package cn.edu.supermarket.service.Impl;

import cn.edu.supermarket.dao.SellDao;
import cn.edu.supermarket.entity.Sell;
import cn.edu.supermarket.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellServiceImpl implements SellService {
    @Autowired
    SellDao sellDao;

    @Override
    public int addSell(Sell sell) {
        return sellDao.addSell(sell);
    }

    @Override
    public List<Sell> getUserSell(Integer uid) {
        return sellDao.getUserSell(uid);
    }
}
