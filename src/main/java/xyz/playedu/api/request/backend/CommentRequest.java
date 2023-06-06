package xyz.playedu.api.request.backend;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
public class CommentRequest {

    @NotBlank(message = "请输入回复内容")
    private String content;


    @NotNull(message = "post_id参数不存在")
    @JsonProperty("postId")
    private Long postId;
}
