package com.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.wx.dao.IMemberDao;
import com.wx.dao.IOrderesDao;
import com.wx.dao.ITravellerDao;
import com.wx.domain.Member;
import com.wx.domain.Orders;
import com.wx.domain.Traveller;
import com.wx.domain.dto.OrdersDto;
import com.wx.service.IOrdersService;
import com.wx.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


    @Service
    @Transactional
    public class OrdersServiceImpl implements IOrdersService {

        @Autowired
        private IOrderesDao orderesDao;

        @Autowired
        private IMemberDao memberDao;

        @Autowired
        private ITravellerDao travellerDao;

        @Override
        public List<Orders> findAll(int page, int size, String title) throws Exception {
            //pageNum是页码值，pageSize是每页显示条数，必须写在调用查询之前
            if ("".equals(title)){
                PageHelper.startPage(page,size);
                return orderesDao.findAll();
            }else {
                PageHelper.startPage(page,size);
                return orderesDao.findLike(title);
            }

        }

        public Orders findById(String ordersId) throws Exception {
        return orderesDao.findById(ordersId);
    }

    @Override
    public void updateOrdersByIds(String[] ids) throws Exception {
        for (String id:ids) {
            orderesDao.updateOrdersByIds(id);
        }
    }

    /**
     * 根据id删除订单
     * @param ids
     * @throws Exception
     */
    @Override
    public void deleteByOrdersId(String[] ids) throws Exception {
        if (ids == null || ids.length == 0){
            return;
        }

        for (String id : ids) {
            //查询看中间表中是否有数据
            List<Object> list = orderesDao.findOrderTravellerByOrderId(id);
            if (list != null || list.size() != 0){
                //1.先删除order_traveller表中的数据
                orderesDao.deleteOrderTravellerByOrderId(id);
            }
            //2.再删除orders表中的数据
            orderesDao.deleteOrderByOrderId(id);
        }


    }

    @Override
    public void saveAll(OrdersDto ordersDto) throws Exception {
        //存储会员信息
        Member member = ordersDto.getMember();
        if (member != null) {
            member.setId(UuidUtils.createUuid());
            member.setCreateTime(new Date());
            memberDao.save(member);
        }


        //保存订单
        ordersDto.setId(UuidUtils.createUuid());
        ordersDto.setOrderTime(new Date());
        //设置订单中memberId的值
        ordersDto.setMemberId(member.getId());
        orderesDao.save(ordersDto);


        //存储游客信息
        List<Traveller> travellers = ordersDto.getTravellers();
        int size = travellers.size();
        if (travellers != null || travellers.size() != 0) {
            for (Traveller traveller : travellers) {
                //判断游客只有有姓名有身份证号的才添加
                if (!"".equals(traveller.getName()) || !"".equals(traveller.getCredentialsNum())) {
                    traveller.setId(UuidUtils.createUuid());
                    travellerDao.save(traveller);
                    //存储游客和订单的中间表关系
                    orderesDao.saveOrderTraveller(ordersDto.getId(), traveller.getId());
                }
            }
        }
    }

    /**
     * 跟新订单所有的信息
     * @param ordersDto
     * @throws Exception
     * 思考：
     * 我们的跟新订单操作中，我们的会员和游客信息是删除在新增还是修改？
     * 如果是删除再新增的话：那我们会员和游客的信息都是新的，会给服务器造成压力
     * 如果是修改的话：那我们订单中删除的游客如何操作？新增加的游客如何操作？
     */
    @Override
    public void editOrdersAll(OrdersDto ordersDto) throws Exception {
        //先更新会员
        Member member = ordersDto.getMember();
        member.setId(ordersDto.getMemberId());
        if (member != null){
            memberDao.updateById(member);
        }
        //在更新游客
        List<Traveller> travellers = ordersDto.getTravellers();
        if (travellers != null || travellers.size()!= 0){
            //查询该订单下所有的游客，删除，重新添加
            List<Traveller> list = travellerDao.findByOrdersId(ordersDto.getId());
            //删除中间表信息，订单和游客
            orderesDao.deleteOrderTravellerByOrderId(ordersDto.getId());
            for (Traveller traveller:list) {
                travellerDao.deleteById(traveller.getId());
            }
            //存储游客信息
            for (Traveller traveller:travellers) {
                //判断游客只有有姓名有身份证号的才添加
                if (!"".equals(traveller.getName()) ||  !"".equals(traveller.getCredentialsNum())){
                    traveller.setId(UuidUtils.createUuid());
                    travellerDao.save(traveller);
                    //存储游客和订单的中间表关系
                    orderesDao.saveOrderTraveller(ordersDto.getId(), traveller.getId());
                }

            }
        }
        //在更新订单
        orderesDao.updateOrdersAllById(ordersDto);
    }

    @Override
    public List<Orders> getOrdersByStatusZero() throws Exception {
        return orderesDao.getOrdersByStatusZero();
    }

    @Override
    public Integer findOrdersAddByNew() throws Exception {
        return orderesDao.findOrdersAddByNew();
    }

    @Override
    public Double findOrdersMoneyByNew() throws Exception {
        return orderesDao.findOrdersMoneyByNew();
    }

    @Override
    public Double findSuccessScale() throws Exception {
        //获取退款人数
        Integer refoundCount = orderesDao.findOrdersRefund();

        //获取交易成功的人数
        Integer successCount = orderesDao.findOrdersSuccess();
        double sum =  (refoundCount + successCount);

        double refound = refoundCount;
        double s = refound / sum;
        BigDecimal b = new BigDecimal(s);
        double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }

    @Override
    public List<Orders> findOrdersByNew() throws Exception {
        return orderesDao.findOrdersByNew();
    }

    @Override
    public List<Orders> findOrdersByRefund() throws Exception {
        return orderesDao.findOrdersByRefund();
    }

    @Override
    public List<Orders> findOrdersBySuccess() throws Exception {
        return orderesDao.findOrdersBySuccess();
    }

    @Override
    public Orders findOrderByOrderNum(String orderNum) throws Exception {
        return orderesDao.findOrderByOrderNum(orderNum);
    }
}
