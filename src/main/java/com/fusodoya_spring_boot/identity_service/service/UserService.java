package com.fusodoya_spring_boot.identity_service.service;

import com.fusodoya_spring_boot.identity_service.dto.request.UserCreationRequest;
import com.fusodoya_spring_boot.identity_service.dto.request.UserUpdateRequest;
import com.fusodoya_spring_boot.identity_service.dto.response.UserResponse;
import com.fusodoya_spring_boot.identity_service.entity.User;
import com.fusodoya_spring_boot.identity_service.exception.AppException;
import com.fusodoya_spring_boot.identity_service.exception.ErrorCode;
import com.fusodoya_spring_boot.identity_service.mapper.UserMapper;
import com.fusodoya_spring_boot.identity_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public UserResponse createUser(UserCreationRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        User user = userMapper.toUser(request);

        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(UserUpdateRequest request, String id) {
        User user = getUserById(id);
        userMapper.updateUser(user, request);
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
