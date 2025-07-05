package com.example.blog.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_event")
public class UserEvent {
    @TableId
    private Long id;
    private Long userId;
    private String action;
}
