package com.fusodoya_spring_boot.identity_service.mapper;

import com.fusodoya_spring_boot.identity_service.dto.request.UserCreationRequest;
import com.fusodoya_spring_boot.identity_service.dto.request.UserUpdateRequest;
import com.fusodoya_spring_boot.identity_service.dto.response.UserResponse;
import com.fusodoya_spring_boot.identity_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    @Mapping(target = "id", source = "id")
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
