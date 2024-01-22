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
    public ResponseEntity<?> hello(@PathVariable String number) {
        int num = Integer.valueOf(number);
        return new ResponseEntity<>("Result is " + fizzBuzz(num), HttpStatus.OK);
    }

    private String fizzBuzz(int num) {
        if (num % 15 == 0) {
            return "FizzBuzz";
        } else if (num % 5 == 0) {
            return "Fizz";
        } else if (num % 3 == 0) {
            return "Buzz";
        }
        return "None";
    }

}
