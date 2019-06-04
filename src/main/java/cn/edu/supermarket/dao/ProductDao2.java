package cn.edu.supermarket.dao;

import cn.edu.supermarket.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductDao2 {
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
