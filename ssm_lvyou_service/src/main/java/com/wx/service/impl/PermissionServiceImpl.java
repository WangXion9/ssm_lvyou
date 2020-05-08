package com.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.wx.dao.IPermissionDao;
import com.wx.domain.Permission;
import com.wx.service.IPermissionService;
import com.wx.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    //@Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public List<Permission> findAll(Integer page, Integer size, String title) throws Exception {
        if ("".equals(title)) {
            PageHelper.startPage(page, size);
            return permissionDao.findAll();
        }else {
            PageHelper.startPage(page, size);
            return permissionDao.likeAll(title);
        }
    }

    @Override
    public void save(Permission permission) throws Exception {
        permission.setId(UuidUtils.createUuid());
        permissionDao.save(permission);
    }

    @Override
    public Permission findById(String id) throws Exception {
        return permissionDao.findById(id);
    }

    /**
     * 根据PermissionId删除role_permission表中数据
     * @param permissionId
     * @throws Exception
     */
    @Override
    public void deletePermissionByPermissionId(String permissionId) throws Exception {
        //先查询role_permission有没有数据

        List<Object> list = permissionDao.findRolePermissionByPermissionId(permissionId);
        if (list != null || list.size() != 0){
            permissionDao.deleteRolePermissionByPermissionId(permissionId);
        }
        permissionDao.deletePermissionByPermissionId(permissionId);
    }

    @Override
    public void edit(Permission permissionId) throws Exception {
        permissionDao.edit(permissionId);
    }
}
