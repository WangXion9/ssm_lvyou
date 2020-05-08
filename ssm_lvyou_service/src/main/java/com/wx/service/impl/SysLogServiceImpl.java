package com.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.wx.dao.ISysLogDao;
import com.wx.domain.SysLog;
import com.wx.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll(Integer page, Integer size, String title) throws Exception {
        if ("".equals(title)){
            PageHelper.startPage(page,size);
            return sysLogDao.findAll();
        }else {
            PageHelper.startPage(page,size);
            return sysLogDao.likeAll(title);
        }

    }
}
