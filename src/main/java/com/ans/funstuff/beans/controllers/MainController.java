package com.ans.funstuff.beans.controllers;

import com.ans.funstuff.beans.services.BookmarkService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class MainController {
    private BookmarkService bookmarkService;
    private ObjectMapper mapper;

    @GetMapping("/")
    public String getRoot() {
        return "redirect:index.html";
    }

    @ResponseBody
    @PostMapping("/add")
    public String addUser() {
        return "New bookmark added?";
    }

    @ResponseBody
    @GetMapping("/id")
    public String getId() {
        return "This is some id";
    }

    @Autowired
    public MainController(BookmarkService bookmarkService, ObjectMapper objectMapper) {
        this.bookmarkService = bookmarkService;
        this.mapper = objectMapper;
    }
}

