package com.frankmoley.accelerate.starwarscharacterservice;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.datastax.dse.driver.api.core.DseSession;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CharacterDAO {

    private final DseSession session;
    private final static String GET_ALL = "select * from starwars.character";
    private final static String INSERT = "insert into starwars.character (character_id, name, gender, hair_color, height, home_world, mass, skin_color) VALUES(?,?,?,?,?,?,?,?)";

    private final PreparedStatement getAllStatement;
    private final PreparedStatement insertStatement;

    @Autowired
    public CharacterDAO(DseSession dseSession){
        super();
        this.session = dseSession;
        this.getAllStatement = session.prepare(GET_ALL);
            this.insertStatement = session.prepare(INSERT);
    }

    public List<SWCharacter> getAll(){
        List<SWCharacter> characters = new ArrayList<>();
        ResultSet resultSet = session.execute(getAllStatement.getQuery());
        for(Row row:resultSet){
            SWCharacter character = new SWCharacter(
                    row.getUuid("character_id"),
                    row.getString("name"),
                    row.getString("gender"),
                    row.getString("hair_color"),
                    row.getInt("height"),
                    row.getString("home_world"),
                    row.getFloat("mass"),
                    row.getString("skin_color")
            );
            characters.add(character);
        }
        return characters;
    }

    public UUID addCharacter(SWCharacter character){
        UUID id = UUID.randomUUID();
        session.execute(insertStatement.bind(
             id,
             character.getName(),
             character.getGender(),
             character.getHairColor(),
             character.getHeight(),
             character.getHomeWorld(),
             character.getMass(),
             character.getSkinColor()
        ));
        return id;
    }
}
