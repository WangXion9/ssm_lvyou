package com.wx.service;

import com.wx.domain.Permission;

import java.util.List;

public interface IPermissionService {

    public List<Permission> findAll(Integer page, Integer size, String title) throws Exception;

    public void save(Permission permission) throws Exception;

    public Permission findById(String id) throws Exception;

    public void deletePermissionByPermissionId(String permissionId) throws Exception;

    public void edit(Permission permissionId) throws Exception;
}
