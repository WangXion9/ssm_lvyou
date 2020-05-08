package com.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.wx.dao.IMemberDao;
import com.wx.dao.ITravellerDao;
import com.wx.domain.Member;
import com.wx.domain.Traveller;
import com.wx.service.IMemberService;
import com.wx.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements IMemberService {

    @Autowired
    private IMemberDao memberDao;

    @Autowired
    private ITravellerDao travellerDao;

    @Override
    public List<Member> findAll(Integer page, Integer size, String title) throws Exception {
        if ("".equals(title)){
            PageHelper.startPage(page, size);
            return memberDao.findAll();
        }else {
            PageHelper.startPage(page, size);
            return memberDao.likeAllByName(title);
        }
    }

    @Override
    public void save(Member member) throws Exception {
        member.setId(UuidUtils.createUuid());
        //设置会员创建时间
        member.setCreateTime(new Date());
        memberDao.save(member);
    }

    @Override
    public void editMemberStatusByIds(String[] ids) throws Exception {
        if (ids == null || ids.length == 0){
            return;
        }
        for (String id:ids
             ) {
//            memberDao.editMemberStatusById(id);
        }
    }

    @Override
    public void deleteByMemberIds(String[] ids) throws Exception {
        if (ids == null || ids.length == 0){
            return;
        }
        for (String id:ids
             ) {
            memberDao.deleteByMemberId(id);
        }
    }

    @Override
    public Member findById(String id) throws Exception {
        return memberDao.findById(id);
    }

    @Override
    public void edit(Member member) throws Exception {
        String memberId = member.getId();
        if (memberId == null || "".equals(memberId)){
            return;
        }
        if (member.getTravellers() == null || member.getTravellers().size() == 0){
            memberDao.updateById(member);
            return;
        }
        //删除该会员下的所有游客
        travellerDao.deleteByMemberId(memberId);

        //重新插入游客信息
        for (Traveller traveller:member.getTravellers()
             ) {
            if ("".equals(traveller.getName()) || "".equals(traveller.getPhoneNum())){
                continue;
            }
            traveller.setId(UuidUtils.createUuid());
            traveller.setMemberId(memberId);
            travellerDao.saveAll(traveller);
        }


        memberDao.updateById(member);
    }

    @Override
    public List<Traveller> findTravellerByOne(Integer page, Integer size, String title) throws Exception {
        if ("".equals(title)){
            PageHelper.startPage(page, size);
            return memberDao.findTravellerByOne();
        }else {
            PageHelper.startPage(page, size);
            return memberDao.LikeTravellerByOne(title);
        }

    }

    @Override
    public void editTravellerMemberId(String memberId, String[] ids) throws Exception {
        if (ids == null || ids.length == 0 ){
            return;
        }
        for (String id:ids
             ) {
            travellerDao.editTravellerMemberId(id, memberId);
        }
    }

    @Override
    public List<Member> findAll() throws Exception {
        return memberDao.findAll();
    }

    @Override
    public Integer findMemeberAddByNew() throws Exception {
        return memberDao.findMemeberAddByNew();
    }

    @Override
    public List<Member> findMemberByNew() throws Exception {
        return memberDao.findMemberByNew();
    }

    @Override
    public Member findMemberByMemberName(String name) throws Exception {
        return memberDao.findMemberByMemberName(name);
    }
}
