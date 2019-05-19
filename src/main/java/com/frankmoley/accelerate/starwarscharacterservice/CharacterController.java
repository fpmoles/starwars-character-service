package com.frankmoley.accelerate.starwarscharacterservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterDAO characterDAO;

    @Autowired
    public CharacterController(CharacterDAO characterDAO){
        super();
        this.characterDAO = characterDAO;
    }

    @GetMapping
    public List<SWCharacter> getAllCharacters(){
        return this.characterDAO.getAll();
    }
}
