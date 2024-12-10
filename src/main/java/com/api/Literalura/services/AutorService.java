package com.api.Literalura.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.Literalura.models.Autor;
import com.api.Literalura.repository.AutorRepository;


@Service
public class AutorService {
    
    @Autowired
    private AutorRepository autorRepository;

    public void listarAutores() {
        List<Autor> autores = autorRepository.findAll();

        autores.stream()
                .forEach(a -> {
                    System.out.println(a.getName());
                });   
                
    }

    public void listarAutoresVivosEmUmDeterminadoAno(Integer ano) {
    
        List<Autor> autores = autorRepository.findAll();

        List<Autor> autoresVivos = autores.stream()
                .filter(autor -> autor.getAnoFalecimento() == null || ( autor.getAnoFalecimento() > ano && autor.getAnoNascimento() <= ano))
                .collect(Collectors.toList());

        if (autoresVivos.isEmpty()) {
            System.out.println("Nenhum autor vivo encontrado");
        } else {
            autoresVivos.forEach(a -> {
                System.out.println(a.getName());
            });
        }
    }
}
