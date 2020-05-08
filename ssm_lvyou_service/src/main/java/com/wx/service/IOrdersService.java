package com.wx.service;

import com.wx.domain.Orders;
import com.wx.domain.dto.OrdersDto;

import java.util.List;

public interface IOrdersService {

    public List<Orders> findAll(int page, int size, String title) throws Exception;

    public Orders findById(String ordersId) throws Exception;

    public void updateOrdersByIds(String[] ids) throws Exception;

    public void deleteByOrdersId(String[] ids) throws Exception;

    public void saveAll(OrdersDto ordersDto) throws Exception;

    public void editOrdersAll(OrdersDto ordersDto) throws Exception;

    public List<Orders> getOrdersByStatusZero() throws Exception;

    public Integer findOrdersAddByNew() throws Exception;

    public Double findOrdersMoneyByNew() throws Exception;

    public Double findSuccessScale() throws Exception;

    public List<Orders> findOrdersByNew() throws Exception;

    public List<Orders> findOrdersByRefund() throws Exception;

    public List<Orders> findOrdersBySuccess() throws Exception;

    public Orders findOrderByOrderNum(String orderNum) throws Exception;
}
