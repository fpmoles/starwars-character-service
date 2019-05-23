package com.frankmoley.accelerate.starwarscharacterservice;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterDAO characterDAO;

    public CharacterController(CharacterDAO characterDAO){
        super();
        this.characterDAO = characterDAO;
    }

    @GetMapping
    public List<SWCharacter> getAllCharacters(){
        return this.characterDAO.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UUID createCharacter(@RequestBody SWCharacter character){
        return this.characterDAO.addCharacter(character);

    }
}
