package com.kumarket.kumarket.users.dto;


import com.kumarket.kumarket.users.entities.UserEntity;
import lombok.*;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private String username;
    private String password;
    private String phoneNumber;
    public UserEntity toEntity(){
        UserEntity userEntity = UserEntity.builder()
                .username(username)
                .password(password)
                .phoneNumber(phoneNumber)
                .bookmarks(new ArrayList<>())
                .likes(0)
                .posts(new ArrayList<>())
                .build();
        return userEntity;
    }
}
