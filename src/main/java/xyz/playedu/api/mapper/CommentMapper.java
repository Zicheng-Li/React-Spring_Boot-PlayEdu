package xyz.playedu.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import xyz.playedu.api.domain.Comment;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    @Insert("INSERT INTO comment (content, postId, createdAt, updatedAt) VALUES (#{content}, #{postId}, #{createdAt}, #{updatedAt})")
    int insertComment(Comment comment);

    @Update("UPDATE comment SET content = #{content}, postId = #{postId}, updatedAt = #{updatedAt} WHERE id = #{id}")
    int updateComment(Comment comment);
    // done
}
