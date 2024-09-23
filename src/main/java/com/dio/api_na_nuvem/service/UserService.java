package com.dio.api_na_nuvem.service;

import com.dio.api_na_nuvem.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User user);

}
