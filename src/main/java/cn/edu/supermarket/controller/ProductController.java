package cn.edu.supermarket.controller;

import cn.edu.supermarket.bean.Page;
import cn.edu.supermarket.bean.listPage;
import cn.edu.supermarket.entity.Product;
import cn.edu.supermarket.entity.Purchase;
import cn.edu.supermarket.entity.aSell;
import cn.edu.supermarket.entity.out;
import cn.edu.supermarket.service.ProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Scope("prototype")
@RequestMapping("/user/admin")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("search")
    @ResponseBody
    public listPage search(@RequestParam("typeid")int tid){
        List<Product> list = productService.search(tid);

        listPage listPage = new listPage(1,"查询成功",list);


        return listPage;
    }

    @RequestMapping("buy")
    @ResponseBody
    @Transactional
    public Page purchase(@RequestParam("pid") int pid, @RequestParam("typeid") int tid, @RequestParam("pname") String pname,
                         @RequestParam("intro") String intro, @RequestParam("count")int count,
                         @RequestParam("inprice") double inprice, @RequestParam("outprice") double outprice){
        int i = productService.purchase(pid,tid,pname,intro,count,inprice,outprice);
        Map data = null;
        Page page = new Page(i,"插入成功",data);
        return page;
    }
    @RequestMapping("searchbuy")
    @ResponseBody
    @Transactional
    public listPage searchbuy(@RequestParam("pid")int pid, @RequestParam("startdate") Date starttime,
                              @RequestParam("enddate")Date endtime){
        List<Purchase> list = productService.searchPurchase(pid, starttime, endtime);
        listPage listPage = new listPage(1,"查询成功",list);
        return listPage;
    }

    @RequestMapping("searchsell")
    @ResponseBody
    @Transactional
    public listPage searchsell(@RequestParam("pid")int pid, @RequestParam("startdate") Date starttime,
                              @RequestParam("enddate")Date endtime) {
        List<aSell> list = productService.searchSell(pid, starttime, endtime);
        listPage listPage = new listPage(1,"查询成功",list);
        return listPage;
    }
    @RequestMapping("out")
    @ResponseBody
    @Transactional
    public Page out(@RequestParam("pid")int pid,@RequestParam("reason")String reason){
        int i =productService.delproduct(pid,reason);
        Page page = new Page(i,"下架成功",null);
        return page;
    }
    @RequestMapping("searchout")
    @ResponseBody
    @Transactional
    public listPage getout(@RequestParam("pid")int pid,@RequestParam("reason")String reason){
        List<out>outList = new ArrayList();
        out out = productService.getout(pid);
        outList.add(out);
        listPage listPage = new listPage(1,"查询成功",outList);
        return listPage;

    }
}

