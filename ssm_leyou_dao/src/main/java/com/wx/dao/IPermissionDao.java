package com.wx.dao;

import com.wx.domain.Permission;
import org.apache.ibatis.annotations.*;

import javax.swing.*;
import java.util.List;

public interface IPermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{id})")
    public List<Permission> findPermissionByRoleId(String id) throws Exception;


    @Select("SELECT * FROM permission")
    public List<Permission> findAll() throws Exception;

    @Insert("INSERT INTO permission (id, permissionName, url) VALUES (#{id},#{permissionName},#{url})")
    public void save(Permission permission) throws Exception;

    @Select("SELECT * FROM permission WHERE id = #{id}")
    public Permission findById(String id) throws Exception;

    /**
     * 根据permissionId查询中间表的关系
     * @param permissionId
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM role_permission WHERE permissionId = #{permissionId}")
    public List<Object> findRolePermissionByPermissionId(String permissionId) throws Exception;

    /**
     * 根据permissionId删除中间表的关系
     * @param permissionId
     * @throws Exception
     */
    @Delete("DELETE FROM role_permission WHERE permissionId = #{permissionId}")
    public void deleteRolePermissionByPermissionId(String permissionId) throws Exception;

    /**
     * 根据permissionId删除permission表的数据
     * @param permissionId
     * @throws Exception
     */
    @Delete("DELETE FROM permission WHERE id = #{permissionId}")
    public void deletePermissionByPermissionId(String permissionId) throws Exception;

    @Update("UPDATE permission SET permissionName = #{permissionName} , url = #{url} WHERE id = #{id}")
    public void edit(Permission permissionId) throws Exception;

    //根据权限名模糊查询
    @Select("SELECT * FROM permission WHERE permissionName LIKE '%${title}%'")
    public List<Permission> likeAll(@Param("title") String title) throws Exception;
}
