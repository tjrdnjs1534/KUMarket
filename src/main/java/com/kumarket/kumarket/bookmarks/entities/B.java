//package com.kumarket.kumarket.bookmarks.entities;
//
//import com.kumarket.kumarket.users.entities.UserEntity;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "bookmark")
//@Builder
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//public class BookmarkEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long id;
//
//    @OneToOne
//    @JoinColumn(name = "user_id")
//    UserEntity user;
//
//    @OneToMany(mappedBy = "bookmark", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<BookmarkPostEntity> bookmarkPost = new ArrayList<>();
//
//    public void setUser(UserEntity user) {
//        this.user = user;
//    }
//}
