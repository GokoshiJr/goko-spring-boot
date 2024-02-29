package com.goko.HandleException.services;

import com.goko.HandleException.models.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findById(Long id);
    List<User> findAll();
}
