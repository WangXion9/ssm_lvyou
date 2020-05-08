package com.wx.dao;

import com.wx.domain.Permission;
import com.wx.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IRoleDao {

    @Select("SELECT * FROM role WHERE id IN( SELECT roleId FROM users_role WHERE userId = #{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.wx.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;

    @Select("SELECT * FROM role")
    public List<Role> findAll() throws Exception;

    @Insert("INSERT INTO role (id ,roleName, roleDesc) VALUES (#{id},#{roleName},#{roleDesc})")
    public void save(Role role) throws Exception;

    @Select("SELECT * FROM role WHERE id = #{id}")
    @Results({
            @Result(id = true,property = "id" , column = "id"),
            @Result(property = "roleName" , column = "roleName"),
            @Result(property = "roleDesc" , column = "roleDesc"),
            @Result(property = "permissions" , column = "id", javaType = java.util.List.class, many = @Many(select = "com.wx.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public Role findById(String id)throws Exception;

    @Select("SELECT * FROM permission WHERE id NOT IN ( \n" +
            " SELECT permissionId FROM role_permission WHERE roleId = #{id})")
    public List<Permission> findRoleByIdAndAllPermission(String id) throws Exception;


    @Insert("INSERT INTO role_permission (permissionId, roleId) VALUES (#{permissionId}, #{roleId})")
    public void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId) throws Exception;

    /**
     * 根据roleId查询中间表
     * @param roleId
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM role_permission WHERE roleId = #{roleId}")
    public List<Role> findRolePermissionByRoleId(String roleId) throws Exception;

    /**
     * 根据RoleId删除Role表中的数据
     * @param roleId
     * @throws Exception
     */
    @Delete("DELETE FROM role WHERE id = #{roleId}")
    public void deleteRoleByRoleId(String roleId) throws Exception;

    /**
     * 根据roleId删除Role_Permission表中的中间数据
     * @throws Exception
     */
    @Delete("DELETE FROM role_permission WHERE roleId = #{roleId}")
    public void deleteRolePermissionByRoleId(String roleId) throws Exception;

    @Update("UPDATE role SET roleName = #{roleName} , roleDesc = #{roleDesc} WHERE id = #{id}")
    public void edit(Role role) throws Exception;

    //根据角色名模糊查询
    @Select("SELECT * FROM role WHERE roleName LIKE '%${title}%'")
    public List<Role> likeAll(@Param("title") String title) throws Exception;

    //根据roleId和PermissionName模糊查询Permission
    @Select("SELECT * FROM permission WHERE id NOT IN ( SELECT permissionId FROM role_permission WHERE roleId = #{roleId}) AND permissionName LIKE '%${title}%'")
    public List<Permission> likePermissionByRoleIdAndPermissionName(@Param("roleId")String roleId, @Param("title")String title) throws Exception;

    //根据角色名查询角色
    @Select("SELECT * FROM role WHERE roleName=#{roleName}")
    public Role findRoleByRoleName(@RequestParam("roleName")String roleName) throws Exception;
}
