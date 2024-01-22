package com.example.simplespringbootapplication;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class Interceptor {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.example.simplespringbootapplication.*.*(..)) && args(number, ..)")
    public void before(JoinPoint joinPoint, String number) {
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException("input is not a valid number");
        }
    }

    private boolean isValidNumber(String number) {
        for (int i = 0; i < number.length(); ++i) {
            char c = number.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return number.charAt(0) != '0';
    }

}
