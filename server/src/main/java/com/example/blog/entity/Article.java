package com.example.blog.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("article")
public class Article {
    @TableId
    private Long id;
    private String title;
    private String content;
    private Long userId;
    private Long categoryId;
}
