package com.salary.manager.controllers;

import com.salary.manager.controllers.model.user.UserRequest;
import com.salary.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/readToken")
    public String readToken(@RequestParam(name = "name") final String name, @RequestParam(name = "password") final String password) {
        return userService.generateToken(name, password);
    }

    @PostMapping(value = "/createUser")
    public void createUser(@RequestBody(required = true) final UserRequest userRequest) {
        userService.createUser(userRequest.getName(), userRequest.getPassword(), userRequest.getRole());
    }

}
