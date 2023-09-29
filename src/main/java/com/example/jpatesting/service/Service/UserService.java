package com.example.jpatesting.service.Service;

import com.example.jpatesting.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<UserEntity> GetAllUser();
    Optional<UserEntity> GetUserById(Long id);
    UserEntity UpdateUser(UserEntity userEntity);
    UserEntity InsertUser(UserEntity userEntity);
    void DeleteUser(Long id);
}
