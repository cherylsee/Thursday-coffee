package com.ans.funstuff.beans.services;

import com.ans.funstuff.beans.models.Bookmark;
import com.ans.funstuff.beans.repos.BookmarkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookmarkService {
    @Autowired
    private BookmarkRepo bookmarkRepo;

    public Bookmark getBookmarkById(Integer bookmarkId) {
        return bookmarkRepo.getById(bookmarkId);
    }

    public void addBookmark(Bookmark bookmark) {
        bookmarkRepo.save(bookmark);
    }

}
