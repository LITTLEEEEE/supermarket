package cn.edu.supermarket.service.Impl;

import cn.edu.supermarket.dao.ProductDao2;
import cn.edu.supermarket.entity.Product;
import cn.edu.supermarket.service.ProductService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl2 implements ProductService2 {
    @Autowired
    ProductDao2 productDao;

    @Override
    public List<Product> getProduct(Integer id, Integer typeid, Double minprice, Double maxprice, String name) {
        return productDao.getProduct(id, typeid, minprice, maxprice, name);
    }

    @Override
    public int sellProduct(Integer id, Integer count) {
        return productDao.sellProduct(id, count);
    }

    @Override
    public Product getById(Integer id) {
        return productDao.getById(id);
    }

    @Override
    public List<Product> getByTypeid(Integer id) {
        return productDao.getByTypeid(id);
    }
}
