package com.QuantityMeasurementApp.security;

import com.QuantityMeasurementApp.repository.UserRepository;
import com.QuantityMeasurementApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // Spring Security calls this method when someone tries to login
    @Override
    public UserDetails loadUserByUsername(String username) 
            throws UsernameNotFoundException {

        // Find user in database
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User not found: " + username));

        // Convert our User to Spring Security's UserDetails format
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.emptyList()
        );
    }
}
