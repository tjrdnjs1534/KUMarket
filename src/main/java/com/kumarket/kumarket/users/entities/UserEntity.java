package com.kumarket.kumarket.users.entities;

import com.kumarket.kumarket.bookmarks.entities.BookmarkEntity;
import com.kumarket.kumarket.common.BaseTimeEntity;
import com.kumarket.kumarket.posts.entities.PostEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "market_user")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    @Column(name = "phone_number")
    private String phoneNumber;

    private Integer likes;

    @OneToMany(mappedBy = "user")
    private List<BookmarkEntity> bookmarks = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<PostEntity> posts = new ArrayList<>();
    public void uploadPost(PostEntity postEntity){
        posts.add(postEntity);
        postEntity.setUser(this);
    }
}
