package com.wx.dao;

import com.wx.domain.City;
import com.wx.domain.Orders;
import com.wx.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IProductDao {

    //查询所有产品
    @Select("select * from product")
    @Results(id = "productAll", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "productNum", column = "productNum"),
            @Result(property = "productName", column = "productName"),
            @Result(property = "DepartureTime", column = "DepartureTime"),
            @Result(property = "productPrice", column = "productPrice"),
            @Result(property = "productDesc", column = "productDesc"),
            @Result(property = "productStatus", column = "productStatus"),
            @Result(property = "startCity", column = "startCityId", javaType = City.class, one = @One(select = "com.wx.dao.ICityDao.findById")),
            @Result(property = "endCity", column = "endCityId", javaType = City.class, one = @One(select = "com.wx.dao.ICityDao.findById"))
    })
    public List<Product> findAll() throws Exception;

    //保存产品
    @Insert("insert into product(id,productNum,productName,startCityId,endCityId,DepartureTime,productPrice,productDesc,productStatus) values(#{id},#{productNum},#{productName},#{startCity.id},#{endCity.id},#{DepartureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;

    //根据id删除产品
    @Delete("delete from product where id = #{newId}")
    void deleteById(String newId) throws Exception;

    //根据id修改产品状态
    @Update("update product set productStatus = '1' where id = #{newId}")
    void updateStatusById(String newId) throws Exception;

    //根据id修改产品信息
    @Update("update product set productNum = #{productNum},productName = #{productName},startCityId = #{startCity.id},endCityId = #{endCity.id},DepartureTime = #{DepartureTime},productPrice = #{productPrice},productDesc = #{productDesc},productStatus = #{productStatus} where id = #{id}")
    void updateById(Product product) throws Exception;

    //根据id查询产品
    @Select("select * from product where id = #{id}")
    @ResultMap("productAll")
    public Product findById(String id) throws Exception;

    //根据productId查询订单
    @Select("SELECT * FROM orders WHERE productId = #{productId}")
    public List<Orders> findOrderByProductId(String productId) throws Exception;

    //根据产品名称模查询
    @Select("SELECT * FROM product WHERE productName LIKE '%${title}%'")
    @ResultMap("productAll")
    public List<Product> findAllLike(@Param("title") String title) throws Exception;

    //根据productId查询产品按产品名称模糊查询
    @Select("SELECT * FROM orders WHERE productId = #{productId} AND orderNum LIKE '%${title}%'")
    public List<Orders> likeOrderByProductId(@Param("productId") String productId, @Param("title") String title) throws Exception;


    //查看所有开启的产品
    @Select("SELECT * FROM product WHERE productStatus=1")
    @ResultMap("productAll")
    public List<Product> findAllByStatusOne() throws Exception;

    //根据产品编号查询产品
    @Select("SELECT * FROM product WHERE productNum=#{productNum}")
    public Product finProductByName(@Param("productNum") String productNum) throws Exception;
}
