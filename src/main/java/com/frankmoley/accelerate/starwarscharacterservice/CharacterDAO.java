package com.frankmoley.accelerate.starwarscharacterservice;

import java.util.ArrayList;
import java.util.List;

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
    private final PreparedStatement getAllStatement;

    @Autowired
    public CharacterDAO(DseSession dseSession){
        super();
        this.session = dseSession;
        this.getAllStatement = session.prepare(GET_ALL);
    }

    public List<SWCharacter> getAll(){
        List<SWCharacter> characters = new ArrayList<>();
        ResultSet resultSet = session.execute(getAllStatement.getQuery());
        for(Row row:resultSet){
            SWCharacter character = new SWCharacter(
                    row.getString("character_id"),
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
}
