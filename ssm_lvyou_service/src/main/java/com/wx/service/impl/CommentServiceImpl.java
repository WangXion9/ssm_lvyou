package com.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.wx.dao.ICommentDao;
import com.wx.dao.IDiaryDao;
import com.wx.domain.Comment;
import com.wx.domain.Diary;
import com.wx.service.ICommentService;
import com.wx.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private ICommentDao commentDao;

    @Autowired
    private IDiaryDao diaryDao;

    @Override
    public List<Comment> findAll(Integer page, Integer size, String title) throws Exception {
        if ("".equals(title)){
            PageHelper.startPage(page, size);
            return commentDao.findAll();
        }else {
            PageHelper.startPage(page, size);
            return commentDao.likeAllByWrite(title);
        }
    }

    @Override
    public List<Diary> findDiaryByShow() throws Exception {
        return diaryDao.findDiaryByShow();
    }

    @Override
    public void saveComment(Comment comment) throws Exception {
        comment.setId(UuidUtils.createUuid());
        comment.setCreateTime(new Date());
        commentDao.save(comment);
    }

    /**
     * 根据ids删除评论
     * @param ids
     * @throws Exception
     */
    @Override
    public void dileteByIds(String[] ids) throws Exception {
        if (ids == null || ids.length == 0){
            return;
        }
        for (String id:ids
             ) {
            commentDao.deleteById(id);
        }
    }

    @Override
    public Comment findById(String id) throws Exception {
        return commentDao.findByCommentId(id);
    }

    @Override
    public void editComment(Comment comment) throws Exception {
        commentDao.editCommentById(comment);
    }

    @Override
    public void openShowByIds(String[] ids) throws Exception {
        if (ids == null || ids.length == 0)return;
        for (String id :ids
                ) {
            commentDao.openShowById(id);
        }
    }

    @Override
    public void shutShowByIds(String[] ids) throws Exception {
        if (ids == null || ids.length == 0)return;
        for (String id :ids
        ) {
            commentDao.shutShowById(id);
        }
    }

    @Override
    public List<Comment> findCommentByDiaryId(String id, Integer page, Integer size, String title) throws Exception {
        if ("".equals(title)){
            PageHelper.startPage(page, size);
            return commentDao.findCommentByDiaryId(id);
        }else {
            PageHelper.startPage(page, size);
            return commentDao.likeCommentByDiaryId(id, title);
        }
    }
}
