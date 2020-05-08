package com.wx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常捕捉类
 */
@ControllerAdvice
public class ApplicationControllerExceptionHandler {

    //获取ip地址的对象
    @Autowired
    private HttpServletRequest request;


    @ExceptionHandler(value = Exception.class)
    public ModelAndView Exception(){
        //StringBuffer requestURL = request.getRequestURL();
        System.out.println(request.getRequestURL());
        ModelAndView mv = new ModelAndView();
        String msg = "服务器正忙，请稍后再重新操作！";
        mv.addObject("msg",msg);
        mv.setViewName("main");
        return mv;
    }

    @ExceptionHandler(value = BindException.class)
    public ModelAndView BindException(){
        ModelAndView mv = new ModelAndView();
        String msg = "参数错误，请稍候重新操作！！";
        mv.addObject("msg",msg);
        mv.setViewName("main");
        return mv;
    }




}
