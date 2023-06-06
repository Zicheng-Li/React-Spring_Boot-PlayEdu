package xyz.playedu.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import xyz.playedu.api.domain.Post;

@Mapper
public interface PostMapper extends BaseMapper<Post> {
    @Insert("INSERT INTO posts (title ,content, createdAt, updatedAt) VALUES (#{title}, #{content}, #{createdAt}, #{updatedAt})")
    int insertPost(Post post);

    @Update("UPDATE posts SET title= #{title}, content = #{content}, updatedAt = #{updatedAt} WHERE id = #{id}")
    int updatePost(Post post);
    // done
}
