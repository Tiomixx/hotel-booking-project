package com.alevel.HotelBooking.security.jwt;

import com.alevel.HotelBooking.entities.User;
import io.jsonwebtoken.Jwt;
import liquibase.pro.packaged.J;

public final class JwtUserFactory {
    public JwtUserFactory() {
    }

    public static JwtUser create(User user){
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                null,
                true
                );
    }
}
