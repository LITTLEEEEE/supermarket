package cn.edu.supermarket.service.Impl;

import cn.edu.supermarket.dao.ProductDao;
import cn.edu.supermarket.entity.Product;
import cn.edu.supermarket.entity.Purchase;
import cn.edu.supermarket.entity.aSell;
import cn.edu.supermarket.entity.out;
import cn.edu.supermarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.DateFormat;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> search(int pid) {
        return (productDao.search(pid));
    }

    @Override
    public int purchase(int pid, int tid, String pname, String intro, int count, double inprice, double outprice) {
        java.sql.Date ctime = new java.sql.Date(System.currentTimeMillis());
        //DateFormat ctime = DateFormat.getDateTimeInstance();
        Product product = productDao.isExit(pid);
        int i = 5;
        if(product==null){
            productDao.inPurchase(pid,count,inprice,ctime);
            int totalcount = count;
            i=productDao.insProduct(pid,tid,totalcount,outprice,pname,intro);

        }else{
            productDao.inPurchase(pid,count,inprice,ctime);
            int totalcount=count+product.getTotalcount();
            i=productDao.purProduct(totalcount,pid);

        }
        int purchase_id = productDao.getPurid(pid,count,inprice,ctime);
        i = productDao.inspur(pid,purchase_id);
        return i;
    }

    @Override
    public List<Purchase> searchPurchase(int pid, Date starttime, Date endtime) {
        return(productDao.searchPurchase(pid, starttime, endtime));
    }

    @Override
    public List<aSell> searchSell(int pid, Date starttime, Date endtime) {
        return(productDao.searchSell(pid, starttime, endtime));
    }

    @Override
    public int delproduct(int pid, String reason) {
        int out_count = productDao.getcount(pid);
        java.sql.Date ctime = new java.sql.Date(System.currentTimeMillis());
        int i = 5;
        productDao.delproduct(pid);
        i = productDao.insOut(pid,out_count,reason,ctime);
        return i;
    }

    @Override
    public out getout(int pid) {
        return productDao.getout(pid);
    }
}
