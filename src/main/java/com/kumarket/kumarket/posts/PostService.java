package com.kumarket.kumarket.posts;

import com.kumarket.kumarket.posts.dto.PostDto;
import com.kumarket.kumarket.posts.entities.PostEntity;
import com.kumarket.kumarket.posts.entities.PostPhotoEntity;
import com.kumarket.kumarket.users.UserRepository;
import com.kumarket.kumarket.users.entities.UserEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
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
        PostEntity postEntity = postDto.toEntity();
        Long userId = 1L; //user 추가하는 부분 임의로 1번 user 생성하고 연결한다고 가정 --- jwt토큰 payload의 id부분을 받도록 해야할듯
        UserEntity userEntity = userRepository.findById(userId).orElseThrow();
        userEntity.uploadPost(postEntity);
        PostEntity returnPostEntity = postRepository.save(postEntity);
        return new PostDto(returnPostEntity);
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
                .bookmarks(postEntity.getBookmarks())
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
