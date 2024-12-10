package com.api.Literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorDTO(@JsonAlias("name") String name, 
                       @JsonAlias("birth_year") Integer anoNasciemnto, 
                       @JsonAlias("death_year") Integer anoFalecimento) {
    
}
