package cn.gsq.dao;

import cn.gsq.domain.Content;
import cn.gsq.domain.Tag;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 首页的Dao层接口
 */
public interface IContentDao {
    /**
     * 查询所有
     */
    @Select("select * from content order by time desc")
    @Results({
            @Result(column = "id", id = true, property = "id"),
            @Result(column = "title" ,property = "title"),
            @Result(column = "short_text",property = "short_text"),
            @Result(column = "text",property = "text"),
            @Result(column = "time",property = "time"),
            @Result(column = "firstImg",property = "firstImg"),
            @Result(column = "tagId",property = "tag",javaType = Tag.class,one=@One(select = "cn.gsq.dao.ITagDao.findById"))

    })
    List<Content> findAll();

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

    @Insert("insert into content (title, short_text, text) value (#{title},#{short_text},#{text})")
    void save(Content content);

    /**
     * 推荐文章
     * @return
     */
    @Select("select * from content where id in (select rcid from recommend);")
    List<Content> findRecommend();
}
