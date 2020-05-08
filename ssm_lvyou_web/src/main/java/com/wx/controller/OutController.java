package com.wx.controller;

import com.wx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/out")
@RolesAllowed({"ADMIN","LOGIN","TEST"})
public class OutController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IUserService userService;

    /**
     * ajax请求，退出时修改最后登录时间
     * @param name
     * @return
     * @throws Exception
     */
    @RequestMapping("/editOutTimeByName.do")
    @ResponseBody
    public boolean editOutTimeByName(@RequestParam(name = "name", required = true)String name) throws Exception{
        LocalDateTime time = (LocalDateTime) request.getSession().getAttribute("loginTime");
        userService.editOutTimeByName(name, time);
        return true;
    }
}
