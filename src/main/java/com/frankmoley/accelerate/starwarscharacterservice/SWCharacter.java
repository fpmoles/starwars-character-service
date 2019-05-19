package com.frankmoley.accelerate.starwarscharacterservice;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SWCharacter {
    private UUID id;
    private String name;
    private String gender;
    private String hairColor;
    private int height;
    private String homeWorld;
    private float mass;
    private String skinColor;
}


