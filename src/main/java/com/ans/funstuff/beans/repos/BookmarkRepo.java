package com.ans.funstuff.beans.repos;

import com.ans.funstuff.beans.models.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepo extends JpaRepository<Bookmark, Integer> {

}
