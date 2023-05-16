package com.kumarket.kumarket.bookmarks;

import com.kumarket.kumarket.bookmarks.entities.BookmarkEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BookmarkController {
    private final BookmarkService bookmarkService;

    @PostMapping
    @RequestMapping("/bookmarks/{postId}")
    public void changeBookmark(@PathVariable Long postId){
        // userid가 cookie 같은 방식으로 들어옴
        Long userId = 1L;
        bookmarkService.changeBookmark(userId, postId);
    }

    @GetMapping
    @RequestMapping("/users/bookmarks")
    public List<BookmarkEntity> getUserAllBookmarks(){
        Long userId = 1L;
        return bookmarkService.getUserAllBookmarks(userId);
    }


}
