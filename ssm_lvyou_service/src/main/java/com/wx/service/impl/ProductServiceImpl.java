package com.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.wx.dao.IProductDao;
import com.wx.domain.Orders;
import com.wx.domain.Product;
import com.wx.service.IOrdersService;
import com.wx.service.IProductService;
import com.wx.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Autowired
    private IOrdersService ordersService;

    /*@Override
    为分页之前查询所有商品
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }*/

    @Override
    public List<Product> findAll(int pageNum, int pageSize, String title) throws Exception {
        if ("".equals(title)){
            PageHelper.startPage(pageNum,pageSize);
            return productDao.findAll();
        }else {
            PageHelper.startPage(pageNum,pageSize);
            return productDao.findAllLike(title);
        }

    }

    //根据productId查询订单
    @Override
    public List<Orders> findOrderByProductId(String id, Integer page, Integer size, String title) throws Exception {
        if ("".equals(title)){
            PageHelper.startPage(page, size);
            return productDao.findOrderByProductId(id);
        }else {
            PageHelper.startPage(page, size);
            return productDao.likeOrderByProductId(id, title);
        }
    }

    @Override
    public void save(Product product) throws Exception {
        product.setId(UuidUtils.createUuid());
        productDao.save(product);
    }

    @Override
    public void deleteByIds(String[] id) throws Exception {
        for (String newId : id){
            productDao.deleteById(newId);
        }
    }

    @Override
    public void updateStatusByIds(String[] id) throws Exception {
        for (String newId : id){
            productDao.updateStatusById(newId);
        }
    }

    @Override
    public void updateById(Product product) throws Exception {
        productDao.updateById(product);
    }

    @Override
    public Product findById(String id) throws Exception {
        return productDao.findById(id);
    }

    @Override
    public void deleteByOrdersId(String[] ids) throws Exception {
        ordersService.deleteByOrdersId(ids);
    }

    @Override
    public void updateOrdersByIds(String[] ids) throws Exception {
        ordersService.updateOrdersByIds(ids);
    }

    @Override
    public List<Product> findAllByStatusOne() throws Exception {
        return productDao.findAllByStatusOne();
    }

    @Override
    public Product finProductByName(String productNum) throws Exception {
        return productDao.finProductByName(productNum);
    }

    @Override
    public List<Product> findByStatusOne(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page, size);
        return productDao.findAllByStatusOne();
    }
}
