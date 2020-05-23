package com.alevel.HotelBooking.security;

import com.alevel.HotelBooking.entities.User;
import com.alevel.HotelBooking.security.jwt.JwtUser;
import com.alevel.HotelBooking.security.jwt.JwtUserFactory;
import com.alevel.HotelBooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username with username: " + username + " not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);

        return jwtUser;
    }
}
