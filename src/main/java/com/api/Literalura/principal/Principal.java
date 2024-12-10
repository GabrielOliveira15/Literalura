package com.api.Literalura.principal;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.Literalura.services.AutorService;
import com.api.Literalura.services.LivroService;

@Component
public class Principal {

    Scanner scanner = new Scanner(System.in);

    @Autowired
    private LivroService livroService;

    @Autowired
    private AutorService autorService;
    
    public void exibirMenu() {

        Integer opcao = -1;
        String titulo;

        while (opcao !=0) {
            System.out.println("\n===========================================");
            System.out.println("Escolha o número da opção desejada:");
            System.out.println("1 - Buscar livro pelo título");
            System.out.println("2 - Listar livros registrados");
            System.out.println("3 - Listar autores registrados");
            System.out.println("4 - Listar autores vivos em um determinado ano");
            System.out.println("5 - Listar livros de um determinado idioma");
            System.out.println("0 - Sair");
            System.out.println("===========================================");
            opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\n");

            switch (opcao) {
                case 1:
                    System.out.println("Digite o título do livro:");
                    titulo = scanner.nextLine();
                    livroService.buscalivroPeloTitulo(titulo);
                    break;
                case 2:
                    livroService.buscaTodosLivros();
                    break;
                case 3:
                    autorService.listarAutores();
                    break;
                case 4:
                    System.out.println("Digite o ano que deseja buscar: ");
                    Integer ano = scanner.nextInt();
                    scanner.nextLine();
                    autorService.listarAutoresVivosEmUmDeterminadoAno(ano);
                    break;
                case 5:
                    System.out.println("Idiomas disponíveis:");
                    System.out.println("1 - Inglês");
                    System.out.println("2 - Francês");
                    System.out.println("3 - Português");
                    System.out.println("4 - Finlandês");
                    Integer idioma = scanner.nextInt();
                    scanner.nextLine();
                    switch (idioma) {
                        case 1:
                            livroService.listarLivrosPorIdioma("en");
                            break;
                        case 2:
                            livroService.listarLivrosPorIdioma("fr");
                            break;
                        case 3:
                            livroService.listarLivrosPorIdioma("pt");
                            break;
                        case 4:
                            livroService.listarLivrosPorIdioma("fi");
                            break;
                        default:
                            System.out.println("Erro: Opção inválida, tente novamente!");
                            break;
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Erro: Opção inválida, tente novamente!");
                    break;
            }
        }
    }
}