package com.lsantos.base.services;

import com.lsantos.base.exceptions.UserAlreadyExistExceptio;
import com.lsantos.base.models.User;
import com.lsantos.base.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterService {
    
    @Autowired
    private UserRepository repository;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;


    public User saveUser(User user) throws UserAlreadyExistExceptio {
        
        if (repository.findByEmail(user.getEmail()) != null) {
            throw new UserAlreadyExistExceptio("Já existe um usuário com este email");
        }
        
        user.setEnabled(true);
        user.setRole("user");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
        return user;
    }

}
