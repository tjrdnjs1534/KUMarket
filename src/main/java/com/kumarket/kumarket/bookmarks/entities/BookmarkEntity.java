package com.kumarket.kumarket.bookmarks.entities;

import com.kumarket.kumarket.posts.entities.PostEntity;
import com.kumarket.kumarket.users.entities.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bookmark")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

    public void setUser(UserEntity userEntity) {
        this.user = userEntity;
    }
    public void setPost(PostEntity postEntity){
        this.post = postEntity;
    }
}
