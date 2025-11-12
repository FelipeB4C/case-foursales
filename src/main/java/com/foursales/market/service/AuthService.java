package com.foursales.market.service;

import com.foursales.market.model.User;
import com.foursales.market.model.UserLogin;
import com.foursales.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserLogin(user.getId(), user.getUsername(), user.getPassword(), user.getRole());
    }

}
