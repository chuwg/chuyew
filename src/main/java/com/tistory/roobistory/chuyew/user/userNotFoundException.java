package com.tistory.roobistory.chuyew.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 2XX -> OK
// 4XX -> client
// 5XX -> server
@ResponseStatus(HttpStatus.NOT_FOUND)
public class userNotFoundException extends RuntimeException {
    public userNotFoundException(String message) {
        super(message);
    }
}
