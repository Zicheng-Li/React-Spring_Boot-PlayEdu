package xyz.playedu.api.request.backend;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PostRequest {

    @NotBlank(message = "请输入帖子标题")
    private String title;

    @NotBlank(message = "请输入帖子内容")
    private String content;

//    @NotNull(message = "user_id参数不存在")
//    @JsonProperty("user_id")
//    private Long userId;

//    @NotNull(message = "board_id参数不存在")
//    @JsonProperty("board_id")
//    private Integer boardId;
}