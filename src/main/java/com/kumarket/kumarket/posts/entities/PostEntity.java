package com.kumarket.kumarket.posts.entities;

import com.kumarket.kumarket.posts.Category;
import com.kumarket.kumarket.users.entities.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "post")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String title;
    private String description;

    private Long price;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

    @Column(name = "view_count")
    private Long viewCount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    // state
}
