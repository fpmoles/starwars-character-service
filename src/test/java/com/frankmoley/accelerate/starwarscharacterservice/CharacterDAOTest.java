package com.frankmoley.accelerate.starwarscharacterservice;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CharacterDAOTest {

    @Autowired
    private CharacterDAO characterDAO;

    @Test
    public void getAll() {
        List<SWCharacter> characters = this.characterDAO.getAll();
        System.out.println(characters.size());
        characters.forEach(System.out::println);
    }
}