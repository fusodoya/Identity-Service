package com.fusodoya_spring_boot.identity_service.controller;

import com.fusodoya_spring_boot.identity_service.dto.request.UserCreationRequest;
import com.fusodoya_spring_boot.identity_service.dto.request.UserUpdateRequest;
import com.fusodoya_spring_boot.identity_service.dto.response.ApiResponse;
import com.fusodoya_spring_boot.identity_service.dto.response.UserResponse;
import com.fusodoya_spring_boot.identity_service.entity.User;
import com.fusodoya_spring_boot.identity_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();

        apiResponse.setData(userService.createUser(request));
        return apiResponse;
    }

    @GetMapping
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    User getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@RequestBody @Valid UserUpdateRequest request, @PathVariable String userId) {
        return userService.updateUser(request, userId);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User deleted";
    }
}
