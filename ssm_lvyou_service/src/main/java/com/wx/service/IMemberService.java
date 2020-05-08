package com.wx.service;

import com.wx.domain.Member;
import com.wx.domain.Traveller;

import java.util.List;

public interface IMemberService {

    public List<Member> findAll(Integer page, Integer size, String title) throws Exception;

    public void save(Member member) throws Exception;

    public void editMemberStatusByIds(String[] ids) throws Exception;

    public void deleteByMemberIds(String[] ids) throws Exception;

    public Member findById(String id) throws Exception;

    public void edit(Member member) throws Exception;

    public List<Traveller> findTravellerByOne(Integer page, Integer size, String title) throws Exception;

    public void editTravellerMemberId(String memberId, String[] ids) throws Exception;

    //查询所有的会员信息
    public List<Member> findAll() throws Exception;

    //今日注册会员人数查询
    public Integer findMemeberAddByNew() throws Exception;

    //查找今日注册的会员信息
    public List<Member> findMemberByNew() throws Exception;

    public Member findMemberByMemberName(String name) throws Exception;
}
