package com.example.blog.controller;

import com.example.blog.entity.Tag;
import com.example.blog.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @GetMapping
    public List<Tag> list() {
        return tagService.list();
    }

    @PostMapping
    public Tag create(@RequestBody Tag tag) {
        tagService.save(tag);
        return tag;
    }
}
