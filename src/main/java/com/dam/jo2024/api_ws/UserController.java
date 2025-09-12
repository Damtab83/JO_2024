package com.dam.jo2024.api_ws;

import com.dam.jo2024.pojo.User;
import com.dam.jo2024.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Displaying CRUD of the Users for the API
@RestController
@RequestMapping(ApiRegistration.REST_API + ApiRegistration.REST_USER)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Object>getAllUser() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object>getUserById(@PathVariable Long id) {

        User myUser = userService.getUserById(id);
        return myUser ==null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.status(HttpStatus.OK).body(myUser);
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody User myUser) {
        userService.createUser(myUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable Long id) {
        Boolean isDelete = userService.deleteUser(id);
        return isDelete ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Object>updateUserById(@PathVariable Long id, @RequestBody User newUser) {
        userService.updateUser(id, newUser);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
