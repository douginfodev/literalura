package com.douginfodev.literalura.view;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.douginfodev.literalura.dto.LivrariaDTO;
import com.douginfodev.literalura.dto.LivroDTO;
import com.douginfodev.literalura.model.Autor;
import com.douginfodev.literalura.model.Livro;
import com.douginfodev.literalura.repository.AutorRepository;
import com.douginfodev.literalura.repository.LivroRepository;
import com.douginfodev.literalura.service.ApiGutendex;
import com.douginfodev.literalura.service.DataConvert;


public class UserInterface {
    ApiGutendex consumirAPI = new ApiGutendex();
    DataConvert convertjson = new DataConvert();
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
                System.out.println("DIGITE O TITULO DO LIVRO");
                scanner.nextLine();
                var tituloLivro = scanner.nextLine();
                
                SelectLivroFromAPI(tituloLivro);
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
                Integer anoSelected = scanner.nextInt();
                
                if (anoSelected <= 0){
                    System.out.println("ANO INVÁLIDO");
                }else{
                    SelectAutorVivos(anoSelected);
                }
            }

            if (menuNumber == 5) {
                System.out.println("1 = PORTUGUES");
                System.out.println("2 = INGLES");
                System.out.println("SELECIONE O IDIOMA:");
                int idiomaSelected = scanner.nextInt();
                
                if (idiomaSelected >= 1 || idiomaSelected <= 2 ) {
                    SelectIdiomaByName(idiomaSelected);
                }else{
                    System.out.println("IDIOMA SELECIONADO INVÁLIDO"); 
                }   
            }
        }
    }

    private void InsertLivro(LivroDTO livroDados) {
        
        Optional<Livro> verificarLivro = repository.findBytituloEqualsIgnoreCase(livroDados.titulo().toString());
       
        if (verificarLivro.isEmpty()){
        
            Livro livro = new Livro(livroDados);
       
            try {
                repository.save(livro);
                System.out.println(livroDados.titulo().toString()+" inserido com sucesso!");
                System.out.println("----------------------------------");
            }catch (Exception e) {
               System.out.println("ERROOO :" + e.getMessage());
            }
        }else{
            System.out.println("LIVRO JÁ PESQUISADO / CADASTRADO");   
        }    

    }

    private void InsertAutor(Integer autorid, String nome, Integer dtnascimento, Integer dtfalecimento) {
        Autor autor = new Autor(autorid,nome,dtnascimento,dtfalecimento);

        try {
            repositoryautor.save(autor);
            System.out.println(autor.getNome()+" inserido com sucesso!");
            System.out.println("----------------------------------");
    
        } catch (Exception e) {
            System.out.println("ERROOO :" + e.getMessage());
        }

    }

    private void SelectLivroFromAPI(String livrotitulo) {
        String datajson = consumirAPI.obterDados(URL+livrotitulo.replace(" ","%20").toLowerCase());  
               
        var books = convertjson.obterDados(datajson,LivrariaDTO.class);
       
        Optional<LivroDTO> livroSelecionado = books.livros().stream()
            .findFirst(); 

        if (livroSelecionado.isPresent()){
            LivroDTO livrodados = livroSelecionado.get();
            
            InsertLivro(livrodados);
            InsertAutor(livrodados.id(),livrodados.autores().get(0).nome().toString(),livrodados.autores().get(0).anonascimento(),livrodados.autores().get(0).anofalecimento());
        }
        else{
          System.out.println("NENHUM LIVRO ENCONTRADO");  
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

    private void SelectAutorVivos(Integer anofalecimento) {
          List<Autor> autorData = repositoryautor.findByanofalecimentoLessThan(anofalecimento);
  
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
