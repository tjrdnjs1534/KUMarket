package com.kumarket.kumarket.bookmarks;

import com.kumarket.kumarket.bookmarks.entities.BookmarkPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookmarkPostRepository extends JpaRepository<BookmarkPostEntity, Long> {
    List<BookmarkPostEntity> findAllByBookmarkId(Long id);
}
