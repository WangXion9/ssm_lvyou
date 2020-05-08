package com.wx.controller;

import com.github.pagehelper.PageInfo;
import com.wx.domain.City;
import com.wx.domain.Orders;
import com.wx.domain.Product;
import com.wx.domain.dto.OrdersDto;
import com.wx.service.ICityService;
import com.wx.service.IOrdersService;
import com.wx.service.IProductService;
import com.wx.utils.MyStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/product")
@RolesAllowed({"ADMIN","PRODUCT","TEST"})
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IOrdersService ordersService;

    @Autowired
    private ICityService cityService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1")Integer page,
                                @RequestParam(name = "size", required = true, defaultValue = "4")Integer size,
                                @RequestParam(name = "title", required = true, defaultValue = "")String title) throws Exception{
        title = MyStringUtils.create2UTF8(title);
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.findAll(page,size,title);
        PageInfo pageInfo = new PageInfo(productList);
        if (!"".equals(title)){
            mv.addObject("title",title);
        }
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list1");
        for (Product product: productList
             ) {
            System.out.println(product);
        }
        return mv;
    }

    /**
     * 产品添加
     * @param product
     */
    @RequestMapping("/save.do")
    public String saveProduct(Product product) throws Exception{
        System.out.println(product);
        productService.save(product);
        return "redirect:findAll.do";
    }

    /**
     * 根据id进行删除商品
     * @param ids
     * @return
     */
    @RequestMapping("/deleteByIds.do")
    public String deleteByIds(String[] ids) throws Exception{
        productService.deleteByIds(ids);
//        for (String newId : id){
//            System.out.println(newId);
//        }
        return "redirect:findAll.do";
    }

    /**
     * 根据ids修改产品开启状态
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateByIds.do")
    public String updateStatusByIds(String[] ids) throws Exception{
        productService.updateStatusByIds(ids);
        return "redirect:findAll.do";
    }

    /**
     * 根据id值来修改产品
     * @param product
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateById.do")
    public String updateById(Product product) throws Exception{
        productService.updateById(product);
        return "redirect:findAll.do";
    }

    /**
     * 根据id查询产品
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception{
        Product product = productService.findById(id);
        List<City> cityList = cityService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("product",product);
        mv.addObject("cityList",cityList);
        mv.setViewName("product-edit");
        return mv;
    }

    /**
     * 根据id查询产品用来显示
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/findByIdShow.do")
    public ModelAndView findByIdShow(String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Product product = productService.findById(id);
        mv.addObject("product",product);
        mv.setViewName("product-show");
        return mv;
    }

    @RequestMapping("/findOrderByProductId.do")
    public ModelAndView findOrderByProductId(@RequestParam(name = "id", required = true)String id,
                                             @RequestParam(name = "page", required = true, defaultValue = "1")Integer page,
                                             @RequestParam(name = "size", required = true, defaultValue = "5")Integer size,
                                             @RequestParam(name = "title", required = true, defaultValue = "")String title) throws Exception{
        ModelAndView mv = new ModelAndView();
        title = MyStringUtils.create2UTF8(title);
        List<Orders> ordersList = productService.findOrderByProductId(id, page, size, title);
        Product product = productService.findById(id);
        PageInfo pageInfo = new PageInfo(ordersList);
        if (!"".equals(title)){
            mv.addObject("title",title);
        }
        mv.addObject("product",product);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("productId",id);
        mv.setViewName("product-order-list");
        return mv;
    }

    /**
     * 根据订单ids删除订单
     * @param pid
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteByOrdersId.do")
    public String deleteByOrdersId(@RequestParam(name = "pid", required = true)String pid,
                                   @RequestParam(name = "ids", required = true)String[] ids) throws Exception{

        if (ids == null || ids.length == 0){
            return "redirect:findOrderByProductId.do?id="+pid;
        }

        productService.deleteByOrdersId(ids);


        return "redirect:findOrderByProductId.do?id="+pid;
    }

    /**
     * 根据订单ids修改订单
     * @param pid
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateOrdersByIds.do")
    public String updateOrdersByIds(@RequestParam(name = "pid", required = true)String pid,
                                    @RequestParam(name = "ids", required = true)String[] ids) throws Exception{
        productService.updateOrdersByIds(ids);
        return "redirect:findOrderByProductId.do?id="+pid;
    }

    /**
     * 根据ajax请求查询产品信息(查找全部产品),条件：产品状态为开启
     * @param page
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAllAjax.do")
    public @ResponseBody PageInfo findAllAjax(@RequestParam(name = "page", required = true, defaultValue = "1")Integer page) throws Exception{
        List<Product> productList = productService.findByStatusOne(page, 5);
        PageInfo pageInfo = new PageInfo(productList);
        request.setAttribute("pageInfo",pageInfo);
        return pageInfo;
    }

    /**
     * 根据产品id去新增订单，准备工作
     * @return
     * @throws Exception
     */
    @RequestMapping("/addBeforeOrdersByProduct.do")
    public ModelAndView addBeforeOrdersByProduct(@RequestParam(name = "productId", required = true)String productId) throws Exception{
        ModelAndView mv = new ModelAndView();
        Product product = productService.findById(productId);
        List<City> cityList = cityService.findAll();
        mv.addObject("product",product);
        mv.addObject("cityList",cityList);
        mv.setViewName("product-orders-add");
        return mv;
    }

    /**
     * 保存订单，产品确定
     * @param ordersDto
     * @return
     */
    @RequestMapping("/saveOrderByProductId.do")
    public String saveOrderByProductId(OrdersDto ordersDto) throws Exception{
        ordersService.saveAll(ordersDto);
        return "redirect:findOrderByProductId.do?id="+ordersDto.getProductId();
    }

    @RequestMapping("/addBeforeProduct.do")
    public ModelAndView addBeforeProduct() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<City> cityList = cityService.findAll();
        mv.addObject("list",cityList);
        mv.addObject("msg","test");
        mv.setViewName("product-add");
        return mv;
    }

    @RequestMapping("/finProductByName.do")
    @ResponseBody
    public boolean finProductByName(@RequestParam(name = "name", required = true) String username,
                                    @RequestParam(name = "id", required = true, defaultValue = "")String id) throws Exception{
        Product product = productService.finProductByName(username);
        if (product == null){
            return true;
        }else {
            if (product.getId().equals(id)){
                return true;
            }
            //如果传进来的姓名和查询到的姓名一样
            if (product.getProductNum().toUpperCase().equals(username.toUpperCase())){
                return false;
            }
            return false;
        }

    }
}
