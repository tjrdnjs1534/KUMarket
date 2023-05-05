package com.kumarket.kumarket.users;

import com.kumarket.kumarket.users.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("users")
@RestController
public class UserController {
    private final UserService userService;
    @PostMapping("")
    public void joinUser(@RequestBody UserDto userDto){
        userService.createUser(userDto);
    }

}
