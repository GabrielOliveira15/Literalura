package com.api.Literalura.models;

import java.util.ArrayList;
import java.util.List;

import com.api.Literalura.dto.AutorDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    private Integer anoNascimento;
    
    private Integer anoFalecimento;
    
    @ManyToMany(mappedBy = "autores", 
                cascade = {
                    CascadeType.PERSIST, 
                    CascadeType.MERGE
                })
    private List<Livro> livros = new ArrayList<>();

    public Autor() {
    }

    public Autor(AutorDTO autorDTO) {
        this.name = autorDTO.name();
        this.anoNascimento = autorDTO.anoNasciemnto();
        this.anoFalecimento = autorDTO.anoFalecimento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(Integer anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public void addLivro(Livro livro) {
        this.livros.add(livro);
        livro.getAutores().add(this); // Adiciona o autor ao livro também
    }

}
