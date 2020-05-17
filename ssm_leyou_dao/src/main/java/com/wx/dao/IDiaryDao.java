package com.wx.dao;

import com.wx.domain.Comment;
import com.wx.domain.Diary;
import com.wx.domain.Member;
import com.wx.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IDiaryDao {

    //查询所有
    @Select("SELECT * FROM diary ORDER BY createTime DESC")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "product", column = "productId", javaType = Product.class,
                    one = @One(select = "com.wx.dao.IProductDao.findById")),
            @Result(property = "collect", column = "collect"),
            @Result(property = "likeCount", column = "likeCount"),
            @Result(property = "texts", column = "texts"),
            @Result(property = "member", column = "memberId", javaType = Member.class,
                    one = @One(select = "com.wx.dao.IMemberDao.findById")),
            @Result(property = "createTime", column = "createTime"),
            @Result(property = "updateTime", column = "updateTime"),
            @Result(property = "diaryStatus", column = "diaryStatus"),
            @Result(property = "showStatus", column = "showStatus")
    })
    public List<Diary> findAll() throws Exception;

    //模糊查询所有，按title来查
    @Select("SELECT * FROM diary WHERE title LIKE '%${title}%' ORDER BY createTime DESC")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "product", column = "productId", javaType = Product.class,
                    one = @One(select = "com.wx.dao.IProductDao.findById")),
            @Result(property = "collect", column = "collect"),
            @Result(property = "likeCount", column = "likeCount"),
            @Result(property = "texts", column = "texts"),
            @Result(property = "member", column = "memberId", javaType = Member.class,
                    one = @One(select = "com.wx.dao.IMemberDao.findById")),
            @Result(property = "createTime", column = "createTime"),
            @Result(property = "updateTime", column = "updateTime"),
            @Result(property = "diaryStatus", column = "diaryStatus"),
            @Result(property = "showStatus", column = "showStatus")
    })
    public List<Diary> likeAllByTitle(@Param("title") String title);


    //根据id查询游记
    @Select("SELECT * FROM diary WHERE id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.wx.dao.IProductDao.findById")),
            @Result(property = "collect", column = "collect"),
            @Result(property = "likeCount", column = "likeCount"),
            @Result(property = "texts", column = "texts"),
            @Result(property = "member", column = "memberId", javaType = Member.class, one = @One(select = "com.wx.dao.IMemberDao.findById")),
            @Result(property = "createTime", column = "createTime"),
            @Result(property = "updateTime", column = "updateTime"),
            @Result(property = "diaryStatus", column = "diaryStatus"),
            @Result(property = "showStatus", column = "showStatus"),
            @Result(property = "comments", column = "id", javaType = java.util.List.class, many = @Many(select = "com.wx.dao.ICommentDao.findCommentByDiaryId"))
    })
    public Diary findById(@Param("id")String id) throws Exception;

    //查询游记，显示为1的所有数据
    @Select("SELECT * FROM diary WHERE showStatus=1")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.wx.dao.IProductDao.findById")),
            @Result(property = "collect", column = "collect"),
            @Result(property = "likeCount", column = "likeCount"),
            @Result(property = "texts", column = "texts"),
            @Result(property = "createTime", column = "createTime"),
            @Result(property = "updateTime", column = "updateTime"),
            @Result(property = "diaryStatus", column = "diaryStatus"),
            @Result(property = "showStatus", column = "showStatus")
    })
    public List<Diary> findDiaryByShow() throws Exception;

    //保存游记
    @Insert("INSERT INTO diary (id, title, productId, collect, likeCount, texts, memberId, diaryStatus, createTime, showStatus) " +
            " VALUES (#{id},#{title},#{product.id},#{collect},#{likeCount},#{texts},#{member.id},#{diaryStatus},#{createTime},#{showStatus})")
    public void save(Diary diary) throws Exception;

    //根据id修改信息
    @Update("UPDATE diary SET title=#{title}, productId=#{product.id}, " +
            " collect=#{collect}, likeCount=#{likeCount}, texts=#{texts}, " +
            " memberId=#{member.id}, diaryStatus=#{diaryStatus}, createTime=#{createTime}, " +
            " showStatus=#{showStatus} WHERE id=#{id}")
    public void editByDiaryId(Diary diary) throws Exception;

    //根据id给喜欢字段+1
    @Update("UPDATE diary SET likeCount = likeCount+1 WHERE id=#{id}")
    public void editDiaryAddLike(String id) throws Exception;

    //根据id给喜欢字段-1
    @Update("UPDATE diary SET likeCount = likeCount-1 WHERE id=#{id}")
    public void editDiarySubLike(String id) throws Exception;

    //根据id给收藏字段+1
    @Update("UPDATE diary SET collect = collect+1 WHERE id=#{id}")
    public void editDiaryAddCollect(String id) throws Exception;

    //根据id给收藏字段-1
    @Update("UPDATE diary SET collect = collect-1 WHERE id=#{id}")
    public void editDiarySubCollect(String id) throws Exception;

    //根据id修改显示为1
    @Update("UPDATE diary SET showStatus = 1 WHERE id=#{id}")
    public void editDiaryShowOneById(String id) throws Exception;

    //根据id修改显示为0
    @Update("UPDATE diary SET showStatus = 0 WHERE id=#{id}")
    public void editDiaryShowZeroById(String id) throws Exception;

    //根据id修改删除
    @Delete("DELETE FROM diary WHERE id=#{id}")
    public void delDiaryById(String id) throws Exception;

    //查询所有未处理的订单
    @Select("SELECT * FROM diary WHERE diaryStatus = 0")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "collect", column = "collect"),
            @Result(property = "likeCount", column = "likeCount"),
            @Result(property = "texts", column = "texts"),
            @Result(property = "member", column = "memberId", javaType = Member.class, one = @One(select = "com.wx.dao.IMemberDao.findById")),
            @Result(property = "createTime", column = "createTime"),
            @Result(property = "updateTime", column = "updateTime"),
            @Result(property = "diaryStatus", column = "diaryStatus"),
            @Result(property = "showStatus", column = "showStatus")
    })
    public List<Diary> getDiaryByStatusZero() throws Exception;

    //查询游记，按产品查询
    @Select("SELECT * FROM diary WHERE productId=#{productId} AND showStatus=1")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.wx.dao.IProductDao.findById")),
            @Result(property = "collect", column = "collect"),
            @Result(property = "likeCount", column = "likeCount"),
            @Result(property = "texts", column = "texts"),
            @Result(property = "member", column = "memberId", javaType = Member.class, one = @One(select = "com.wx.dao.IMemberDao.findById")),
            @Result(property = "createTime", column = "createTime"),
            @Result(property = "updateTime", column = "updateTime"),
            @Result(property = "diaryStatus", column = "diaryStatus"),
            @Result(property = "showStatus", column = "showStatus"),
            @Result(property = "comments", column = "id", javaType = java.util.List.class, many = @Many(select = "com.wx.dao.ICommentDao.findCommentByDiaryId")),
    })
    public List<Diary> findDiaryByProductId(@Param("productId") String productId) throws Exception;

    //通过游记标题查询游记
    @Select("SELECT * FROM diary WHERE title=#{title}")
    public Diary findDiaryByDiaryTitle(@Param("title")String title) throws Exception;

}
