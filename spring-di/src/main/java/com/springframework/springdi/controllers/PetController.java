package com.springframework.springdi.controllers;

import com.springframework.springdi.services.PetService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PetController {
    private PetService petService;

    public PetController(@Qualifier("petService") PetService petService) {
        this.petService = petService;
    }

    public String getPetType(){
        return petService.getPetType();
    }

}
