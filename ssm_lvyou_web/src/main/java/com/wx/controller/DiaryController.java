package com.wx.controller;

import com.github.pagehelper.PageInfo;
import com.wx.domain.Diary;
import com.wx.domain.Member;
import com.wx.domain.Product;
import com.wx.service.IDiaryService;
import com.wx.service.IMemberService;
import com.wx.service.IProductService;
import com.wx.utils.MyStringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/diary")
@RolesAllowed({"ADMIN","DIARY","TEST"})
public class DiaryController {
    @Autowired
    private IDiaryService diaryService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IMemberService memberService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1")Integer page,
                                @RequestParam(name = "size", required = true, defaultValue = "4")Integer size,
                                @RequestParam(name = "title", required = true, defaultValue = "")String title
    )throws Exception{
        title = MyStringUtils.create2UTF8(title);
        ModelAndView mv = new ModelAndView();
        List<Diary> diaryList = diaryService.findAll(page, size, title);
        PageInfo pageInfo = new PageInfo(diaryList);
        if (!"".equals(title)){
            mv.addObject("title",title);
        }
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("diary-list");
        return mv;
    }

    @RequestMapping("/addBeforeDiary.do")
    public ModelAndView addBeforeDiary() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.findAllByStatusOne();
        List<Member> memberList = memberService.findAll();
        mv.addObject("productList",productList);
        mv.addObject("memberList",memberList);
        mv.setViewName("diary-add");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Diary diary) throws Exception{
        diaryService.save(diary);
        return "redirect:findAll.do";
    }

    @RequestMapping("/editBeforeDiary.do")
    public ModelAndView editBeforeDiary(@RequestParam(name = "id", required = true)String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Diary diary = diaryService.findByDiaryId(id);
        List<Product> productList = productService.findAllByStatusOne();
        List<Member> memberList = memberService.findAll();
        mv.addObject("productList",productList);
        mv.addObject("memberList",memberList);
        mv.addObject("diary",diary);
        mv.setViewName("diary-edit");
        return mv;
    }

    @RequestMapping("/editByDiaryId.do")
    public String editByDiaryId(Diary diary) throws Exception{
        diaryService.editByDiaryId(diary);
        return "redirect:findAll.do";
    }

    @RequestMapping("/showDiaryById.do")
    public ModelAndView showDiaryById(@RequestParam(name = "id", required = true)String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Diary diary = diaryService.findByDiaryId(id);
        mv.addObject("diary",diary);
        mv.setViewName("diary-show");
        return mv;
    }

    @RequestMapping("/editDiaryAddLike.do")
    public @ResponseBody String editDiaryAddLike(@RequestParam(name = "id", required = true)String id) throws Exception{
        String likeNum = diaryService.editDiaryAddLike(id);
        return likeNum;
    }

    @RequestMapping("/editDiarySubLike.do")
    public @ResponseBody String editDiarySubLike(@RequestParam(name = "id", required = true)String id) throws Exception{
        String likeNum = diaryService.editDiarySubLike(id);
        return likeNum;
    }

    @RequestMapping("/editDiaryAddCollect.do")
    public @ResponseBody String editDiaryAddCollect(@RequestParam(name = "id", required = true)String id) throws Exception{
        String countNum = diaryService.editDiaryAddCollect(id);
        return countNum;
    }

    @RequestMapping("/editDiarySubCollect.do")
    public @ResponseBody String editDiarySubCollect(@RequestParam(name = "id", required = true)String id) throws Exception{
        String countNum = diaryService.editDiarySubCollect(id);
        return countNum;
    }

    @RequestMapping("/editDiaryShowOneByIds.do")
    public String editDiaryShowOneByIds(@RequestParam(name = "ids", required = true)String[] ids) throws Exception{
        diaryService.editDiaryShowOneByIds(ids);
        return "redirect:findAll.do";
    }

    @RequestMapping("/editDiaryShowZeroByIds.do")
    public String editDiaryShowZeroByIds(@RequestParam(name = "ids", required = true)String[] ids) throws Exception{
        diaryService.editDiaryShowZeroByIds(ids);
        return "redirect:findAll.do";
    }

    @RequestMapping("/delDiaryByIds.do")
    public String delDiaryByIds(@RequestParam(name = "ids", required = true)String[] ids) throws Exception{
        diaryService.delDiaryByIds(ids);
        return "redirect:findAll.do";
    }

    @RequestMapping("/getDiaryByStatusZero.do")
    public @ResponseBody PageInfo getDiaryByStatusZero() throws Exception{
        List<Diary> diaryList = diaryService.getDiaryByStatusZero();
        PageInfo pageInfo = new PageInfo(diaryList);
        return pageInfo;
    }

    @RequestMapping("/findDiaryByProductId.do")
    public ModelAndView findDiaryByProductId(@RequestParam(name = "id", required = true)String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Diary> diaryList = diaryService.findDiaryByProductId(id);
        Product product = productService.findById(id);
        mv.addObject("product", product);
        mv.addObject("diaryList", diaryList);
        mv.setViewName("product-diary-show");
        return mv;
    }

    @RequestMapping("/findDiaryByDiaryTitle.do")
    @ResponseBody
    public boolean findDiaryByDiaryTitle(@RequestParam(name = "name", required = true) String username,
                                         @RequestParam(name = "id", required = true, defaultValue = "")String id) throws Exception{
        username = MyStringUtils.create2UTF8(username);
        Diary diary = diaryService.findDiaryByDiaryTitle(username);
        if (diary == null){
            return true;
        }else {
            if (diary.getId().equals(id)){
                return true;
            }
            //如果传进来的姓名和查询到的姓名一样
            if (diary.getTitle().toUpperCase().equals(username.toUpperCase())){
                return false;
            }
            return false;
        }

    }


}
