package xyz.playedu.api.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    /** 评论ID */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 评论内容 */
    @TableField("content")
    private String content;

    /** 评论的帖子ID */
    @TableField("postId")
    private Long postId;

    /** 评论创建时间 */
    @TableField("createdAt")
    private LocalDateTime createdAt;

    /** 评论最后更新时间 */
    @TableField("updatedAt")
    private LocalDateTime updatedAt;
}


