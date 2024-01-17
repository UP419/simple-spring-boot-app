package com.example.simplespringbootapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
class HelloController {

    public static void main(String[] args) {
        SpringApplication.run(HelloController.class, args);
    }

    @GetMapping(value = "/{number}")
    public ResponseEntity<?> hello(@PathVariable int number) {
        String result = "none";
        if (number % 15 == 0) {
            result = "fizzbuzz";
        } else if (number % 5 == 0) {
            result = "fizz";
        } else if (number % 3 == 0) {
            result = "buzz";
        }
        return new ResponseEntity<>("Result is , " + result, HttpStatus.OK);
    }

}
