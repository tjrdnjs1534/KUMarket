package com.kumarket.kumarket.users;

import com.kumarket.kumarket.users.dto.UserDto;
import com.kumarket.kumarket.users.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public void createUser(UserDto userDto){
        //BookmarkEntity bookmarkEntity = new BookmarkEntity();
        UserEntity userEntity =userDto.toEntity();
        //bookmarkEntity.setUser(userEntity);
        //userEntity.setBookmark(bookmarkEntity);
        userRepository.save(userEntity);
    }

}
