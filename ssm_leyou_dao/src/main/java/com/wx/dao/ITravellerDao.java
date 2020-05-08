package com.wx.dao;

import com.wx.domain.Traveller;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ITravellerDao {

    @Select("SELECT * FROM traveller WHERE id IN (SELECT travellerId FROM order_traveller WHERE orderId = #{ordersId})")
    public List<Traveller> findByOrdersId(String ordersId) throws Exception;

    @Insert("INSERT INTO traveller(id, name, sex, phoneNum, credentialsType, credentialsNum, travellerType) " +
            " VALUES (#{id}, #{name}, #{sex}, #{phoneNum}, #{credentialsType}, #{credentialsNum}, #{travellerType})")
    public void save(Traveller traveller) throws Exception;

    @Delete("DELETE FROM traveller WHERE id = #{id}")
    public void deleteById(String id) throws Exception;

    @Select("SELECT * FROM traveller")
    public List<Traveller> findAll() throws Exception;

    @Select("SELECT * FROM traveller WHERE name LIKE '%${title}%'")
    public List<Traveller> likeAllByName(@Param("title")String title) throws Exception;

    //根据游客id查询游客信息
    @Select("SELECT * FROM traveller WHERE id=#{id}")
    public Traveller findById(String id) throws Exception;

    //根据游客id修改游客全部信息
    @Update("UPDATE traveller SET name=#{name}, sex=#{sex}, phoneNum=#{phoneNum}, " +
            " credentialsType=#{credentialsType}, credentialsNum=#{credentialsNum}, travellerType=#{travellerType} WHERE id=#{id}")
    public void updateByTravellerId(Traveller traveller) throws Exception;

    //根据会员id查询游客
    @Select("SELECT * FROM traveller WHERE memberId = #{memberId}")
    public List<Traveller> findByMemberId(@Param("memberId") String memberId) throws Exception;

    //修改游客memberId属性
    @Update("UPDATE traveller SET memberId=#{memberId} WHERE id=#{id}")
    public void editTravellerMemberId(@Param("id") String id, @Param("memberId") String memberId) throws Exception;

    //根据memberId删除所有游客
    @Delete("DELETE FROM traveller WHERE memberId=#{memberId}")
    public void deleteByMemberId(@Param("memberId")String memberId) throws Exception;

    //保存游客
    @Insert("INSERT INTO traveller(id, name, sex, phoneNum, credentialsType, credentialsNum, travellerType, memberId) " +
            " VALUES (#{id}, #{name}, #{sex}, #{phoneNum}, #{credentialsType}, #{credentialsNum}, #{travellerType}, #{memberId})")
    public void saveAll(Traveller traveller) throws Exception;

    //根据姓名查询游客
    @Select("SELECT * FROM traveller WHERE name=#{name}")
    public Traveller findTravellerByTravellerName(@Param("name")String name) throws Exception;
}
