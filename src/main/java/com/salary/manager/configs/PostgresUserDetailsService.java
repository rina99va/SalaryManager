package com.salary.manager.configs;

import com.salary.manager.domain.model.UserModel;
import com.salary.manager.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class PostgresUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Value("${user.notfound}")
    private String message;

    @Value(("${user.illegal.state}"))
    private String userState;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        final List<UserModel> byName = userRepository.findByName(s);

        if (byName.isEmpty()) {
            throw new UsernameNotFoundException(String.format(message, s));
        }

        if (byName.size() > 1) {
            throw new IllegalStateException(String.format(userState, s));
        }

        return new User(byName.get(0).getName(), byName.get(0).getPassword(), Collections.singleton(Role.findRoleByRoleName(byName.get(0).getRole())));
    }
}
