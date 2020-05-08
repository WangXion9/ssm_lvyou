package com.wx.dao;

import com.wx.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ISysLogDao {

    @Insert("INSERT INTO syslog (id, visitTime, username, ip, url, executionTime, method) " +
            " VALUES (#{id},#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void save(SysLog sysLog) throws Exception;

    @Select("SELECT * FROM syslog ORDER BY visitTime DESC")
    public List<SysLog> findAll() throws Exception;

    //根据访问用户名模糊查询
    @Select("SELECT * FROM syslog WHERE username LIKE '%${title}%'")
    public List<SysLog> likeAll(@Param("title") String title) throws Exception;
}
