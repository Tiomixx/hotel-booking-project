package com.alevel.HotelBooking.security.jwt;

import com.alevel.HotelBooking.entities.Role;
import com.alevel.HotelBooking.entities.User;
import io.jsonwebtoken.Jwt;
import liquibase.pro.packaged.J;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
                mapToGrantedAuthorities(new ArrayList<>(user.getRoles())),
                true);
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles){
        return userRoles.stream()
                .map(role ->
                        new SimpleGrantedAuthority(role.getRoleName())
                ).collect(Collectors.toList());
    }
}
