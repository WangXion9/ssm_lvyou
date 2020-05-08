package com.wx.controller;

import com.github.pagehelper.PageInfo;
import com.wx.domain.Member;
import com.wx.domain.Traveller;
import com.wx.service.IMemberService;
import com.wx.utils.MyStringUtils;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/member")
@RolesAllowed({"ADMIN","MEMBER","TEST"})
public class MemberController {

    @Autowired
    private IMemberService memberService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1")Integer page,
                                @RequestParam(name = "size", required = true, defaultValue = "4")Integer size,
                                @RequestParam(name = "title", required = true, defaultValue = "")String title) throws Exception{
        title = MyStringUtils.create2UTF8(title);
        ModelAndView mv = new ModelAndView();
        List<Member> memberList = memberService.findAll(page, size, title);
        //将数据封装到pageInfo对象中
        PageInfo pageInfo = new PageInfo(memberList);
        //传回title数据
        if (!"".equals(title)){
            mv.addObject("title",title);
        }
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("member-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Member member) throws Exception{
        String uri = request.getRequestURI();
        System.out.println(uri);
        memberService.save(member);
        return "redirect:findAll.do";
    }

    @RequestMapping("/editMemberStatusByIds.do")
    public String editMemberStatusByIds(@RequestParam(name = "ids", required = true)String[] ids) throws Exception{
        memberService.editMemberStatusByIds(ids);
        return "redirect:findAll.do";
    }

    @RequestMapping("/deleteByMemberIds.do")
    public String deleteByMemberIds(@RequestParam(name = "ids", required = true)String[] ids) throws Exception{
        memberService.deleteByMemberIds(ids);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true)String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Member member = memberService.findById(id);
        mv.addObject("member",member);
        mv.setViewName("member-show");
        return mv;
    }

    @RequestMapping("/editBeforeById.do")
    public ModelAndView editBeforeById(@RequestParam(name = "id", required = true)String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Member member = memberService.findById(id);
        mv.addObject("member",member);
        mv.setViewName("member-edit");
        return mv;
    }

    @RequestMapping("/edit.do")
    public String edit(Member member) throws Exception{
        memberService.edit(member);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findTravellerByOne.do")
    public ModelAndView findTravellerByOne(@RequestParam(name = "id", required = true)String id,
                                           @RequestParam(name = "page", required = true, defaultValue = "1")Integer page,
                                           @RequestParam(name = "size", required = true, defaultValue = "5")Integer size,
                                           @RequestParam(name = "title", required = true, defaultValue = "")String title) throws Exception {
        title = MyStringUtils.create2UTF8(title);
        ModelAndView mv = new ModelAndView();
        List<Traveller> travellerList = memberService.findTravellerByOne(page, size, title);
        Member member = memberService.findById(id);
        PageInfo pageInfo = new PageInfo(travellerList);
        if (!"".equals(title)){
            mv.addObject("title",title);
        }
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("member",member);
        mv.setViewName("member-traveller-list");
        return mv;
    }

    @RequestMapping("/editTravellerMemberId.do")
    public String editTravellerMemberId(@RequestParam(name = "memberId", required = true)String memberId,
                                        @RequestParam(name = "ids", required = true)String[] ids) throws Exception{
        memberService.editTravellerMemberId(memberId, ids);
        return "redirect:findAll.do";
    }

    /**
     * 首页查找今日新增会员的集合
     * @return
     * @throws Exception
     */
    @RequestMapping("/findMemberByNew.do")
    public ModelAndView findMemberByNew() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Member> memberList = memberService.findMemberByNew();
        mv.addObject("memberList", memberList);
        mv.setViewName("member-newadd");
        return mv;
    }

    @RequestMapping("/findMemberByMemberName.do")
    public @ResponseBody boolean findMemberByMemberName(@RequestParam(name = "name", required = true) String name,
                                                        @RequestParam(name = "id", required = true, defaultValue = "")String id) throws Exception{
        name = MyStringUtils.create2UTF8(name);
        Member member = memberService.findMemberByMemberName(name);
        if (member == null){
            return true;
        }else {
            if (member.getId().equals(id)){
                return true;
            }
            //如果传进来的姓名和查询到的姓名一样
            if (member.getName().toUpperCase().equals(name.toUpperCase())){
                return false;
            }
            return false;
        }
    }
}
