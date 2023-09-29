package com.example.jpatesting.controller;

import com.example.jpatesting.entity.UserEntity;
import com.example.jpatesting.response.ApiResponse;
import com.example.jpatesting.service.Service.UserService;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<?> GetAllUser(){
        return ResponseEntity.ok(new ApiResponse<List<UserEntity>>(
                201,
                userService.GetAllUser(),
                LocalDateTime.now(),
                true
        ));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<UserEntity>>> GetUserId(@PathVariable Long id){
        return ResponseEntity.ok(new ApiResponse<Optional<UserEntity>>(
                201,
                userService.GetUserById(id),
                LocalDateTime.now(),
                true
        ));
    }
    @PostMapping
    public ResponseEntity<?> InserUser(@RequestBody UserEntity userEntity){
        return ResponseEntity.ok(new ApiResponse<UserEntity>(
                201,
                userService.InsertUser(userEntity),
                LocalDateTime.now(),
                true
        ));
    }
    @PutMapping
    public ResponseEntity<?> UpdateUser(@RequestBody UserEntity userEntity){
        return ResponseEntity.ok(new ApiResponse<UserEntity>(
                201,
                userService.UpdateUser(userEntity),
                LocalDateTime.now(),
                true
        ));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeleteUserById(@PathVariable Long id){
        userService.DeleteUser(id);
        return ResponseEntity.ok(new ApiResponse<String>(
                201,
               "Deleted SuccessFully",
                LocalDateTime.now(),
                true
        ));
    }
}
