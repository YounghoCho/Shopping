package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UsersEntity;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    public UserDto getUser(String name) {

        UsersEntity usersEntity = usersRepository.findOneByName(name);

        UserDto userDto = UserDto.builder()
                .idx(usersEntity.getIdx())
                .name(usersEntity.getName())
                .build();

        return userDto;

    }
    @Transactional
    public void join() {
        UsersEntity usersEntity = UsersEntity.builder()
                .name("영준")
                .password("1234")
                .build();
        usersRepository.save(usersEntity);
    }

}
