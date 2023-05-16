package com.kumarket.kumarket.bookmarks;

import com.kumarket.kumarket.bookmarks.entities.BookmarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<BookmarkEntity, Long> {
    List<BookmarkEntity> findAllByUserId(Long id);
}
