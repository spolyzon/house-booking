package com.spolyzon.house.review.controller;

import com.spolyzon.house.review.domain.model.User;
import com.spolyzon.house.review.domain.repository.UserRepository;
import com.spolyzon.house.review.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        LOGGER.info("Retrieving all users");
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        LOGGER.info("Retrieving user by id {}", id);
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> createNewUser(@RequestBody UserDTO userDTO) {
        LOGGER.info("Creating new user");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userRepository.save(userDTO.getUser()));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestBody long userId) {
        LOGGER.info("Deleting user...");
        userRepository.deleteById(userId);
        return ResponseEntity.ok().build();
    }
}
