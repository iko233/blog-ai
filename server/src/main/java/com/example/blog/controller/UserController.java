package com.example.blog.controller;

import com.example.blog.entity.User;
import com.example.blog.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final String secret = "secret-key";

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return user;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {
        User db = userService.lambdaQuery().eq(User::getUsername, user.getUsername()).one();
        if (db != null && passwordEncoder.matches(user.getPassword(), db.getPassword())) {
            String token = Jwts.builder()
                    .setSubject(db.getId().toString())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                    .signWith(SignatureAlgorithm.HS256, secret.getBytes())
                    .compact();
            Map<String, String> map = new HashMap<>();
            map.put("token", token);
            return map;
        }
        throw new RuntimeException("Invalid credentials");
    }
}
