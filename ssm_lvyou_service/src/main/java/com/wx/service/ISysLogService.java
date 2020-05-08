package com.wx.service;

import com.wx.domain.SysLog;

import java.util.List;

public interface ISysLogService {

    public void save(SysLog sysLog) throws Exception;

    public List<SysLog> findAll(Integer page, Integer size, String title) throws Exception;
}
