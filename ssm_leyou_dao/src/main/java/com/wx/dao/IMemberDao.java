package com.wx.dao;

import com.wx.domain.Member;
import com.wx.domain.Traveller;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface IMemberDao {

    //根据会员id查询会员信息
    @Select("select * from member where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "email", column = "email"),
            @Result(property = "createTime", column = "createTime"),
            @Result(property = "travellers", column = "id", javaType = java.util.List.class, many = @Many(select = "com.wx.dao.ITravellerDao.findByMemberId"))
    })
    public Member findById(String id) throws Exception;

    //保存会员
    @Insert("INSERT INTO member(id, name, nickname, phoneNum, email, createTime) VALUES (#{id}, #{name}, #{nickname}, #{phoneNum}, #{email}, #{createTime})")
    public void save(Member member) throws Exception;

    //根据会员id修改会员信息
    @Update("UPDATE member SET name=#{name}, nickname=#{nickname}, phoneNum=#{phoneNum}, email=#{email} WHERE id=#{id}")
    public void updateById(Member member) throws Exception;

    //查询所有会员，按创建日期降序排列
    @Select("SELECT * FROM member ORDER BY createTime DESC")
    public List<Member> findAll() throws Exception;

    //根据姓名模糊查询
    @Select("SELECT * FROM member WHERE name LIKE '%${title}%' ORDER BY createTime DESC")
    public List<Member> likeAllByName(@Param("title") String title) throws Exception;


    //根据会员id删除会员
    @Delete("DELETE FROM member WHERE id=#{id}")
    public void deleteByMemberId(String id) throws Exception;

    //根据游客中会员id为-1的(-1代表没有值)
    @Select("SELECT * FROM traveller WHERE memberId = '-1'")
    public List<Traveller> findTravellerByOne() throws Exception;

    //根据游客中会员id为-1的(-1代表没有值)模糊查询按姓名
    @Select("SELECT * FROM traveller WHERE memberId = '-1' AND name LIKE '%${title}%'")
    public List<Traveller> LikeTravellerByOne(@Param("title") String title) throws Exception;

    //查询今日会员增加数量
    @Select("SELECT COUNT(*) FROM member WHERE TO_DAYS(createTime) = TO_DAYS(NOW())")
    public Integer findMemeberAddByNew() throws Exception;

    //查找今日注册会员的集合
    @Select("SELECT * FROM member WHERE TO_DAYS(createTime) = TO_DAYS(NOW())")
    public List<Member> findMemberByNew() throws Exception;

    //按照姓名查找会员
    @Select("SELECT * FROM member WHERE name=#{name}")
    public Member findMemberByMemberName(@RequestParam("name") String name) throws Exception;
}
