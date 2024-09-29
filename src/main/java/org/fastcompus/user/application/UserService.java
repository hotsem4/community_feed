package org.fastcompus.user.application;

import org.fastcompus.user.application.dto.CreateUserRequestDto;
import org.fastcompus.user.application.interfaces.UserRepository;
import org.fastcompus.user.domain.User;
import org.fastcompus.user.domain.UserInfo;

/**
 * 비지니스 로직을 직접 처리하기 보단 다른 객체와 협력하기 위한 객체이다.
 */
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(CreateUserRequestDto dto) {
        UserInfo info = new UserInfo(dto.name(),dto.profileImageUrl());
        User user = new User(null, info);
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(null);
    }
}
