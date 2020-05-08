package com.wx.controller;

import com.github.pagehelper.PageInfo;
import com.wx.domain.Diary;
import com.wx.domain.Orders;
import com.wx.domain.Product;
import com.wx.domain.dto.OrdersDto;
import com.wx.service.IDiaryService;
import com.wx.service.IMemberService;
import com.wx.service.IOrdersService;
import com.wx.service.IProductService;
import com.wx.service.impl.OrdersServiceImpl;
import com.wx.utils.MyStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/orders")
@RolesAllowed({"ADMIN","ORDERS","TEST"})
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IDiaryService diaryService;

    @Autowired
    private IMemberService memberService;

    /* 查询所有，为分页的
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv =new ModelAndView();
        List<Orders> ordersList = ordersService.findAll();
        mv.addObject("ordersList",ordersList);
        mv.setViewName("orders-list");
        return mv;
    }*/

    /**
     * 分页查询所有
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
        public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1")Integer page,
                                @RequestParam(name = "size",required = true, defaultValue = "4")Integer size,
                                    @RequestParam(name = "title", required = true, defaultValue = "")String title) throws Exception {
        ModelAndView mv = new ModelAndView();
        title = MyStringUtils.create2UTF8(title);
        List<Orders> ordersList = ordersService.findAll(page, size, title);
        //pageInfo就是一个分页bean
        PageInfo pageInfo = new PageInfo(ordersList);
        if (!"".equals(title)){
            mv.addObject("title", title);
        }
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    /**
     * 根据id查询订单
     * @param ordersId
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String ordersId) throws Exception{
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }

    /**
     * 根据id修改订单状态
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateOrdersByIds.do")
    public String updateOrdersByIds(@RequestParam(name = "ids", required = true)String[] ids) throws Exception{
        if (ids != null && ids.length!= 0){
            ordersService.updateOrdersByIds(ids);
        }
        return "redirect:findAll.do";
    }

    /**
     * 根据id删除订单
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteByOrdersId.do")
    public String ordersService(@RequestParam(name = "ids", required = true)String[] ids) throws Exception{
        if (ids != null && ids.length != 0){
            //ordersService.ordersService(ids);
            ordersService.deleteByOrdersId(ids);
        }
        return "redirect:findAll.do";
    }

    /**
     * 根据订单id修改订单信息
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/editById.do")
    public ModelAndView editById(@RequestParam(name = "id", required = true)String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(id);
        mv.addObject("orders",orders);
        mv.setViewName("orders-edit");
        return mv;
    }

    @RequestMapping("/saveAll.do")
    public String saveAll(OrdersDto ordersDto) throws Exception{

        ordersService.saveAll(ordersDto);

        return "redirect:findAll.do";
    }

    @RequestMapping("/editOrdersAll.do")
    public String editOrdersAll(OrdersDto ordersDto) throws Exception{
        ordersService.editOrdersAll(ordersDto);
        return "redirect:findAll.do";
    }

    @RequestMapping("/getOrdersByStatusZero.do")
    public @ResponseBody PageInfo getOrdersByStatusZero() throws Exception{
        List<Orders> ordersList = ordersService.getOrdersByStatusZero();
        PageInfo pageInfo = new PageInfo(ordersList);
        return pageInfo;
    }

    @RequestMapping("/getOtherByNew.do")
    @ResponseBody
    public HashMap getOtherByNew() throws Exception{
        //每日新增订单数
        Integer ordersAddByNew = ordersService.findOrdersAddByNew();
        //每日新增订单数的金额
        Double ordersMoneyByNew = ordersService.findOrdersMoneyByNew();
        if (ordersMoneyByNew == null ){
            ordersMoneyByNew = 0.00;
        }
        //每日新会员注册数
        Integer memberAddByNew = memberService.findMemeberAddByNew();
        //订单的比例，交易成功的比例
        Double successScale = ordersService.findSuccessScale();

        HashMap hashMap = new HashMap();
        hashMap.put("ordersAddByNew", ordersAddByNew);
        hashMap.put("ordersMoneyByNew", ordersMoneyByNew);
        hashMap.put("memberAddByNew", memberAddByNew);
        hashMap.put("successScale", successScale);

        //
        List<Orders> ordersList = ordersService.getOrdersByStatusZero();
        PageInfo ordersPageInfo = new PageInfo(ordersList);
        hashMap.put("ordersPageInfo",ordersPageInfo);

        //
        List<Diary> diaryList = diaryService.getDiaryByStatusZero();
        PageInfo diaryPageInfo = new PageInfo(diaryList);
        hashMap.put("diaryPageInfo",diaryPageInfo);
        return hashMap;
    }

    /**
     * 首页查询今日新增订单
     * @return
     * @throws Exception
     */
    @RequestMapping("/findOrdersByNew.do")
    public ModelAndView findOrdersByNew() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findOrdersByNew();
        mv.addObject("ordersList", ordersList);
        mv.setViewName("orders-newlist");
        return mv;
    }

    /**
     * 首页查询所有退款的订单
     * @return
     * @throws Exception
     */
    @RequestMapping("/findOrdersByRefund.do")
    public ModelAndView findOrdersByRefund() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findOrdersByRefund();
        List<Orders> ordersListSuccess = ordersService.findOrdersBySuccess();
        mv.addObject("ordersList", ordersList);
        mv.addObject("ordersListSuccess", ordersListSuccess);
        mv.setViewName("orders-refund");
        return mv;
    }

    @RequestMapping("/findOrderByOrderNum.do")
    @ResponseBody
    public boolean findOrderByOrderNum(@RequestParam(name = "name", required = true) String username,
                                       @RequestParam(name = "id", required = true, defaultValue = "")String id) throws Exception{
        username = MyStringUtils.create2UTF8(username);
        Orders orders = ordersService.findOrderByOrderNum(username);
        if (orders == null){
            return true;
        }else {
            if (orders.getId().equals(id)){
                return true;
            }
            //如果传进来的姓名和查询到的姓名一样
            if (orders.getOrderNum().toUpperCase().equals(username.toUpperCase())){
                return false;
            }
            return false;
        }

    }

}
