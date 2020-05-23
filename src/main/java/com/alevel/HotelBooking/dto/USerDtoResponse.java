package com.alevel.HotelBooking.dto;

import com.alevel.HotelBooking.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class USerDtoResponse {

    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;

    public User toUser(){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        return user;
    }

    public static USerDtoResponse fromUser(User user){
        USerDtoResponse uSerDtoResponse = new USerDtoResponse();
        uSerDtoResponse.setId(user.getId());
        uSerDtoResponse.setUsername(user.getUsername());
        uSerDtoResponse.setFirstName(user.getFirstName());
        uSerDtoResponse.setLastName(user.getLastName());
        uSerDtoResponse.setEmail(user.getEmail());

        return uSerDtoResponse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
