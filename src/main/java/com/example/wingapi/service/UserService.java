package com.example.wingapi.service;


import com.example.wingapi.domain.user.UserRepository;
import com.example.wingapi.web.dto.user.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public String save(UserRequestDto userRequestDto) {
        userRepository.save(userRequestDto.toEntity());
        return userRequestDto.getName();
    }

}
