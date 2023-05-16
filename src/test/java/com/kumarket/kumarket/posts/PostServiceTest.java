//package com.kumarket.kumarket.posts;
//
//import com.kumarket.kumarket.posts.dto.PostDto;
//import com.kumarket.kumarket.posts.dto.PostPhotoDto;
//import com.kumarket.kumarket.users.UserRepository;
//import com.kumarket.kumarket.users.UserService;
//import com.kumarket.kumarket.users.dto.UserDto;
//import com.kumarket.kumarket.users.entities.UserEntity;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class PostServiceTest {
//    @Mock
//    private PostRepository postRepository;
//    @Mock
//    private UserRepository userRepository;
//
//    @InjectMocks
//    private PostService postService;
//    @BeforeEach
//    void setup(){
//        UserEntity userEntity = new UserEntity(1L,"user","password","phone",0,new ArrayList<>(),new ArrayList<>());
//        UserDto userDto = new UserDto("user","password", "phone");
//        Mockito.when(userRepository.save(any())).thenReturn(userEntity);
//        userRepository.save(userDto.toEntity());
//    }
//    @Test
//    void 포스트_생성() {
//        //given
//        PostPhotoDto postPhotoDto = new PostPhotoDto(List.of("1","2"));
//        PostDto postDto = new PostDto("create", "createPost", 1L,"create.png", postPhotoDto);
//        //stub
//        //Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));
//        Mockito.when(postRepository.save(any())).thenReturn(postDto.toEntity());
//        //when
//        PostDto postReturnDto =  postService.createPost(postDto);
//        //then
//        assertEquals(postReturnDto.getTitle(), postDto.getTitle());
//    }
//}