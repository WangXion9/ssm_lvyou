package com.wx.service;

import com.wx.domain.Traveller;

import java.util.List;

public interface ITravellerService {

    public List<Traveller> findAll(Integer page, Integer size, String title) throws Exception;

    public void save(Traveller traveller) throws Exception;

    public Traveller findById(String id) throws Exception;

    public void edit(Traveller traveller) throws Exception;

    public void deleteByOrdersIds(String[] ids) throws Exception;

    public Traveller findTravellerByTravellerName(String name) throws Exception;
}
