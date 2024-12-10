package com.api.Literalura.dto;

import java.util.List;

import com.api.Literalura.models.Idiomas;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroDTO(@JsonAlias("id") Long id, 
                       @JsonAlias("title") String titulo, 
                       @JsonAlias("authors") List<AutorDTO> id_autor, 
                       @JsonAlias("languages") List<Idiomas> idiomas, 
                       @JsonAlias("download_count") Integer numero_de_downloads) {
    
}
