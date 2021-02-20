package com.springframework.springdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("CAT")
@Service("petService")
public class CatPetService implements PetService {
    @Override
    public String getPetType() {
        return "Cats are the best";
    }
}
