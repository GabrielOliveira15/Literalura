package com.api.Literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.Literalura.models.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

} 
