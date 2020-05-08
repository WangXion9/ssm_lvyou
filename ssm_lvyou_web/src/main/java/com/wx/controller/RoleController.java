package com.wx.controller;

import com.github.pagehelper.PageInfo;
import com.wx.domain.Permission;
import com.wx.domain.Role;
import com.wx.service.RoleService;
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
@RequestMapping("/role")
@RolesAllowed({"ADMIN","ROLE","TEST"})
public class RoleController {

    @Autowired
    private RoleService roleService;

  /*  @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }*/

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1")Integer page,
                                @RequestParam(name = "size", required = true, defaultValue = "4") Integer size,
                                @RequestParam(name = "title", required = true, defaultValue = "")String title) throws Exception{
        ModelAndView mv = new ModelAndView();
        title = MyStringUtils.create2UTF8(title);
        List<Role> roleList = roleService.findAll(page, size, title);
        //pageInfo就是一个分页bean
        PageInfo pageInfo = new PageInfo(roleList);
        if (!"".equals(title)){
            mv.addObject("title", title);
        }
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Role role) throws Exception{
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(id);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }

    /**
     * 根据角色id查询可以添加的权限
     * @param id
     * @return
     */
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id", required = true) String id,
                                                     @RequestParam(name = "page", required = true, defaultValue = "1")Integer page,
                                                     @RequestParam(name = "size", required = true, defaultValue = "5")Integer size,
                                                     @RequestParam(name = "title", required = true, defaultValue = "")String title) throws Exception{
        ModelAndView mv = new ModelAndView();
        //处理编码问题
        title = MyStringUtils.create2UTF8(title);
        List<Permission> permissionList = roleService.findRoleByIdAndAllPermission(id, page, size, title);
        mv.addObject("permissionList",permissionList);
        PageInfo pageInfo = new PageInfo(permissionList);
        mv.addObject("pageInfo",pageInfo);
        if (!"".equals(title)){
            mv.addObject("title",title);
        }
        //role-permission-add页面需要roleId传过去
        Role role = roleService.findById(id);
        mv.addObject("role",role);
        mv.setViewName("role-permission-add1");
        return mv;
    }

    /**
     * 根据角色id添加权限ids
     * @param roleId
     * @param ids
     * @return
     */
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(
            @RequestParam(name = "roleId", required = true)String roleId,
            @RequestParam(name = "ids", required = true)String[] ids) throws Exception{
        roleService.addPermissionToRole(roleId, ids);
        return "redirect:findAll.do";
    }

    @RequestMapping("deleteRole.do")
    public String deleteRoleByRoleId(@RequestParam(name = "id", required = true)String id) throws Exception{
        roleService.deleteRoleByRoleId(id);
        return "redirect:findAll.do";
    }


    @RequestMapping("/editBeforeById.do")
    public ModelAndView editBeforeById(@RequestParam(name = "id", required = true)String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(id);
        mv.addObject("role",role);
        mv.setViewName("role-edit");
        return mv;
    }


    @RequestMapping("/edit.do")
    public String edit(Role role) throws Exception{
        roleService.edit(role);
        return "redirect:findAll.do";
    }

    /**
     * 根据ids删除角色
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteRoleByIds.do")
    public String deleteRoleByIds(@RequestParam(name = "ids", required = true)String[] ids) throws Exception{
        for (String id:ids
             ) {
            deleteRoleByRoleId(id);
        }
        return "redirect:findAll.do";
    }

    @RequestMapping("/findRoleByRoleName.do")
    @ResponseBody
    public Boolean findRoleByRoleName(@RequestParam(name = "name", required = true)String name,
                                      @RequestParam(name = "id", required = true, defaultValue = "")String id) throws Exception{
        Role role = roleService.findRoleByRoleName(name);
        if (role == null){
            return true;
        }else {
            if (role.getId().equals(id)){
                return true;
            }
            //如果传进来的姓名和查询到的姓名一样
            if (role.getRoleName().toUpperCase().equals(name.toUpperCase())){
                return false;
            }
            return false;
        }
    }

}
