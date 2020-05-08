package com.wx.service;

import com.wx.domain.Diary;

import java.util.List;

public interface IDiaryService {
    List<Diary> findAll(Integer page, Integer size, String title) throws Exception;

    public Diary findByDiaryId(String id) throws Exception;

    public void save(Diary diary) throws Exception;

    public void editByDiaryId(Diary diary) throws Exception;

    public String editDiaryAddLike(String id) throws Exception;

    public String editDiarySubLike(String id) throws Exception;

    public String editDiaryAddCollect(String id) throws Exception;

    public String editDiarySubCollect(String id) throws Exception;

    public void editDiaryShowOneByIds(String[] ids) throws Exception;

    public void editDiaryShowZeroByIds(String[] ids) throws Exception;

    public void delDiaryByIds(String[] ids) throws Exception;

    public List<Diary> getDiaryByStatusZero() throws Exception;

    public List<Diary> findDiaryByProductId(String id) throws Exception;

    public Diary findDiaryByDiaryTitle(String title) throws Exception;
}
