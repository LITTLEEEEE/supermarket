package cn.edu.supermarket.controller;

import cn.edu.supermarket.bean.Page;
import cn.edu.supermarket.bean.ReturnByList;
import cn.edu.supermarket.entity.Product;
import cn.edu.supermarket.entity.Sell;
import cn.edu.supermarket.entity.User;
import cn.edu.supermarket.service.ProductService;
import cn.edu.supermarket.service.ProductService2;
import cn.edu.supermarket.service.SellService;
import cn.edu.supermarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SellService sellService;

    @RequestMapping("login")
    @ResponseBody
    public Page logincheck(@RequestParam("username")String username, @RequestParam("userpass")String userpass){
        System.out.print("d");
        User user = userService.logincheck(username, userpass);
        Page page = new Page();
        if(user==null){
            Map data = new HashMap();
            page = new Page(0,"登陆失败",data);
        }else{
            int i = 1;
            Map data = new HashMap();
            data.put("role",user.getType());
            data.put("userid",user.getUserid());
            page = new Page(i,"登陆成功",data);
        }
        return page;
    }
    @RequestMapping("register")
    @ResponseBody
    public Page register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setUserpass(password);
        if (userService.isNameExists(username)) {
            return new Page(0, "用户名已存在", null);
        } else if (userService.register(user) == 0) {
            return new Page(0, "注册失败", null);
        }
        return new Page(1, "注册成功", null);
    }

    @RequestMapping(value = "/customer/search")
    @ResponseBody
    public ReturnByList getProduct(Integer id, Integer typeid, Double minprice, Double maxprice, String name) {
        ReturnByList returnByList = new ReturnByList();
        List<Product> productList = productService.getProduct(id, typeid, minprice, maxprice, name);
        if (productList.size()==0){
            returnByList = new ReturnByList(0,"查询失败",null);
        }
        else {
            List data = new ArrayList();
            for(Product product:productList){
                Map productInfo = new HashMap();
                productInfo.put("pid",product.getPid());
                productInfo.put("pname",product.getPname());
                productInfo.put("count",product.getTotalcount());
                productInfo.put("price",product.getPrice());
                productInfo.put("intro",product.getIntro());
                System.out.println(productInfo);
                data.add(productInfo);

            }
            System.out.println(data);
            returnByList = new ReturnByList(1,"查询成功",data);

        }
        return returnByList;
    }

    @RequestMapping("/customer/buy")
    @ResponseBody
    public Page buyProduct(Integer id, Integer count, Double price, Integer userid){
        Page page = new Page();
        Sell sell = new Sell();
        sell.setPid(id);
        sell.setUid(userid);
        sell.setSell_count(count);
        sell.setSell_price(price);
        int a = sellService.addSell(sell);
        int b = productService.sellProduct(id, count);
        if(a>0 && b>0){
            page = new Page(1, "购买成功", null);
        }
        else {
            page = new Page(0, "购买失败", null);
        }
        return page;
    }

    @RequestMapping("/customer/info")
    @ResponseBody
    public Page getInfo(Integer userid){
        Page page = null;
        User user = userService.geUserInfo(userid);
        List<Sell> sellList = sellService.getUserSell(userid);
        System.out.println(sellList);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        //Product product = productService.getById()
        if(user == null){
            page = new Page(0, "不存在此用户", null);
        }
        else if(sellList.size()==0){
            page = new Page(0, "此用户暂时还没有购买商品", null);
        }
        else {
            Map data = new HashMap();
            List buyrecord = new ArrayList();
            data.put("userid",user.getUserid());
            data.put("username",user.getUsername());
            data.put("password",user.getUserpass());
            for(Sell sell:sellList){
                Map sellInfo = new HashMap();
                Product product = productService.getById(sell.getPid());
                sellInfo.put("pid",sell.getPid());
                sellInfo.put("pname",product.getPname());
                sellInfo.put("count",sell.getSell_count());
                sellInfo.put("price",sell.getSell_price());
                sellInfo.put("date",sdf.format(sell.getSell_date()));
                buyrecord.add(sellInfo);

            }
            data.put("buyrecord",buyrecord);
            page = new Page(1, "查看信息成功", data);

        }
        return page;
    }

    @RequestMapping("/customer/updateinfo")
    @ResponseBody
    public Page updateInfo(String username, String password){
        Page page = null;
        return userService.updatepwd(password,username)>0 ? new Page(1, "修改成功", null):new Page(0, "修改失败", null);
    }

    @RequestMapping("foodsearch")
    @ResponseBody
    public ReturnByList searchFood(){
        ReturnByList returnByList = new ReturnByList();
        Integer tid = 1;
        List<Product> productList = productService.getByTypeid(tid);
        if (productList.size()==0){
            returnByList = new ReturnByList(0,"该类别下暂时没有商品",null);
        }
        else {
            List data = new ArrayList();
            for(Product product:productList){
                Map productInfo = new HashMap();
                productInfo.put("pid",product.getPid());
                productInfo.put("pname",product.getPname());
                productInfo.put("count",product.getTotalcount());
                productInfo.put("price",product.getPrice());
                productInfo.put("intro",product.getIntro());
                System.out.println(productInfo);
                data.add(productInfo);
            }
            System.out.println(data);
            returnByList = new ReturnByList(1,"查询成功",data);

        }
        return returnByList;
    }

    @RequestMapping("clothessearch")
    @ResponseBody
    public ReturnByList searchClothes(){
        ReturnByList returnByList = new ReturnByList();
        Integer tid = 2;
        List<Product> productList = productService.getByTypeid(tid);
        if (productList.size()==0){
            returnByList = new ReturnByList(0,"该类别下暂时没有商品",null);
        }
        else {
            List data = new ArrayList();
            for(Product product:productList){
                Map productInfo = new HashMap();
                productInfo.put("pid",product.getPid());
                productInfo.put("pname",product.getPname());
                productInfo.put("count",product.getTotalcount());
                productInfo.put("price",product.getPrice());
                productInfo.put("intro",product.getIntro());
                System.out.println(productInfo);
                data.add(productInfo);
            }
            System.out.println(data);
            returnByList = new ReturnByList(1,"查询成功",data);

        }
        return returnByList;
    }

    @RequestMapping("electricsearch")
    @ResponseBody
    public ReturnByList searchElectric(){
        ReturnByList returnByList = new ReturnByList();
        Integer tid = 3;
        List<Product> productList = productService.getByTypeid(tid);
        if (productList.size()==0){
            returnByList = new ReturnByList(0,"该类别下暂时没有商品",null);
        }
        else {
            List data = new ArrayList();
            for(Product product:productList){
                Map productInfo = new HashMap();
                productInfo.put("pid",product.getPid());
                productInfo.put("pname",product.getPname());
                productInfo.put("count",product.getTotalcount());
                productInfo.put("price",product.getPrice());
                productInfo.put("intro",product.getIntro());
                System.out.println(productInfo);
                data.add(productInfo);
            }
            System.out.println(data);
            returnByList = new ReturnByList(1,"查询成功",data);

        }
        return returnByList;
    }

    @RequestMapping("dailysearch")
    @ResponseBody
    public ReturnByList searchDaily(){
        ReturnByList returnByList = new ReturnByList();
        Integer tid = 4;
        List<Product> productList = productService.getByTypeid(tid);
        if (productList.size()==0){
            returnByList = new ReturnByList(0,"该类别下暂时没有商品",null);
        }
        else {
            List data = new ArrayList();
            for(Product product:productList){
                Map productInfo = new HashMap();
                productInfo.put("pid",product.getPid());
                productInfo.put("pname",product.getPname());
                productInfo.put("count",product.getTotalcount());
                productInfo.put("price",product.getPrice());
                productInfo.put("intro",product.getIntro());
                System.out.println(productInfo);
                data.add(productInfo);
            }
            System.out.println(data);
            returnByList = new ReturnByList(1,"查询成功",data);

        }
        return returnByList;
    }

    @RequestMapping("officesearch")
    @ResponseBody
    public ReturnByList searchOffice(){
        ReturnByList returnByList = new ReturnByList();
        Integer tid = 5;
        List<Product> productList = productService.getByTypeid(tid);
        if (productList.size()==0){
            returnByList = new ReturnByList(0,"该类别下暂时没有商品",null);
        }
        else {
            List data = new ArrayList();
            for(Product product:productList){
                Map productInfo = new HashMap();
                productInfo.put("pid",product.getPid());
                productInfo.put("pname",product.getPname());
                productInfo.put("count",product.getTotalcount());
                productInfo.put("price",product.getPrice());
                productInfo.put("intro",product.getIntro());
                System.out.println(productInfo);
                data.add(productInfo);
            }
            System.out.println(data);
            returnByList = new ReturnByList(1,"查询成功",data);

        }
        return returnByList;
    }

    @RequestMapping("shoesearch")
    @ResponseBody
    public ReturnByList searchShoe(){
        ReturnByList returnByList = new ReturnByList();
        Integer tid = 6;
        List<Product> productList = productService.getByTypeid(tid);
        if (productList.size()==0){
            returnByList = new ReturnByList(0,"该类别下暂时没有商品",null);
        }
        else {
            List data = new ArrayList();
            for(Product product:productList){
                Map productInfo = new HashMap();
                productInfo.put("pid",product.getPid());
                productInfo.put("pname",product.getPname());
                productInfo.put("count",product.getTotalcount());
                productInfo.put("price",product.getPrice());
                productInfo.put("intro",product.getIntro());
                System.out.println(productInfo);
                data.add(productInfo);
            }
            System.out.println(data);
            returnByList = new ReturnByList(1,"查询成功",data);

        }
        return returnByList;
    }

    @RequestMapping("bagsearch")
    @ResponseBody
    public ReturnByList searchBag(){
        ReturnByList returnByList = new ReturnByList();
        Integer tid = 7;
        List<Product> productList = productService.getByTypeid(tid);
        if (productList.size()==0){
            returnByList = new ReturnByList(0,"该类别下暂时没有商品",null);
        }
        else {
            List data = new ArrayList();
            for(Product product:productList){
                Map productInfo = new HashMap();
                productInfo.put("pid",product.getPid());
                productInfo.put("pname",product.getPname());
                productInfo.put("count",product.getTotalcount());
                productInfo.put("price",product.getPrice());
                productInfo.put("intro",product.getIntro());
                System.out.println(productInfo);
                data.add(productInfo);
            }
            System.out.println(data);
            returnByList = new ReturnByList(1,"查询成功",data);

        }
        return returnByList;
    }

    @RequestMapping("othersearch")
    @ResponseBody
    public ReturnByList searchOther(){
        ReturnByList returnByList = new ReturnByList();
        Integer tid = 8;
        List<Product> productList = productService.getByTypeid(tid);
        if (productList.size()==0){
            returnByList = new ReturnByList(0,"该类别下暂时没有商品",null);
        }
        else {
            List data = new ArrayList();
            for(Product product:productList){
                Map productInfo = new HashMap();
                productInfo.put("pid",product.getPid());
                productInfo.put("pname",product.getPname());
                productInfo.put("count",product.getTotalcount());
                productInfo.put("price",product.getPrice());
                productInfo.put("intro",product.getIntro());
                System.out.println(productInfo);
                data.add(productInfo);
            }
            System.out.println(data);
            returnByList = new ReturnByList(1,"查询成功",data);

        }
        return returnByList;
    }

}
