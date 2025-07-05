package com.example.blog.controller;

import com.example.blog.entity.UserEvent;
import com.example.blog.service.UserEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class UserEventController {
    private final UserEventService userEventService;

    @GetMapping
    public List<UserEvent> list() {
        return userEventService.list();
    }

    @PostMapping
    public UserEvent create(@RequestBody UserEvent event) {
        userEventService.save(event);
        return event;
    }
}
