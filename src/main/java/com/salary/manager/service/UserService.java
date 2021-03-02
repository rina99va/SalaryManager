package com.salary.manager.service;

import com.salary.manager.domain.model.UserModel;
import com.salary.manager.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${user.notfound}")
    private String message;

    @Value(("${user.illegal.state}"))
    private String userState;

    private boolean isUserValid(final String name, final String password) {
        final List<UserModel> byName = userRepository.findByName(name);
        if (byName.isEmpty()) {
            throw new UsernameNotFoundException(String.format(message, name));
        }

        if (byName.size() > 1) {
            throw new IllegalStateException(String.format(userState, name));
        }

        return byName.get(0).getPassword().equals(password);
    }

    public String generateToken(final String name, final String password) {
        if (isUserValid(name, password)) {
            return passwordEncoder.encode(password);
        } else {
            throw new IllegalStateException("User invalid");
        }
    }

    public void createUser(final String name, final String password, final String role) {
        final UserModel userModel = new UserModel();
        userModel.setId(UUID.randomUUID().toString());
        userModel.setName(name);
        userModel.setPassword(passwordEncoder.encode(password));
        userModel.setRole(role);
        userRepository.save(userModel);
    }
}
