package xyz.playedu.api.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@TableName(value = "posts")
@Data
public class Post {
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 帖子标题 */
    private String title;

    /** 帖子内容 */
    private String content;

    /** 帖子创建时间 */
    @TableField("createdAt")
    private LocalDateTime createdAt;

    /** 帖子最后更新时间 */
    @TableField("updatedAt")
    private LocalDateTime updatedAt;
}
