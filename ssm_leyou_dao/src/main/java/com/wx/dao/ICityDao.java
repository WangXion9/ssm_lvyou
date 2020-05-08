package com.wx.dao;

import com.wx.domain.City;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ICityDao {

    @Select("SELECT * FROM city WHERE id=#{id}")
    public City findById(String id) throws Exception;

    @Select("SELECT * FROM city")
    public List<City> findAll() throws Exception;
}
