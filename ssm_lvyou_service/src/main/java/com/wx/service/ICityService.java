package com.wx.service;

import com.wx.domain.City;

import java.util.List;

public interface ICityService {

    public List<City> findAll() throws Exception;
}
