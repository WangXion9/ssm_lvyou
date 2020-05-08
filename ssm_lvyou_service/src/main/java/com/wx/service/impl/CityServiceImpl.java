package com.wx.service.impl;

import com.wx.dao.ICityDao;
import com.wx.domain.City;
import com.wx.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@Transactional
public class CityServiceImpl implements ICityService {

    @Autowired
    private ICityDao cityDao;
    @Override
    public List<City> findAll() throws Exception {
        return cityDao.findAll();
    }
}
