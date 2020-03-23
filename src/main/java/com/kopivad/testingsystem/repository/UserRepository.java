package com.kopivad.testingsystem.repository;

import com.kopivad.testingsystem.domain.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findById(Long id);
    User save(User user);
    User update(Long id, User user);
    void delete(Long id);
    User findByEmail(String email);
}
