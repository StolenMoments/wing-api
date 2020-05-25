package com.example.wingapi.web;


import com.example.wingapi.service.UserService;
import com.example.wingapi.web.dto.user.UserRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = {"User Controller"})
@RequestMapping(value = "/api/user")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    // 유저 저장
    @ApiOperation(value = "유저 정보 등록", notes = "이메일로 (email)로 조회")
    @PostMapping("/save")
    public String saveUser(@RequestBody UserRequestDto userRequestDto){
        System.out.println(userRequestDto.toString());
        return userService.save(userRequestDto);
    }
}
