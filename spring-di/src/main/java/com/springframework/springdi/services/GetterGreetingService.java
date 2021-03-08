package com.springframework.springdi.services;

import org.springframework.stereotype.Service;

@Service
public class GetterGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello - I was injected by the getter";
    }
}
