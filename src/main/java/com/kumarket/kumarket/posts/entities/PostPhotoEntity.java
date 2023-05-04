package com.kumarket.kumarket.posts.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "photo")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostPhotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

    public void setPost(PostEntity postEntity) {
        this.post = postEntity;
    }
}

