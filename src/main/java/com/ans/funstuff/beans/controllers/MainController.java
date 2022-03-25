package com.ans.funstuff.beans.controllers;

import com.ans.funstuff.beans.models.Bookmark;
import com.ans.funstuff.beans.services.BookmarkService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@RestController - not using because I'm hosting the page (index.html)
@Controller
public class MainController {
    private final BookmarkService bookmarkService;
    private ObjectMapper mapper;

    @GetMapping("/")
    public String getRoot() {
        return "redirect:index.html";
    }

    @ResponseBody
    @PostMapping("/add")
    public Bookmark addUser(@RequestBody Bookmark bookmark) {
        return bookmarkService.addBookmark(bookmark);
    }

    @ResponseBody
    @GetMapping("/all")
    public List<Bookmark> getAll() {
        return bookmarkService.getAllBookmarks();
    }

    @ResponseBody
    @GetMapping("/id/{id}")
    public Optional<Bookmark> getId(@PathVariable("id") Integer id) {
        return bookmarkService.getBookmarkById(id);
    }

    @Autowired
    public MainController(BookmarkService bookmarkService, ObjectMapper objectMapper) {
        this.bookmarkService = bookmarkService;
        this.mapper = objectMapper;
    }
}

