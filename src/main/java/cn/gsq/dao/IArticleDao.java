package cn.gsq.dao;

import cn.gsq.domain.Content;
import cn.gsq.domain.Tag;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 文章页的Dao层接口
 * @author mechrevo
 */
public interface IArticleDao {
    /**
     * 查询所有
     */
    @Select("select * from content where title like #{key} order by time desc")
    @Results({
            @Result(column = "id", id = true, property = "id"),
            @Result(column = "title" ,property = "title"),
            @Result(column = "short_text",property = "short_text"),
            @Result(column = "text",property = "text"),
            @Result(column = "time",property = "time"),
            @Result(column = "firstImg",property = "firstImg"),
            @Result(column = "tagId",property = "tag",javaType = Tag.class,one=@One(select = "cn.gsq.dao.ITagDao.findById"))
    })
    List<Content> findAll(String key);

    /**
     * 通过ID查询
     * @param id
     * @return
     */
    @Select("select * from content where id=#{id}")
    @Results(value = {
            @Result(column = "id", id = true, property = "id"),
            @Result(column = "title", property = "title"),
            @Result(column = "short_text", property = "short_text"),
            @Result(column = "text", property = "text"),
            @Result(column = "time", property = "time"),
            @Result(column = "firstImg", property = "firstImg"),
            @Result(column = "id", property = "imgs", javaType = List.class, many = @Many(select = "cn.gsq.dao.IImgsDao.findAllById")),
            @Result(column = "tagId",property = "tag",javaType = Tag.class,one=@One(select = "cn.gsq.dao.ITagDao.findById"))

    })
    Content findById(String id);

    /**
     * 通过标签ID分类查找
     * @param tagId
     * @return
     */
    @Select("select * from content where tagId=#{tagId} order by time desc")
    @Results({
            @Result(column = "id", id = true, property = "id"),
            @Result(column = "title" ,property = "title"),
            @Result(column = "short_text",property = "short_text"),
            @Result(column = "text",property = "text"),
            @Result(column = "time",property = "time"),
            @Result(column = "firstImg",property = "firstImg"),
            @Result(column = "tagId",property = "tag",javaType = Tag.class,one=@One(select = "cn.gsq.dao.ITagDao.findById"))
    })
    List<Content> findAllByTagId(String tagId);

    /**
     * 添加文章
     * @param content
     */
    @Insert("insert into content (title, short_text, text) value (#{title},#{short_text},#{text})")
    void save(Content content);

    /**
     * 推荐文章
     * @return
     */
    @Select("select * from content where id in (select rcid from recommend);")
    List<Content> findRecommend();
}
