package com.douginfodev.literalura.view;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.douginfodev.literalura.model.Autor;
import com.douginfodev.literalura.model.Livro;
import com.douginfodev.literalura.repository.AutorRepository;
import com.douginfodev.literalura.repository.LivroRepository;
import com.douginfodev.literalura.service.ApiGutendex;



public class UserInterface {
    String URL = "https://gutendex.com/books/?search=";
    Scanner scanner = new Scanner(System.in);
    int menuNumber = 0;

    private LivroRepository repository;
    private AutorRepository repositoryautor;

    public UserInterface(LivroRepository repository, AutorRepository repositoryautor) {
        this.repository = repository;
        this.repositoryautor = repositoryautor;
    }

    public void printMenu() {

        while (menuNumber != 6) {
            System.out.println("===========================");
            System.out.println("    LITERALURA 1.0    ");
            System.out.println("===========================");
            System.out.println("         MENU              ");
            System.out.println("1 = BUSCAR LIVROS / TITULO");
            System.out.println("2 = LISTAR LIVROS REGISTRADO");
            System.out.println("3 = LISTAR AUTORES REGISTRADOS ");
            System.out.println("4 = LISTAR AUTORES VIVOS / ANO");
            System.out.println("5 = LISTAR LIVROS / IDIOMA");
            System.out.println("6 = SAIR");
            System.out.println("SELECIONE UMA OPÇÃO");
            menuNumber = scanner.nextInt();

            if (menuNumber == 1) {
                ApiGutendex consumirAPI = new ApiGutendex();
                System.out.println("DIGITE O TITULO DO LIVRO");
                var tituloLivro = scanner.nextLine();
                System.out.println(tituloLivro);  
                String abc = consumirAPI.obterDados(URL+tituloLivro);  
                //InsertLivro();
                System.out.println(abc);
            }

            if (menuNumber == 2) {
                System.out.println("LIVROS REGISTRADOS");
                SelectAllLivro();
            }

            if (menuNumber == 3) {
                System.out.println("AUTORES REGISTRADOS");
                SelectAllAutor();
            }

            if (menuNumber == 4) {
                System.out.println("DIGITE O ANO DE FALECIMENTO:");
                int anoSelected = scanner.nextInt();
                SelectAutorVivos(anoSelected);
                System.out.println("ENTREI NO SELECT :" + menuNumber);
            }

            if (menuNumber == 5) {
                System.out.println("1 = PORTUGUES");
                System.out.println("2 = INGLES");
                System.out.println("SELECIONE O IDIOMA:");
                int idiomaSelected = scanner.nextInt();
                SelectIdiomaByName(idiomaSelected);
           }
        }
    }

    private void InsertLivro() {
        Livro livro = new Livro("Livro Teste 2", 2, "PT-BR", 2222, 2024);

        try {
            repository.save(livro);
        } catch (Exception e) {
            System.out.println("ERROOO :" + e.getMessage());
        }

    }

    private void InsertAutor() {
        Autor autor = new Autor("Autor Teste");

        try {
            repositoryautor.save(autor);
        } catch (Exception e) {
            System.out.println("ERROOO :" + e.getMessage());
        }

    }

    private void SelectAllLivro() {

        try {
            List<Livro> livros = repository.findAll();
          
           if (livros.size() > 0){
            livros.forEach(System.out::println);
           }else{
            System.out.println("====== NENHUM LIVRO REGISTRADO =======");
           }

        } catch (Exception e) {
            System.out.println("ERROOO :" + e.getMessage());
        }

    }

    private void SelectAllAutor() {

        try {
            List<Autor> autores = repositoryautor.findAll();
            
            if (autores.size() > 0){
             autores.forEach(System.out::println);             
            }else{
              System.out.println("====== NENHUM AUTOR REGISTRADO =======");
            } 
        } catch (Exception e) {
            System.out.println("ERROOO :" + e.getMessage());
        }

    }

    private void SelectAutorVivos(int anoSelected) {
        var ano = String.valueOf(anoSelected);
        
        //var ano = "2020";//String.valueOf(anoSelected);
        List<Autor> autorData = repositoryautor.findByanoFalecimentoGreaterThanEqual(ano);
  
        if (!autorData.isEmpty()) {
             System.out.println(autorData);
             System.out.println("TOTAL DE AUTORES FALECIDOS: "+autorData.size());
          } else {
             System.out.println("====================================");
             System.out.println("NENHUM AUTOR FALECIDO");
             System.out.println("====================================");
         }
    }

    private void SelectIdiomaByName(int idiomaSelect) {
        var idioma = "";

        if (idiomaSelect == 1)
            idioma = "br";
        else
            idioma = "en";

        List<Livro> livroIdioma = repository.findByidiomaContainingIgnoreCase(idioma);
  
       if (!livroIdioma.isEmpty()) {
            System.out.println(livroIdioma);
            System.out.println("TOTAL DE LIVROS: "+livroIdioma.size());
         } else {
            System.out.println("====================================");
            System.out.println("NENHUM LIVRO ENCONTRADO NESTE IDIOMA");
            System.out.println("====================================");
        }
    }

}
