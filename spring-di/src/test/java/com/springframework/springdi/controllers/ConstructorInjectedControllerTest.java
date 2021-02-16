package com.springframework.springdi.controllers;

import com.springframework.springdi.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructorInjectedControllerTest {
    ConstructorInjectedController constructorInjectedController;

    @BeforeEach
    void setUp() {
        constructorInjectedController = new ConstructorInjectedController(new GreetingServiceImpl());

    }

    @Test
    void getGreeting() {
        System.out.println(constructorInjectedController.getGreeting());
    }
}