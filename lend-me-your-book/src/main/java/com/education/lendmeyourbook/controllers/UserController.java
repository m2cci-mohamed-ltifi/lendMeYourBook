package com.education.lendmeyourbook.controllers;

import com.education.lendmeyourbook.entities.User;
import com.education.lendmeyourbook.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> list(){
        return userRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        return ResponseEntity.ok(user.get());
    }

    @PostMapping("/create")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        user = userRepository.saveAndFlush(user);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }

}
