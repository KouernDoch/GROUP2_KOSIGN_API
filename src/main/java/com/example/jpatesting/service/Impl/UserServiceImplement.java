package com.example.jpatesting.service.Impl;

import com.example.jpatesting.entity.UserEntity;
import com.example.jpatesting.repository.UserRepository;
import com.example.jpatesting.service.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplement implements UserService {
    private final UserRepository userRepository;

    public UserServiceImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> GetAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> GetUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserEntity UpdateUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity InsertUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public void DeleteUser(Long id) {
      userRepository.deleteById(id);
    }
}
