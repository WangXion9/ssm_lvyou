package com.wx.service;

import com.wx.domain.Role;
import com.wx.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


public interface IUserService extends UserDetailsService {

    public List<UserInfo> findAll() throws Exception;

    public List<UserInfo> findAll(Integer page, Integer size, String title) throws Exception;

    public void save(UserInfo userInfo)throws Exception;

    public UserInfo findById(String id) throws Exception;

    public List<Role> findUserByIdAndAllRole(String id, Integer page, Integer size, String title) throws Exception;

    public void addRoleToUser(String userId, String[] ids) throws Exception;

    public void edit(UserInfo userInfo) throws Exception;

    public UserInfo findByUserName(String username) throws Exception;

    public void editByUsername(UserInfo user) throws Exception;

    public void editUserStatusByIds(String[] ids) throws Exception;

    public void editOutTimeByName(String name, LocalDateTime time) throws Exception;
}
