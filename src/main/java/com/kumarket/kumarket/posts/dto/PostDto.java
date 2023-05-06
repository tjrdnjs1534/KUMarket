package com.kumarket.kumarket.posts.dto;

import com.kumarket.kumarket.posts.entities.PostEntity;
import com.kumarket.kumarket.posts.entities.PostPhotoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {
    private String title;
    private String description;
    private Long price;
    private String thumbnailUrl;
    private PostPhotoDto photos;

    public PostDto(PostEntity postEntity) {
        List<String> url = new ArrayList<>();
        for(PostPhotoEntity photo : postEntity.getPhotos()){
            url.add(photo.getUrl());
        }
        PostPhotoDto postPhotoDto = new PostPhotoDto(url);

        this.title = postEntity.getTitle();
        this.description = postEntity.getDescription();
        this.price = postEntity.getPrice();
        this.photos = postPhotoDto;
        this.thumbnailUrl = postEntity.getThumbnailUrl();
    }  // 생성자로 한거

//    public PostDto entityToDto(PostEntity postEntity){
//        List<String> url = new ArrayList<>();
//        for(PostPhotoEntity photo : postEntity.getPhotos()){
//            url.add(photo.getUrl());
//        }
//        PostPhotoDto postPhotoDto = new PostPhotoDto(url);
//        return PostDto.builder()
//                .title(postEntity.getTitle())
//                .description(postEntity.getDescription())
//                .price(postEntity.getPrice())
//                .photos(postPhotoDto)
//                .build();
//    } method로 한거
    public PostEntity toEntity(){ // id 유지 x
        PostEntity postEntity = PostEntity.builder()
                .title(title)
                .description(description)
                .thumbnailUrl(thumbnailUrl)
                .price(price)
                .photos(new ArrayList<>())
                .build();
        for(String url : photos.getUrls()){
            postEntity.addPhoto(PostPhotoEntity.builder().url(url).build());
        }
        return postEntity;
    }



}
