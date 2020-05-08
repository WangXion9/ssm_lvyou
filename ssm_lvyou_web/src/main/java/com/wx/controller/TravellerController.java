package com.wx.controller;

import com.github.pagehelper.PageInfo;
import com.wx.domain.Member;
import com.wx.domain.Traveller;
import com.wx.service.ITravellerService;
import com.wx.utils.MyStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/traveller")
@RolesAllowed({"ADMIN","TRAVELLER","TEST"})
public class TravellerController {

    @Autowired
    private ITravellerService travellerService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1")Integer page,
                                @RequestParam(name = "size", required = true, defaultValue = "4")Integer size,
                                @RequestParam(name = "title", required = true, defaultValue = "")String title) throws Exception{
        ModelAndView mv = new ModelAndView();
        title = MyStringUtils.create2UTF8(title);
        List<Traveller> travellerList = travellerService.findAll(page, size, title);
        //将数据封装到pageInfo对象中
        PageInfo pageInfo = new PageInfo(travellerList);
        //传回title数据
        if (!"".equals(title)){
            mv.addObject("title",title);
        }
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("traveller-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Traveller traveller) throws Exception{
        travellerService.save(traveller);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true)String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Traveller traveller = travellerService.findById(id);
        mv.addObject("traveller",traveller);
        mv.setViewName("traveller-show");
        return mv;
    }

    @RequestMapping("/editBeforeById.do")
    public ModelAndView editBeforeById(@RequestParam(name = "id", required = true)String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Traveller traveller = travellerService.findById(id);
        mv.addObject("traveller",traveller);
        mv.setViewName("traveller-edit");
        return mv;
    }

    @RequestMapping("/edit.do")
    public String edit(Traveller traveller) throws Exception {
        travellerService.edit(traveller);
        return "redirect:findAll.do";
    }

    @RequestMapping("/deleteByOrdersIds.do")
    public String deleteByOrdersIds(@RequestParam(name = "ids", required = true)String[] ids) throws Exception {
        travellerService.deleteByOrdersIds(ids);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findTravellerByTravellerName.do")
    public @ResponseBody boolean findTravellerByTravellerName(@RequestParam(name = "name", required = true) String name,
                                                              @RequestParam(name = "id", required = true, defaultValue = "")String id) throws Exception{
        name = MyStringUtils.create2UTF8(name);
        Traveller traveller = travellerService.findTravellerByTravellerName(name);
        if (traveller == null){
            return true;
        }else {
            if (traveller.getId().equals(id)){
                return true;
            }
            //如果传进来的姓名和查询到的姓名一样
            if (traveller.getName().toUpperCase().equals(name.toUpperCase())){
                return false;
            }
            return false;
        }

    }
}
