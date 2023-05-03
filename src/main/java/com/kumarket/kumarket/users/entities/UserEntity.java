package com.kumarket.kumarket.users.entities;

import com.kumarket.kumarket.bookmarks.entities.BookmarkEntity;
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
public class UserEntity {
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
}
