package com.kumarket.kumarket.users;

import com.kumarket.kumarket.users.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public void createUser(UserDto userDto){
        userRepository.save(userDto.toEntity());
    }


}
