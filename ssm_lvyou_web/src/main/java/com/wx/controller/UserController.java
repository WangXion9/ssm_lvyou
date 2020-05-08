package com.wx.controller;

import com.github.pagehelper.PageInfo;
import com.wx.domain.Role;
import com.wx.domain.UserInfo;
import com.wx.service.IUserService;
import com.wx.utils.MyStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
@RolesAllowed({"ADMIN","USER","TEST"})//只有ADMIN或者USER权限的才可以访问
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private HttpServletRequest request;

/*    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")      //只有ADMIN权限的才可以访问
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userService.findAll();
        mv.addObject("userList",userList);
        mv.setViewName("user-list");
        return mv;
    }*/

    /**
     * 分页查询所有用户
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    //@RolesAllowed({"ADMIN","USER"})      //只有ADMIN权限的才可以访问
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1")Integer page,
                                @RequestParam(name = "size", required = true, defaultValue = "4") Integer size,
                                @RequestParam(name = "title", required = true, defaultValue = "")String title) throws Exception{
        ModelAndView mv = new ModelAndView();
        title = MyStringUtils.create2UTF8(title);
        List<UserInfo> userList = userService.findAll(page,size, title);
        //pageInfo就是一个分页bean
        PageInfo pageInfo = new PageInfo(userList);
        if (!"".equals(title)){
            mv.addObject("title", title);
        }
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("userList",userList);
        mv.setViewName("user-list");
        //int a = 1/0;
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception{
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    /**
     * 根据用户id查询可以添加的角色
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true)String id,
                                               @RequestParam(name = "page", required = true, defaultValue = "1")Integer page,
                                               @RequestParam(name = "size", required = true, defaultValue = "5")Integer size,
                                               @RequestParam(name = "title", required = true, defaultValue = "")String title) throws Exception{
        ModelAndView mv = new ModelAndView();
        title = MyStringUtils.create2UTF8(title);
        List<Role> roleList = userService.findUserByIdAndAllRole(id, page, size, title);
        //user-role-add页面中需要用到userId
        UserInfo user = userService.findById(id);
        if (!"".equals(title)){
            mv.addObject("title",title);
        }
        mv.addObject("user",user);
        mv.addObject("roleList",roleList);
        PageInfo pageInfo = new PageInfo(roleList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user-role-add1");
        return mv;
    }

    /**
     * 根据角色id给用户添加关系
     * @param ids
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(
            @RequestParam(name = "ids", required = true)String[] ids,
            @RequestParam(name = "userId", required = true)String userId) throws Exception{
        userService.addRoleToUser(userId, ids);
        return "redirect:findAll.do";
    }

    @RequestMapping("/editBeforeById.do")
    public ModelAndView editBeforeById(@RequestParam(name = "id", required = true)String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-edit");
        return mv;
    }

    @RequestMapping("/edit.do")
    public String edit(UserInfo userInfo) throws Exception{
        userService.edit(userInfo);
        return "redirect:findAll.do";
    }

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    @RequestMapping("/editBeforePasswordByUsereName.do")
    public ModelAndView editBeforePasswordByUsereName(@RequestParam(name = "username", required = true)String username) throws Exception{
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findByUserName(username);
        mv.addObject("user",userInfo);
        mv.setViewName("user-edit-password");
        return mv;
    }

    @RequestMapping("/editByUsername.do")
    public String editByUsername(UserInfo userInfo) throws Exception{
        userService.editByUsername(userInfo);
        return "../index";
    }


    /**
     * 根据ids修改用户的状态为1
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping("/editUserStatusByIds.do")
    public String editUserStatusByIds(@RequestParam(name = "ids", required = true) String[] ids) throws Exception{
        userService.editUserStatusByIds(ids);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findUserByUserName.do")
    @ResponseBody
    public Boolean findUserByUserName(@RequestParam(name = "name", required = true) String username,
                                      @RequestParam(name = "id", required = true, defaultValue = "")String id) throws Exception{
        UserInfo userInfo = userService.findByUserName(username);
        if (userInfo == null){
            return true;
        }else {
            if (userInfo.getId().equals(id)){
                return true;
            }
            //如果传进来的姓名和查询到的姓名一样
            if (userInfo.getUsername().toUpperCase().equals(username.toUpperCase())){
                return false;
            }
            return false;
        }
    }

    /**
     * ajax请求获取最后一次登录时间
     *
     * @param name
     * @return
     * @throws Exception
     */
    @RequestMapping("/getUserByName.do")
    @ResponseBody
    public UserInfo getUserByName(@RequestParam(name = "name", required = true)String name) throws Exception{
        UserInfo user = userService.findByUserName(name);
        return user;
    }

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
