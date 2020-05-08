package com.wx.dao;

import com.wx.domain.Comment;
import com.wx.domain.Diary;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ICommentDao {

    //查询所有
    @Select("SELECT * FROM comment ORDER BY createTime DESC")
    @Results(id = "commentAll", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "writeName", column = "writeName"),
            @Result(property = "commentDesc", column = "commentDesc"),
            @Result(property = "updateTime", column = "updateTime"),
            @Result(property = "createTime", column = "createTime"),
            @Result(property = "commentStatus", column = "commentStatus"),
            @Result(property = "showStatus", column = "showStatus"),
            @Result(property = "diary", column = "diaryId", javaType = Diary.class, one = @One(select = "com.wx.dao.IDiaryDao.findById"))
    })
    public List<Comment> findAll() throws Exception;

    //模糊查询，按作者模糊查询
    @Select("SELECT * FROM comment WHERE writeName LIKE '%${title}%' ORDER BY createTime DESC")
    @ResultMap("commentAll")
    public List<Comment> likeAllByWrite(@Param("title") String title) throws Exception;

    //保存评论
    @Insert("INSERT INTO comment(id, writeName, commentDesc, commentStatus, diaryId, createTime, showStatus) " +
            " VALUES (#{id},#{writeName},#{commentDesc},#{commentStatus},#{diary.id},#{createTime},#{showStatus})")
    public void save(Comment comment) throws Exception;

    //根据id删除评论信息
    @Delete("DELETE FROM comment WHERE id=#{id}")
    public void deleteById(String id) throws Exception;

    //根据id查询
    @Select("SELECT * FROM comment WHERE id=#{id}")
    @ResultMap("commentAll")
    public Comment findByCommentId(String id) throws Exception;

    //根据id修改评论信息
    @Update("UPDATE comment SET writeName=#{writeName}, commentDesc=#{commentDesc}, " +
            " diaryId=#{diary.id}, commentStatus=#{commentStatus}, showStatus=#{showStatus} " +
            " WHERE id=#{id}")
    public void editCommentById(Comment comment) throws Exception;

    //根据id开启显示状态为1
    @Update("UPDATE comment SET showStatus = 1 WHERE id = #{id}")
    public void openShowById(String id) throws Exception;

    //根据id设置开启状态为0
    @Update("UPDATE comment SET showStatus = 0 WHERE id = #{id}")
    public void shutShowById(String id) throws Exception;

    //根据游记id查询评论，只查询显示显示的
    @Select("SELECT * FROM comment WHERE diaryId=#{diaryId} AND showStatus=1")
    @ResultMap("commentAll")
    public List<Comment> findCommentByDiaryId(String diaryId) throws Exception;

    //根据游记id模糊查询评论，只查询显示显示的
    @Select("SELECT * FROM comment WHERE diaryId=#{diaryId} AND showStatus=1 AND writeName LIKE '%${title}%'")
    @ResultMap("commentAll")
    public List<Comment> likeCommentByDiaryId(@Param("diaryId") String diaryId, @Param("title") String title) throws Exception;

}
