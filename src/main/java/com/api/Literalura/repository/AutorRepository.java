package com.api.Literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.Literalura.models.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    
}
