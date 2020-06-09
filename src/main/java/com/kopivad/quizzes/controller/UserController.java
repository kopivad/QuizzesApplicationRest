package com.kopivad.quizzes.controller;

import com.kopivad.quizzes.domain.User;
import com.kopivad.quizzes.form.UserForm;
import com.kopivad.quizzes.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("{id}")
    public User getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @PostMapping()
    public User save(@RequestBody UserForm userForm) {
        return userService.save(userForm);
    }

    @PutMapping("{id}")
    public User update(@PathVariable("id") Long id, @RequestBody UserForm userForm) {
        return userService.update(id, userForm);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }
}
