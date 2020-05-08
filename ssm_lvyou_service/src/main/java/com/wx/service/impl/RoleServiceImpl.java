package com.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.wx.dao.IRoleDao;
import com.wx.dao.IUserDao;
import com.wx.domain.Permission;
import com.wx.domain.Role;
import com.wx.domain.UserInfo;
import com.wx.service.RoleService;
import com.wx.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private IRoleDao roleDao;

    @Autowired
    private IUserDao userDao;

    @Override
    public List<Role> findAll(Integer page, Integer size, String title) throws Exception {
        if ("".equals(title)) {
            PageHelper.startPage(page, size);
            return roleDao.findAll();
        }else {
            PageHelper.startPage(page, size);
            return roleDao.likeAll(title);
        }
    }

    @Override
    public void save(Role role) throws Exception {
        role.setId(UuidUtils.createUuid());
        roleDao.save(role);
    }

    @Override
    public Role findById(String id) throws Exception {
        return roleDao.findById(id);
    }

    /**
     * 根据角色id查询可以添加的权限
     * @param id
     * @return
     */
    @Override
    public List<Permission> findRoleByIdAndAllPermission(String id, Integer page, Integer size, String title) throws Exception {
        if ("".equals(title)){
            PageHelper.startPage(page,size);
            return roleDao.findRoleByIdAndAllPermission(id);
        }else {
            PageHelper.startPage(page,size);
            return roleDao.likePermissionByRoleIdAndPermissionName(id, title);
        }

    }

    /**
     * 根据角色id添加权限ids
     * @param roleId
     * @param ids
     * @return
     */
    @Override
    public void addPermissionToRole(String roleId, String[] ids) throws Exception {
        //roleId 和 ids 进行是否为空判断
        if (roleId == "" || roleId == null){
            if (ids == null || ids.length == 0){
                return;
            }
        }

        for (String permissionId : ids ) {
            roleDao.addPermissionToRole(roleId, permissionId);
        }
    }

    @Override
    public void deleteRoleByRoleId(String roleId) throws Exception {
        //要删除role角色，必须先删除中间表中的数据
        List<Role> roles = roleDao.findRolePermissionByRoleId(roleId);

        if (roles != null || roles.size() != 0){
            //中间表有数据，要删除中间表数据
            for (int i = 0; i < roles.size(); i++) {
                //删除中间表数据
                roleDao.deleteRolePermissionByRoleId(roleId);
            }
        }
        //要删除role角色，必须先删除中间表中的数据
        List<UserInfo> users = userDao.findUserRoleByRoleId(roleId);
        if (users != null || users.size() != 0){
            //中间表有数据，要删除中间表数据
            for (int i = 0; i < users.size(); i++) {
                //删除中间表数据
                userDao.deleteUserRoleByRoleId(roleId);
            }
        }

        roleDao.deleteRoleByRoleId(roleId);
    }

    @Override
    public void edit(Role role) throws Exception {
        roleDao.edit(role);
    }

    @Override
    public Role findRoleByRoleName(String name) throws Exception {
        return roleDao.findRoleByRoleName(name);
    }
}
