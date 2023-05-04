package com.kumarket.kumarket.posts;

import com.kumarket.kumarket.posts.dto.PostDto;
import com.kumarket.kumarket.posts.entities.PostEntity;
import com.kumarket.kumarket.posts.entities.PostPhotoEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    // 전체 조회
    public List<PostDto> findAllPosts() { //dto로 변경하기
        List<PostEntity> postEntities = postRepository.findAll();
        List<PostDto> postDtoList = new ArrayList<>();
        for(PostEntity post : postEntities){
            postDtoList.add(new PostDto(post));
        }
        return postDtoList;
    }
    // 개별 조회
    public PostDto findPostById(Long id){
        return new PostDto(postRepository.findById(id).get());
    }
    // 등록 수정?
    @Transactional
    public PostDto createPost(PostDto postDto){
        PostEntity postEntity = postRepository.save(postDto.toEntity(postDto));
        return new PostDto(postEntity);
    }
    // 수정
    @Transactional
    public PostDto updatePost(Long id, PostDto postDto){
        PostEntity postEntity = postRepository.findById(id).get();
        postEntity.removeAllPhotos();
        PostEntity updatePostEntity = PostEntity.builder()
                .id(id)
                .title(postDto.getTitle())
                .description(postDto.getDescription())
                .price(postDto.getPrice())
                .thumbnailUrl(postDto.getThumbnailUrl())
                .photos(new ArrayList<>())
                .viewCount(postEntity.getViewCount())
                .build();
        for(String url : postDto.getPhotos().getUrls()){
            updatePostEntity.addPhoto(PostPhotoEntity.builder().url(url).build());
        }
        PostEntity returnEntity= postRepository.save(updatePostEntity);
        return new PostDto(returnEntity);
    }

    // 삭제
    @Transactional
    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
}
