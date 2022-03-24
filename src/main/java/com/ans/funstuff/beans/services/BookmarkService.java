package com.ans.funstuff.beans.services;

import com.ans.funstuff.beans.models.Bookmark;
import com.ans.funstuff.beans.repos.BookmarkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookmarkService {
    private BookmarkRepo bookmarkRepo;

    @Autowired
    BookmarkService(BookmarkRepo bookmarkRepo) {
        this.bookmarkRepo = bookmarkRepo;
    }


    public Optional<Bookmark> getBookmarkById(Integer bookmarkId) {
        //System.out.println(bookmarkRepo.getById(bookmarkId));
        //return bookmarkRepo.getById(bookmarkId);
        return bookmarkRepo.findById(bookmarkId);
    }

    public void addBookmark(Bookmark bookmark) {
        bookmarkRepo.save(bookmark);
    }

    public List<Bookmark> getAllBookmarks() {
        return bookmarkRepo.findAll();
    }
}