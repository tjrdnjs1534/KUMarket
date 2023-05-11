package com.kumarket.kumarket.bookmarks.entities;

import com.kumarket.kumarket.posts.entities.PostEntity;
import com.kumarket.kumarket.users.entities.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bookmark_post")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkPostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bookmark_id")
    private BookmarkEntity bookmark;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

    public void setBookmark(BookmarkEntity bookmarkEntity) {
        this.bookmark = bookmarkEntity;
    }
    public void setPost(PostEntity postEntity){
        this.post = postEntity;
    }
}
