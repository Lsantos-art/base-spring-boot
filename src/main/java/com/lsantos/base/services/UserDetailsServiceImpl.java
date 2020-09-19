package com.lsantos.base.services;

import com.lsantos.base.models.User;
import com.lsantos.base.repository.UserRepository;
import com.lsantos.base.security.MyUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
     
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
         
        if (user == null) {
            throw new UsernameNotFoundException("Usuario não encontrado...");
        }
         
        return new MyUserDetails(user);
    }
    
}
