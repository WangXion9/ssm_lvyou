package com.wx.dao;

import com.wx.domain.Member;
import com.wx.domain.Orders;
import com.wx.domain.Product;
import com.wx.domain.dto.OrdersDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IOrderesDao {

    @Select("select * from orders ORDER BY orderTime DESC")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderCount", column = "orderCount"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.wx.dao.IProductDao.findById"))
    })
    public List<Orders> findAll() throws Exception;


    //多表操作
    @Select("select * from orders where id = #{ordersId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.wx.dao.IProductDao.findById")),
            @Result(property = "member", column = "memberId", javaType = Member.class, one = @One(select = "com.wx.dao.IMemberDao.findById")),
            @Result(property = "travellers", column = "id", javaType = java.util.List.class, many = @Many(select = "com.wx.dao.ITravellerDao.findByOrdersId"))
    })
    public Orders findById(String ordersId) throws Exception;

    //对订单的订单状态进行修改
    @Update("update orders set orderStatus = 1 where id = #{id}")
    public void updateOrdersByIds(String id) throws Exception;

    //根据产品id查询中间表
    @Select("SELECT * FROM order_traveller WHERE orderId = #{id}")
    public List<Object> findOrderTravellerByOrderId(String id) throws Exception;

    //根据orderId删除中间表信息
    @Delete("DELETE FROM order_traveller WHERE orderId = #{id}")
    public void deleteOrderTravellerByOrderId(String id) throws Exception;

    //order表中根据id删除
    @Delete("DELETE FROM orders WHERE id = #{id}")
    public void deleteOrderByOrderId(String id) throws Exception;

    //保存订单信息
    @Insert("INSERT INTO orders(id, orderNum, orderTime, peopleCount, orderDesc, payType, orderStatus, productId, memberId, payStatus, overStatus) " +
            " VALUES (#{id}, #{orderNum}, #{orderTime}, #{peopleCount}, #{orderDesc}, #{payType}, #{orderStatus}, #{productId}, #{memberId}, #{payStatus}, #{overStatus})")
    public void save(OrdersDto ordersDto) throws Exception;

    //保存订单与游客的中间表
    @Insert("INSERT INTO order_traveller(orderId, travellerId) VALUES (#{orderId}, #{travellerId})")
    public void saveOrderTraveller(@Param("orderId") String orderId, @Param("travellerId") String travellerId) throws Exception;

    //更新订单,只更新peopleCount，orderDesc，payType，orderStatus字段
    @Update("UPDATE orders SET peopleCount=#{peopleCount}, orderDesc=#{orderDesc}, payType=#{payType}, payStatus=#{payStatus}, orderStatus=#{orderStatus}, productId=#{productId}, memberId=#{memberId}, overStatus=#{overStatus} WHERE id=#{id}")
    public void updateOrdersAllById(OrdersDto ordersDto) throws Exception;

    //根据订单
    @Select("select * from orders WHERE orderNum LIKE '%${title}%'")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderCount", column = "orderCount"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.wx.dao.IProductDao.findById"))
    })
    public List<Orders> findLike(@Param("title") String title) throws Exception;

    //查询所有未处理的订单
    @Select("SELECT * FROM orders WHERE orderStatus = 0")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.wx.dao.IProductDao.findById")),
            @Result(property = "member", column = "memberId", javaType = Member.class, one = @One(select = "com.wx.dao.IMemberDao.findById")),
    })
    public List<Orders> getOrdersByStatusZero() throws Exception;

    //查看今日新增的订单数
    @Select("SELECT COUNT(*) FROM orders WHERE TO_DAYS(orderTime) = TO_DAYS(NOW())")
    public Integer findOrdersAddByNew()throws Exception;

    //查看今日新增的订单的总金额
    @Select("SELECT CAST(SUM(productPrice) AS DECIMAL(10,2)) FROM product WHERE id IN(\n" +
            "SELECT productId FROM orders WHERE TO_DAYS(orderTime) = TO_DAYS(NOW()))")
    public Double findOrdersMoneyByNew() throws Exception;

    //查询退款人数
    @Select("SELECT COUNT(*) FROM orders WHERE overStatus = 3")
    public Integer findOrdersRefund() throws Exception;

    //查询交易成功的人数
    @Select("SELECT COUNT(*) FROM orders WHERE overStatus = 2")
    public Integer findOrdersSuccess() throws Exception;

    //查询当天新增的订单
    @Select("SELECT * FROM orders WHERE TO_DAYS(orderTime) = TO_DAYS(NOW())")
    @Results(id = "ordersAll", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.wx.dao.IProductDao.findById")),
            @Result(property = "member", column = "memberId", javaType = Member.class, one = @One(select = "com.wx.dao.IMemberDao.findById")),
            @Result(property = "travellers", column = "id", javaType = java.util.List.class, many = @Many(select = "com.wx.dao.ITravellerDao.findByOrdersId"))
    })
    public List<Orders> findOrdersByNew() throws Exception;

    //查询所有退款的订单
    @Select("SELECT * FROM orders WHERE overStatus = 3")
    @ResultMap("ordersAll")
    public List<Orders> findOrdersByRefund() throws Exception;

    //查询所有交易完成的订单
    @Select("SELECT * FROM orders WHERE overStatus = 2")
    @ResultMap("ordersAll")
    public List<Orders> findOrdersBySuccess() throws Exception;

    //根据订单编号查询订单
    @Select("SELECT * FROM orders WHERE orderNum=#{orderNum}")
    public Orders findOrderByOrderNum(@Param("orderNum") String orderNum) throws Exception;
}
