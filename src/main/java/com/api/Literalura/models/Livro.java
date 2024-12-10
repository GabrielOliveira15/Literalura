package com.api.Literalura.models;

import java.util.List;

import com.api.Literalura.dto.LivroDTO;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name = "livros_autores",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private List<Autor> autores;

    @Enumerated(EnumType.STRING)
    private List<Idiomas> idiomas;

    private Integer numero_de_downloads;

    public Livro() {}

    public Livro(LivroDTO livroDTO) {
        this.titulo = livroDTO.titulo();
        this.autores = livroDTO.id_autor().stream().map(Autor::new).toList();
        this.idiomas = livroDTO.idiomas();
        this.numero_de_downloads = livroDTO.numero_de_downloads();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Idiomas> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<Idiomas> idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getNumero_de_downloads() {
        return numero_de_downloads;
    }

    public void setNumero_de_downloads(Integer numero_de_downloads) {
        this.numero_de_downloads = numero_de_downloads;
    }

    @Override
    public String toString() {
        return "Livro [id=" + id + ", titulo=" + titulo + "]";
    }
} 
    

