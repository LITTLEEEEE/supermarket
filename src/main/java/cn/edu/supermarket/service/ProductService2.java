package cn.edu.supermarket.service;

import cn.edu.supermarket.entity.Product;

import java.util.List;

public interface ProductService2 {
    /**
     * 条件检索，获取商品数据
     */
    List<Product> getProduct(Integer id, Integer typeid, Double minprice, Double maxprice, String name);

    /**
     * 购买商品时，商品的数量减少
     */
    int sellProduct(Integer id, Integer count);

    /**
     * 根据商品id,获取商品
     */
    Product getById(Integer id);

    /**
     * 根据typeid获取商品
     */
    List<Product> getByTypeid(Integer id);
}
