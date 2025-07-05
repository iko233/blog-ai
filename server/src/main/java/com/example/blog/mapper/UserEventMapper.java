package com.example.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.entity.UserEvent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserEventMapper extends BaseMapper<UserEvent> {}
