package com.wx.controller;

import com.github.pagehelper.PageInfo;
import com.wx.domain.Comment;
import com.wx.domain.Diary;
import com.wx.service.ICommentService;
import com.wx.service.IDiaryService;
import com.wx.utils.MyStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/comment")
@RolesAllowed({"ADMIN","COMMENT","TEST"})
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IDiaryService diaryService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1")Integer page,
                                @RequestParam(name = "size", required = true, defaultValue = "4")Integer size,
                                @RequestParam(name = "title", required = true, defaultValue = "")String title) throws Exception{
        title = MyStringUtils.create2UTF8(title);
        ModelAndView mv = new ModelAndView();
        List<Comment> commentList = commentService.findAll(page, size, title);
        PageInfo pageInfo = new PageInfo(commentList);
        if (!"".equals(title)){
            mv.addObject("title", title);
        }
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("comment-list");
        return mv;
    }

    @RequestMapping("/addComment.do")
    public ModelAndView addComment() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Diary> diaryList = commentService.findDiaryByShow();
        mv.addObject("diaryList",diaryList);
        mv.setViewName("comment-add");
        return mv;
    }

    @RequestMapping("/saveComment.do")
    public String saveComment(Comment comment) throws Exception{
        commentService.saveComment(comment);
        return "redirect:findAll.do";
    }

    @RequestMapping("/dileteByIds.do")
    public String dileteByIds(@RequestParam(name = "ids", required = true)String[] ids) throws Exception{
        commentService.dileteByIds(ids);
        return "redirect:findAll.do";
    }

    @RequestMapping("/editBeformById.do")
    public ModelAndView editBeformById(@RequestParam(name = "id", required = true)String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Comment comment = commentService.findById(id);
        List<Diary> diaryList = commentService.findDiaryByShow();
        mv.addObject("diaryList",diaryList);
        mv.addObject("comment",comment);
        mv.setViewName("comment-edit");
        return mv;
    }

    @RequestMapping("/editComment.do")
    public String editComment(Comment comment) throws Exception{
        commentService.editComment(comment);
        return "redirect:findAll.do";
    }

    @RequestMapping("/openShowByIds.do")
    public String openShowByIds(@RequestParam(name = "ids", required = true)String[] ids) throws Exception{
        commentService.openShowByIds(ids);
        return "redirect:findAll.do";
    }

    @RequestMapping("/shutShowByIds.do")
    public String shutShowByIds(@RequestParam(name = "ids", required = true)String[] ids) throws Exception{
        commentService.shutShowByIds(ids);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findCommentByDiaryId.do")
    public ModelAndView findCommentByDiaryId(@RequestParam(name = "id", required = true)String id,
                                             @RequestParam(name = "page", required = true, defaultValue = "1")Integer page,
                                             @RequestParam(name = "size", required = true, defaultValue = "5")Integer size,
                                             @RequestParam(name = "title", required = true, defaultValue = "")String title) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Comment> commentList = commentService.findCommentByDiaryId(id, page, size, title);
        Diary diary = diaryService.findByDiaryId(id);
        PageInfo pageInfo = new PageInfo(commentList);
        if (!"".equals(title)){
            mv.addObject("title",title);
        }
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("diary",diary);
        mv.setViewName("diary-comment-list");
        return mv;
    }
}
