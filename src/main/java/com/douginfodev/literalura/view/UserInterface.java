package com.douginfodev.literalura.view;

import java.util.List;
import java.util.Scanner;

import com.douginfodev.literalura.model.Autor;
import com.douginfodev.literalura.model.Livro;
import com.douginfodev.literalura.repository.AutorRepository;
import com.douginfodev.literalura.repository.LivroRepository;

public class UserInterface {
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
            System.out.println("4 = LISTAR AUTORES / ANO");
            System.out.println("5 = LISTAR LIVROS / IDIOMA");
            System.out.println("6 = SAIR");
            System.out.println("SELECIONE UMA OPÇÃO");
            menuNumber = scanner.nextInt();

            if (menuNumber == 1){
              InsertLivro();
              System.out.println("ENTREI NO :" + menuNumber);
            }

            if (menuNumber == 2){
                SelectAllLivro();
                System.out.println("ENTREI NO SELECT :" + menuNumber);
            }

            if (menuNumber == 3){
                SelectAllAutor();
                System.out.println("ENTREI NO SELECT :" + menuNumber);
            }
        }
    }

    private void InsertLivro(){
        Livro livro = new Livro("Livro Teste 2",2,"PT-BR",2222,"2024");  
        
        try {
            repository.save(livro);
        } catch (Exception e) {
            System.out.println("ERROOO :" + e.getMessage());
        }  
        
    }

    private void InsertAutor(){
        Autor autor = new Autor("Autor Teste");  
        
        try {
            repositoryautor.save(autor);
        } catch (Exception e) {
            System.out.println("ERROOO :" + e.getMessage());
        }  
        
    }

    private void SelectAllLivro(){
        
        try {
            List<Livro> livros = repository.findAll(); 
            System.out.println("====== LISTA DE LIVROS =======");
            livros.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("ERROOO :" + e.getMessage());
        }  
        
    }

    private void SelectAllAutor(){
        
        try {
            List<Autor> autores = repositoryautor.findAll(); 
            System.out.println("====== LISTA DE AUTORES =======");
            autores.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("ERROOO :" + e.getMessage());
        }  
        
    }


}
