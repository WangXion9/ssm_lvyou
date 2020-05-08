package com.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.wx.dao.ITravellerDao;
import com.wx.domain.Traveller;
import com.wx.service.ITravellerService;
import com.wx.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TravellerServiceImpl implements ITravellerService {

    @Autowired
    private ITravellerDao travellerDao;

    @Override
    public List<Traveller> findAll(Integer page, Integer size, String title) throws Exception {
        if ("".equals(title)){
            PageHelper.startPage(page, size);
            return travellerDao.findAll();
        }else {
            PageHelper.startPage(page, size);
            return travellerDao.likeAllByName(title);
        }
    }

    @Override
    public void save(Traveller traveller) throws Exception {
        traveller.setId(UuidUtils.createUuid());
        travellerDao.save(traveller);
    }

    @Override
    public Traveller findById(String id) throws Exception {
        return travellerDao.findById(id);
    }

    @Override
    public void edit(Traveller traveller) throws Exception {
        travellerDao.updateByTravellerId(traveller);
    }

    @Override
    public void deleteByOrdersIds(String[] ids) throws Exception {
        if(ids == null || ids.length == 0 ){
            return;
        }
        for (String id:ids
             ) {
            travellerDao.deleteById(id);
        }
    }

    @Override
    public Traveller findTravellerByTravellerName(String name) throws Exception {
        return travellerDao.findTravellerByTravellerName(name);
    }
}
