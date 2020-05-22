package com.alevel.HotelBooking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No hotel found")
public class HotelNotFoundException extends RuntimeException{
}
