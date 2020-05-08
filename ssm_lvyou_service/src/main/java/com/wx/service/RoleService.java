package com.wx.service;

import com.wx.domain.Permission;
import com.wx.domain.Role;

import java.util.List;

public interface RoleService {
    public List<Role> findAll(Integer page, Integer size, String title) throws Exception;

    public void save(Role role) throws Exception;

    public Role findById(String id) throws Exception;

    public List<Permission> findRoleByIdAndAllPermission(String id, Integer page, Integer size, String title) throws Exception;

    public void addPermissionToRole(String roleId, String[] ids) throws Exception;

    public void deleteRoleByRoleId(String roleId) throws Exception;

    public void edit(Role role) throws Exception;

    public Role findRoleByRoleName(String name) throws Exception;
}
