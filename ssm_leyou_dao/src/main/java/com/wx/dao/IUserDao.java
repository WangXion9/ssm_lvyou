package com.wx.dao;

import com.wx.domain.Role;
import com.wx.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


public interface IUserDao {
    @Select("select * from users where username = #{userName}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "email", column = "email"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "com.wx.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findByUserName(String userName) throws Exception;

    @Select("select * from users")
    public List<UserInfo> findAll()throws Exception;

    @Insert("insert into users(id,email,username,password,phoneNum,status) values(#{id},#{email},#{username},#{password},#{phoneNum},#{status})")
    public void save(UserInfo userInfo) throws Exception;

    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "email", column = "email"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "com.wx.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findById(String id) throws Exception;

    @Select("SELECT * FROM users WHERE id IN (\n" +
            "SELECT userId FROM users_role WHERE roleId = #{id})")
    public List<UserInfo> findByRoleId(String id) throws Exception;

    /**
     * 根据userId查询可以添加的角色
     * @param id
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM role WHERE id NOT IN( \n" +
            " SELECT roleId FROM users_role WHERE userId = #{id})")
    public List<Role> findUserByIdAndAllRole(String id) throws Exception;


    /**
     * 根据角色roleId给用户usereId添加关系
     * @param userId
     * @param roleId
     * @throws Exception
     */
    @Insert("INSERT INTO users_role (userId, roleId) VALUES (#{userId}, #{roleId})")
    public void addRoleToUser(@Param("userId") String userId , @Param("roleId")String roleId) throws Exception;

    @Update("UPDATE users SET email = #{email}, username = #{username}, password = #{password}, phoneNum = #{phoneNum}, status = #{status} WHERE id = #{id}")
    public void edit(UserInfo userInfo) throws Exception;


    @Select("select * from users where username = #{userName}")
    public UserInfo findUserByUserName(String username) throws Exception;

    @Update("UPDATE users SET password = #{password} WHERE id = #{id}")
    public void editByUsername(UserInfo user) throws Exception;

    //模糊查询，用姓名模糊查询
    @Select("SELECT * FROM users WHERE username LIKE '%${title}%'")
    public List<UserInfo> likeAll(@Param("title") String title) throws Exception;

    //查询角色，根据用户id和角色姓名模糊查询
    @Select("SELECT * FROM role WHERE id NOT IN( SELECT roleId FROM users_role WHERE userId = #{userId}) AND roleName LIKE '%${title}%'")
    public List<Role> likeRoleByUserIdAndRoleName(@Param("userId")String userId, @Param("title")String title);


    //根据id修改用户的状态为1
    @Update("UPDATE users SET status = 1 WHERE id=#{id}")
    public void editUserStatusByIds(String id) throws Exception;

    //按照姓名修改最后登录时间
    @Update("UPDATE users SET outTime=#{outTime} WHERE username=#{name}")
    public void editOutTimeByName(@Param("name") String name, @Param("outTime") LocalDateTime outTime) throws Exception;

    //通过roleId查询user_role中间表
    @Select("SELECT * FROM users_role WHERE roleId=#{roleId}")
    public List<UserInfo> findUserRoleByRoleId(@Param("roleId") String roleId) throws Exception;

    //通过roleId删除user_role中间表
    @Delete("DELETE FROM users_role WHERE roleId=#{roleId}")
    public void deleteUserRoleByRoleId(@Param("roleId") String roleId) throws Exception;
}
