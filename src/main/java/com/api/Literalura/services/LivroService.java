package com.api.Literalura.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.Literalura.dto.ListagemLivros;
import com.api.Literalura.models.Livro;
import com.api.Literalura.repository.LivroRepository;

@Service
public class LivroService {
    
    @Autowired
    private LivroRepository livroRepository;

    ConverteDados converteDados = new ConverteDados();
    ConsultaAPI consultaAPI = new ConsultaAPI();

    public void buscalivroPeloTitulo (String titulo) {
        
        String json = consultaAPI.buscaAPI(titulo);

        ListagemLivros listagemLivros = converteDados.obterDados(json, ListagemLivros.class);
        listagemLivros.livros().stream()
                .forEach(l -> {
                    Livro livroNovo = new Livro(l);
                    livroRepository.save(livroNovo);
                    System.out.println("\n----- Livro -----");
                    System.out.println("Título: " + l.titulo());
                    System.out.println("Autor: " + l.id_autor().get(0).name());
                    System.out.println("Idioma: " + l.idiomas());
                    System.out.println("Número de downloads: " + l.numero_de_downloads());
                    System.out.println("-----------------");
                });
    }

    public void buscaTodosLivros() {
        List<Livro> livros = livroRepository.findAll();

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado");
        } else {
            livros.forEach(l -> {
                System.out.println(l.getTitulo());
            });
        }
    }

    public void listarLivrosPorIdioma(String idioma) {
        List<Livro> livros = livroRepository.findAll();

        List<Livro> livrosIdioma = livros.stream()
                .filter(livro -> livro.getIdiomas().get(0).equals(idioma))
                .collect(Collectors.toList());

        if (livrosIdioma.isEmpty()) {
            System.out.println("Nenhum livro encontrado");
        } else {
            livrosIdioma.forEach(l -> {
                System.out.println(l.getTitulo());
            });
        }
    }
}
