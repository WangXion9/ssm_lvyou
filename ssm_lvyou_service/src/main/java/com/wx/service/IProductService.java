package com.wx.service;

import com.wx.dao.IProductDao;
import com.wx.domain.Orders;
import com.wx.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IProductService {

    //查询所有产品，分页后
    public List<Product> findAll(int pageNum, int pageSize, String title) throws Exception;

    //根据productId查询订单
    public List<Orders> findOrderByProductId(String id, Integer page, Integer size, String title) throws Exception;


    //添加产品
    void save(Product product) throws Exception;

    //根据id删除产品
    void deleteByIds(String[] id) throws Exception;

    //根据id修改产品状态
    void updateStatusByIds(String[] id) throws Exception;

    //根据id修改产品信息
    void updateById(Product product) throws Exception;

    //根据id查询产品
    Product findById(String id) throws Exception;

    //根据订单ids删除订单
    public void deleteByOrdersId(String[] ids) throws Exception;

    //根据订单ids修改订单
    public void updateOrdersByIds(String[] ids) throws Exception;

    //查询所有的开启的订单
    public List<Product> findAllByStatusOne() throws Exception;

    //根据产品姓名查询产品
    public Product finProductByName(String productNum) throws Exception;

    public List<Product> findByStatusOne(Integer page, Integer size) throws Exception;
}
