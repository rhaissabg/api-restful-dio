package com.dio.api_na_nuvem.service.impl;

import com.dio.api_na_nuvem.domain.model.User;
import com.dio.api_na_nuvem.domain.model.UserRepository;
import com.dio.api_na_nuvem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This user ID already exists");
        }
        return userRepository.save(userToCreate);
    }

}
