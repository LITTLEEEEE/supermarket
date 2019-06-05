package cn.edu.supermarket.dao;

import cn.edu.supermarket.entity.Product;
import cn.edu.supermarket.entity.Purchase;
import cn.edu.supermarket.entity.aSell;
import cn.edu.supermarket.entity.out;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Mapper
@Repository
public interface ProductDao {
    //根据id返回库存信息

    List<Product> search (@Param("typeid")int typeid);

    //进货，首先在purchase表中插入记录，然后判断该商品是否还有库存，决定在product表是insert还是update
    @Insert("insert into purchase (pid,pur_count,pur_price,pur_date)value" +
            "(#{pid},#{pur_count},#{pur_price},#{pur_date})")
    int inPurchase(@Param("pid")int pid,@Param("pur_count")int pur_count,@Param("pur_price") double pur_price,
                   @Param("pur_date") Date pur_date);
    @Update("update product set totalcount = #{newtotalcount} where pid = #{pid}")
    int purProduct(@Param("newtotalcount")int count,@Param("pid")int pid);

    @Select("select purchase_id from purchase where(pid=#{pid} and pur_count=#{pur_count} and pur_price=#{pur_price} and " +
            "pur_date=#{pur_date})")
    int getPurid(@Param("pid")int pid,@Param("pur_count")int pur_count,@Param("pur_price") double pur_price,
                 @Param("pur_date") Date pur_date);

    @Insert("insert into pur (pid,purchase_id)value(#{pid},#{purchase_id})")
    int inspur(@Param("pid")int pid,@Param("purchase_id")int purchase_id);
    @Insert("insert into product (pid,tid,pname,totalcount,price,intro)value(#{pid},#{tid},#{pname}," +
                                            "#{totalcount},#{price},#{intro})")
    int insProduct(@Param("pid")int pid,@Param("tid")int tid,@Param("totalcount")int totalcount,@Param("price") double price,
                   @Param("pname")String pname,@Param("intro")String intro );
    @Select("Select * from product where pid = #{pid}")
    Product isExit(@Param("pid")int pid);

    //按pid和date区间查询进货记录
    List<Purchase> searchPurchase(@Param("pid")int pid,@Param("starttime")Date starttime,@Param("endtime")Date endtime);

    //按商品pid和date区间查询销售记录
    List<aSell> searchSell(@Param("pid")int pid,@Param("starttime")Date starttime,@Param("endtime")Date endtime);

    //给商品pid和reason下架商品
    @Delete("delete from product where pid = #{pid}")
    int delproduct(@Param("pid")int pid);
    @Select("select totalcount from product where pid = #{pid}")
    int getcount(@Param("pid")int pid);
    @Insert("insert into outtable (pid,out_count,out_reason,out_date)value" +
            "(#{pid},#{out_count},#{reason},#{date})")
    int insOut(@Param("pid")int pid,@Param("out_count")int count,@Param("reason")String reason,@Param("date")Date date);

    //按id查询下架商品信息

    out getout(@Param("pid")int pid);

    /**
     * 条件检索，获取商品数据
     */
    List<Product> getProduct(@Param("id") Integer id, @Param("typeId") Integer typeid, @Param("minPrice") Double minprice, @Param("maxPrice") Double maxprice, @Param("nameKey") String name);

    /**
     * 购买商品时，商品的数量减少
     */
    @Update("UPDATE product SET totalcount=totalcount-#{count} where pid = #{pid}")
    int sellProduct(@Param("pid") Integer id, @Param("count") Integer count);

    /**
     * 根据商品id,获取商品
     */
    @Select("select * from product where pid=#{id}")
    Product getById(@Param("id") Integer id);

    /**
     * 根据typeid获取商品
     */
    @Select("select * from product where tid=#{tid}")
    List<Product> getByTypeid(@Param("tid") Integer id);

}
