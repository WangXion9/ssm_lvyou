package com.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.wx.dao.IDiaryDao;
import com.wx.domain.Diary;
import com.wx.service.IDiaryService;
import com.wx.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class DiaryServiceImpl implements IDiaryService {

    @Autowired
    private IDiaryDao diaryDao;

    @Override
    public List<Diary> findAll(Integer page, Integer size, String title
    ) throws Exception {
        if ("".equals(title)){
            PageHelper.startPage(page, size);
            return diaryDao.findAll();
        }else {
            PageHelper.startPage(page, size);
            return diaryDao.likeAllByTitle(title);
        }
    }

    @Override
    public Diary findByDiaryId(String id) throws Exception {
        return diaryDao.findById(id);
    }

    @Override
    public void save(Diary diary) throws Exception {
        diary.setId(UuidUtils.createUuid());
        diary.setCreateTime(new Date());
        if (diary.getCollect() == null || "".equals(diary.getCollect())){
            diary.setCollect(0);
        }
        if (diary.getLikeCount() == null || "".equals(diary.getLikeCount())){
            diary.setLikeCount(0);
        }
        diaryDao.save(diary);
    }

    @Override
    public void editByDiaryId(Diary diary) throws Exception {
        diaryDao.editByDiaryId(diary);
    }

    @Override
    public String editDiaryAddLike(String id) throws Exception {
        diaryDao.editDiaryAddLike(id);
        Diary diary = diaryDao.findById(id);
        return diary.getLikeCount().toString();
    }

    @Override
    public String editDiarySubLike(String id) throws Exception {
        diaryDao.editDiarySubLike(id);
        Diary diary = diaryDao.findById(id);
        return diary.getLikeCount().toString();
    }

    @Override
    public String editDiaryAddCollect(String id) throws Exception {
        diaryDao.editDiaryAddCollect(id);
        Diary diary = diaryDao.findById(id);
        return diary.getCollect().toString();
    }

    @Override
    public String editDiarySubCollect(String id) throws Exception {
        diaryDao.editDiarySubCollect(id);
        Diary diary = diaryDao.findById(id);
        return diary.getCollect().toString();
    }

    @Override
    public void editDiaryShowOneByIds(String[] ids) throws Exception {
        if (ids == null || ids.length == 0){
            return;
        }
        for (String id:ids
             ) {
            diaryDao.editDiaryShowOneById(id);
        }
    }

    @Override
    public void editDiaryShowZeroByIds(String[] ids) throws Exception {
        if (ids == null || ids.length == 0){
            return;
        }
        for (String id:ids
        ) {
            diaryDao.editDiaryShowZeroById(id);
        }
    }

    @Override
    public void delDiaryByIds(String[] ids) throws Exception {
        if (ids == null || ids.length == 0){
            return;
        }
        for (String id:ids
        ) {
            diaryDao.delDiaryById(id);
        }
    }

    @Override
    public List<Diary> getDiaryByStatusZero() throws Exception {
        return diaryDao.getDiaryByStatusZero();
    }

    @Override
    public List<Diary> findDiaryByProductId(String id) throws Exception {
        return diaryDao.findDiaryByProductId(id);
    }

    @Override
    public Diary findDiaryByDiaryTitle(String title) throws Exception {
        return diaryDao.findDiaryByDiaryTitle(title);
    }
}
