package com.wx.controller;

import com.github.pagehelper.PageInfo;
import com.wx.domain.Permission;
import com.wx.service.IPermissionService;
import com.wx.utils.MyStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/permission")
@RolesAllowed({"ADMIN","PERMISSION","TEST"})
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

   /* @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList = permissionService.findAll();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }*/

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1")Integer page,
                                @RequestParam(name = "size",required = true, defaultValue = "4")Integer size,
                                @RequestParam(name = "title", required = true, defaultValue = "")String title) throws Exception{
        ModelAndView mv = new ModelAndView();
        title = MyStringUtils.create2UTF8(title);
        List<Permission> permissionList = permissionService.findAll(page, size, title);
        //pageInfo就是一个分页bean
        PageInfo pageInfo = new PageInfo(permissionList);
        if (!"".equals(title)){
            mv.addObject("title",title);
        }
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception{
        permissionService.save(permission);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true)String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Permission permission = permissionService.findById(id);
        mv.addObject("permission",permission);
        mv.setViewName("permission-show");
        return mv;
    }

    @RequestMapping("deletePermission.do")
    public String deletePermissionByPermissionId(@RequestParam(name = "id", required = true)String id) throws Exception{
        permissionService.deletePermissionByPermissionId(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/editBeforeById.do")
    public ModelAndView editBeforeById(@RequestParam(name = "id",required = true)String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Permission permission = permissionService.findById(id);
        mv.addObject("permission",permission);
        mv.setViewName("permission-edit");
        return mv;
    }

    @RequestMapping("/edit.do")
    public String edit(Permission permission) throws Exception{
        permissionService.edit(permission);
        return "redirect:findAll.do";
    }

    /**
     * 根据ids循环删除
     * @return
     * @throws Exception
     */
    @RequestMapping("/deletePerByIds.do")
    public String deletePerByIds(@RequestParam(name = "ids", required = true)String[] ids) throws Exception{
        for (String id:ids
             ) {
            deletePermissionByPermissionId(id);
        }
        return "redirect:findAll.do";
    }
}
