package org.rolofge.application.backend.service;

import org.rolofge.application.backend.data.UserDto;
import org.rolofge.application.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserDto> getUser(String userId) {
        return repository.findById(userId).stream()
                .map(UserDto::of)
                .collect(Collectors.toList());
    }
}
