package com.vti.finalProject.controller;

import com.vti.finalProject.dto.UserDto;
import com.vti.finalProject.form.UserCreateForm;
import com.vti.finalProject.form.UserUpdateForm;
import com.vti.finalProject.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody @Valid UserCreateForm form) {
        return userService.create(form);
    }

    @GetMapping("/email/{email}")
    public UserDto getUserByEmail(@PathVariable String email) {
        UserDto user = userService.searchByEmail(email);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with email: " + email);
        }
        return user;
    }

    @GetMapping("/id/{id}")
    public UserDto getUserById(@PathVariable long id) {
        UserDto user = userService.searchById(id);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with ID: " + id);
        }
        return user;
    }

    @PutMapping("/id/{id}")
    public UserDto updateUser(@PathVariable long id, @RequestBody @Valid UserUpdateForm form) {
        UserDto updatedUser = userService.update(id, form);
        if (updatedUser == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with ID: " + id);
        }
        return updatedUser;
    }

    @DeleteMapping("/id/{id}")
    public void deleteUser(@PathVariable long id) {
        try {
            userService.delete(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with ID: " + id);
        }
    }
}
