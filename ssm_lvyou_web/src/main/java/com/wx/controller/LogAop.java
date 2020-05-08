package com.wx.controller;

import com.wx.domain.SysLog;
import com.wx.service.ISysLogService;
import com.wx.utils.UuidUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {


    //获取ip地址的对象
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;

    private Date visitTime;
    private Class clazz;
    private Method method;

    @Before("execution(* com.wx.controller.*.*(..))")
    public void doBeFore(JoinPoint jp) throws NoSuchMethodException {
        visitTime = new Date();
        //获取当前类
        clazz = jp.getTarget().getClass();

        //判断如果是SysLogController类就直接跳出
        if (clazz == SysLogController.class)
            return;
        //获取当前调用方法字符串
        String clazzName = jp.getSignature().getName();
        //获取当前调用方法参数
        Object[] args = jp.getArgs();
        if (args == null || args.length == 0){
            //无参数
            method = clazz.getMethod(clazzName);
        }else {
            //有参数
            Class[] argsClass = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                argsClass[i] =  args[i].getClass();
            }
            method = clazz.getMethod(clazzName, argsClass);
        }

    }



    @After("execution(* com.wx.controller.*.*(..))")
    public void doBeAfter(JoinPoint jp) throws Exception {
        //判断如果是SysLogController类就直接跳出
        if (clazz == SysLogController.class)
            return;

        //获取执行的时间
        Long time = new Date().getTime() - visitTime.getTime();

        String url = "";
        //当前执行类不能是LogAop
        if (clazz != null && method != null && clazz != LogAop.class){
            RequestMapping clazzAnnotation = (RequestMapping)clazz.getAnnotation(RequestMapping.class);
            if (clazzAnnotation != null){
                //获取类上的注解
                String[] clazzValue = clazzAnnotation.value();
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null){
                    //获取方法上的注解
                    String[] methodValue = methodAnnotation.value();
                    url = clazzValue[0] + methodValue[0];
                }
            }
        }

        //获取ip地址
        String ip = request.getRemoteAddr();

        //如何获取当前的操作者
        SecurityContext context = SecurityContextHolder.getContext();//从上下文中获取当前登录的用户
        User user = (User)context.getAuthentication().getPrincipal();
        String username = user.getUsername();

        //封装日志相关信息
        SysLog sysLog = new SysLog();
        sysLog.setId(UuidUtils.createUuid());
        sysLog.setVisitTime(visitTime);
        sysLog.setIp(ip);
        sysLog.setExecutionTime(time);
        sysLog.setUsername(username);
        sysLog.setUrl(url);
        sysLog.setMethod( "[类名] " + clazz.getName() + "[方法名] " + method.getName());

        //调用SysLogService方法写数据库
        sysLogService.save(sysLog);


    }
}
