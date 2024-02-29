package com.goko.HandleException.services;

import com.goko.HandleException.exceptions.UserNotFoundException;
import com.goko.HandleException.models.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private List<User> userList;

    public  UserServiceImpl() {
        this.userList = new ArrayList<>();
        userList.add(new User(1L, "Julio", "Gonzalez"));
        userList.add(new User(2L, "Foo", "Bar"));
        userList.add(new User(3L, "John", "Doe"));
        userList.add(new User(4L, "Marie", "Curie"));
        userList.add(new User(5L, "Lisa", "Simpson"));
    }

    @Override
    public Optional<User> findById(Long id) {
        User findUser = this.userList.stream()
                .filter(user -> Objects.equals(user.getId(), id))
                .findFirst()
                .orElse(null);

        if (findUser == null) { throw new UserNotFoundException(""); }
        return Optional.of(findUser);
    }

    @Override
    public List<User> findAll() {
        return this.userList;
    }
}
