package com.example.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.entity.UserEvent;
import com.example.blog.mapper.UserEventMapper;
import com.example.blog.service.UserEventService;
import org.springframework.stereotype.Service;

@Service
public class UserEventServiceImpl extends ServiceImpl<UserEventMapper, UserEvent> implements UserEventService {
}
