package com.example.blog.controller;

import com.example.blog.entity.Comment;
import com.example.blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public List<Comment> list() {
        return commentService.list();
    }

    @PostMapping
    public Comment create(@RequestBody Comment comment) {
        commentService.save(comment);
        return comment;
    }
}
