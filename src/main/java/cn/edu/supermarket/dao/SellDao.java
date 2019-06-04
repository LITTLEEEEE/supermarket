package cn.edu.supermarket.dao;

import cn.edu.supermarket.entity.Sell;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SellDao {
    /**
     * 购买商品时，往sell表中插记录
     */
    @Insert("insert into sell values(null,#{pid},#{uid},#{sell_count},#{sell_price},now())")
    int addSell(Sell sell);

    /**
     * 根据用户id查询购买记录
     */
    @Select("select * from sell where uid = #{uid}")
    List<Sell> getUserSell(@Param("uid") Integer uid);
}
