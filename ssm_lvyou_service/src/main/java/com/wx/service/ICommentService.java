package com.wx.service;

import com.wx.domain.Comment;
import com.wx.domain.Diary;

import java.util.List;

public interface ICommentService {
    public List<Comment> findAll(Integer page, Integer size, String title) throws Exception;

    public List<Diary> findDiaryByShow() throws Exception;

    public void saveComment(Comment comment) throws Exception;

    public void dileteByIds(String[] ids) throws Exception;

    public Comment findById(String id) throws Exception;

    public void editComment(Comment comment) throws Exception;

    public void openShowByIds(String[] ids) throws Exception;

    public void shutShowByIds(String[] ids) throws Exception;

    public List<Comment> findCommentByDiaryId(String id, Integer page, Integer size, String title) throws Exception;
}
