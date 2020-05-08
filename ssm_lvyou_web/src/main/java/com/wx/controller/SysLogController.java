package com.wx.controller;

import com.github.pagehelper.PageInfo;
import com.wx.domain.SysLog;
import com.wx.service.ISysLogService;
import com.wx.utils.MyStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/sysLog")
@RolesAllowed({"ADMIN","SYSLOG","TEST"})
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    /*@RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogs = sysLogService.findAll();
        mv.addObject("sysLogs",sysLogs);
        mv.setViewName("syslog-list");
        return mv;
    }*/
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1")Integer page,
                                @RequestParam(name = "size", required = true, defaultValue = "15") Integer size,
                                @RequestParam(name = "title", required = true, defaultValue = "")String title) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogs = sysLogService.findAll(page, size, title);
        title = MyStringUtils.create2UTF8(title);
        //pageInfo就是一个分页bean
        PageInfo pageInfo = new PageInfo(sysLogs);
        if (!"".equals(title)){
            mv.addObject("title",title);
        }
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("sysLogs",sysLogs);
        mv.setViewName("syslog-list");
        return mv;
    }
}
