package com.kumarket.kumarket.bookmarks;

import com.kumarket.kumarket.bookmarks.entities.BookmarkEntity;
import com.kumarket.kumarket.posts.PostRepository;
import com.kumarket.kumarket.posts.entities.PostEntity;
import com.kumarket.kumarket.users.UserRepository;
import com.kumarket.kumarket.users.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;


    public void changeBookmark(Long userId, Long postId) {
        //UserEntity userEntity = userRepository.findById(userId).orElseThrow();
        //Optional<BookmarkEntity> bookmarkEntity = bookmarkRepository.findByUserId(userId);
        UserEntity userEntity = userRepository.findById(userId).orElseThrow();
        PostEntity postEntity = postRepository.findById(postId).orElseThrow();
        BookmarkEntity bookmarkEntity = new BookmarkEntity();

        bookmarkEntity.setUser(userEntity);
        bookmarkEntity.setPost(postEntity);
        bookmarkRepository.save(bookmarkEntity);
    }
    public List<BookmarkEntity> getUserAllBookmarks(Long userId) {
        // userid로 bookmark id 찾고 bookmark id의 모든 bookmark post 불러오기

        return bookmarkRepository.findAllByUserId(userId).stream().toList();
    }
}
