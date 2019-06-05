package cn.edu.supermarket.service;

import cn.edu.supermarket.dao.ProductDao;
import cn.edu.supermarket.entity.Product;
import cn.edu.supermarket.entity.Purchase;
import cn.edu.supermarket.entity.aSell;
import cn.edu.supermarket.entity.out;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;

public interface ProductService {

    public List<Product> search(int pid);

    public int purchase(int pid,int tid,String pname,String intro,int count,double inprice,double outprice);

    public List<Purchase> searchPurchase(int pid, Date starttime, Date endtime);

    public List<aSell> searchSell(int pid,Date starttime,Date endtime);

    public int delproduct(int pid,String reason);

    public out getout(int pid);

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
