package com.ans.funstuff.beans.controllers;

import com.ans.funstuff.beans.services.BookmarkService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private BookmarkService bookmarkService;
    private ObjectMapper mapper;

    @GetMapping("/")
    public String getRoot() {
        return "This is root";
    }

    @PostMapping("/add")
    public String addUser() {
        return "New bookmark added?";
    }

    @Autowired
    public MainController(BookmarkService bookmarkService, ObjectMapper objectMapper) {
        this.bookmarkService = bookmarkService;
        this.mapper = objectMapper;
    }
}

