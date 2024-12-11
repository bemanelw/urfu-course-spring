package ru.chernyugov.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.chernyugov.springcourse.dto.UserDto;
import ru.chernyugov.springcourse.mappers.TaskMapper;
import ru.chernyugov.springcourse.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TaskMapper taskMapper;

    @GetMapping
    public Flux<UserDto> getAllUsers() {
        return userService.findAll()
                .map(taskMapper::toUserDto);
    }

    @GetMapping("/{id}")
    public Mono<UserDto> getUserById(@PathVariable String id) {
        return userService.findById(id)
                .map(taskMapper::toUserDto);
    }

    @PostMapping
    public Mono<UserDto> createUser(@RequestBody UserDto userDto) {
        return userService.save(taskMapper.toUser(userDto))
                .map(taskMapper::toUserDto);
    }

    @PutMapping("/{id}")
    public Mono<UserDto> updateUser(@PathVariable String id, @RequestBody UserDto userDto) {
        return userService.update(id, taskMapper.toUser(userDto))
                .map(taskMapper::toUserDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUser(@PathVariable String id) {
        return userService.deleteById(id);
    }
}

