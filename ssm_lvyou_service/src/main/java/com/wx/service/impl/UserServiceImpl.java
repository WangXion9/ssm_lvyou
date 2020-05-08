package com.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.wx.dao.IUserDao;
import com.wx.domain.Role;
import com.wx.domain.UserInfo;
import com.wx.service.IUserService;
import com.wx.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    //根据姓名查询用户
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        User user = null;
        try {
            userInfo = userDao.findByUserName(userName);
            user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),true,true,true,userInfo.getStatus() == 1 ? true : false,getAuthority(userInfo.getRoles()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    //返回list集合，装的是权限
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        ArrayList <SimpleGrantedAuthority> list = new ArrayList<>();
        if (roles == null || roles.size() == 0){
            return list;
        }
        for (Role role: roles) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.getRoleName());
            list.add(simpleGrantedAuthority);
        }
        return list;
    }

    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    public List<UserInfo> findAll() throws Exception{
        return userDao.findAll();
    }

    @Override
    public List<UserInfo> findAll(Integer page, Integer size, String title) throws Exception {
        if ("".equals(title)){
            PageHelper.startPage(page,size);
            return userDao.findAll();
        }else {
            PageHelper.startPage(page,size);
            return userDao.likeAll(title);
        }

    }

    /**
     * 添加用户
     * @param userInfo
     * @throws Exception
     */
    public void save(UserInfo userInfo) throws Exception{
        userInfo.setId(UuidUtils.createUuid());
        userDao.save(userInfo);
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     * @throws Exception
     */
    public UserInfo findById(String id) throws Exception{
        return userDao.findById(id);
    }

    /**
     * 根据userId查询可以添加的角色
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> findUserByIdAndAllRole(String id, Integer page, Integer size, String title) throws Exception {
        if ("".equals(title)){
            PageHelper.startPage(page,size);
            return userDao.findUserByIdAndAllRole(id);
        }else {
            PageHelper.startPage(page,size);
            return userDao.likeRoleByUserIdAndRoleName(id, title);
        }

    }

    /**
     * 根据角色ids给用户usereId添加关系
     * @param ids
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public void addRoleToUser(String userId, String[] ids) throws Exception {
        //对userId 和 ids 进行是否为空判断
        if (userId == "" || userId == null){
            if (ids == null || ids.length == 0){
                return;
            }
        }
        for (String roleId : ids) {
            userDao.addRoleToUser(userId, roleId);
        }
    }

    @Override
    public void edit(UserInfo userInfo) throws Exception {
        userDao.edit(userInfo);
    }

    @Override
    public UserInfo findByUserName(String username) throws Exception {
        return userDao.findUserByUserName(username);
    }

    @Override
    public void editByUsername(UserInfo user) throws Exception {
        userDao.editByUsername(user);
    }

    /**
     * 根据ids修改用户的状态为1
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public void editUserStatusByIds(String[] ids) throws Exception {
        if (ids == null || ids.length == 0){
            return;
        }
        for (String id:ids
             ) {
            userDao.editUserStatusByIds(id);
        }
    }

    @Override
    public void editOutTimeByName(String name, LocalDateTime time) throws Exception {
        userDao.editOutTimeByName( name, time);
    }
}
