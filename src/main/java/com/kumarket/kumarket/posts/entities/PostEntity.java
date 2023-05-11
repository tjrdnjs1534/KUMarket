package com.kumarket.kumarket.posts.entities;

import com.kumarket.kumarket.bookmarks.entities.BookmarkPostEntity;
import com.kumarket.kumarket.common.BaseTimeEntity;
import com.kumarket.kumarket.posts.Category;
import com.kumarket.kumarket.users.entities.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
public class PostEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String title;
    private String description;

    private Long price;

    @Column(name = "thumbnail_url")
    //@ColumnDefault("no.png") // 없을 때 url 없이
    private String thumbnailUrl;

    @Column(name = "view_count")
    @ColumnDefault("0")
    private Long viewCount;

    @ManyToOne
    @JoinColumn(name = "user_id" , updatable = false)
    private UserEntity user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<BookmarkPostEntity> bookmarks = new ArrayList<>(); //이게 맞나? bookmark는 정말 많을텐데 이렇게 관리?
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PostPhotoEntity> photos = new ArrayList<>();


    public void setUser(UserEntity userEntity){
        this.user = userEntity;
    }

    public void addPhoto(PostPhotoEntity photo){
        photos.add(photo);
        photo.setPost(this);
    }

    public void removePhoto(PostPhotoEntity photo){
        photos.remove(photo);
        photo.setPost(null);
    }
    public void removeAllPhotos(){
        for(PostPhotoEntity photo : photos){
            this.removePhoto(photo);
        }
    }
    public void addBookmark(BookmarkPostEntity bookmarkPostEntity){
        bookmarks.add(bookmarkPostEntity);
        bookmarkPostEntity.setPost(this);
    }
    public void removeBookmark(BookmarkPostEntity bookmarkPostEntity){
        bookmarks.remove(bookmarkPostEntity);
        bookmarkPostEntity.setPost(null);
    }
    /*
    public void updatePost(String title, String description, Long price){
        this.title = title;
        this.description = description;
        this.price = price;
    }
    public void updatePostPhoto(List<String> urls){
        for(String url : urls){
            this.addPhoto(PostPhotoEntity.builder().url(url).build());
        }
    }*/


}
