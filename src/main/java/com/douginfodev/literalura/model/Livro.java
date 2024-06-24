package com.douginfodev.literalura.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    
    private Integer autor_id;

    private String idioma;

    @Column(unique = true)
    private Integer isbn;

    private Integer numeroDownloads;

   // @OneToMany(mappedBy = "livro")
   // private List<Autor> autores = new ArrayList<>();


    //private List<Autor> autor = new ArrayList<>();

    public Livro(){}

    public Livro(String Titulo, Integer Autor, String Idioma,Integer Isbn, Integer NumeroDownloads) {
        this.titulo = Titulo;
        this.autor_id = Autor;
        this.idioma = Idioma;
        this.isbn = Isbn;
        this.numeroDownloads = NumeroDownloads;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAutor() {
        return autor_id;
    }

    public void setAutor(Integer autor) {
        this.autor_id = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getIsbn() {
        return isbn;
    }


    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public Integer getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(Integer numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    @Override
    public String toString() {
        String aux_autorid = Integer.toString(autor_id);
        return  "ID: "+ id + "\n"+
                "TITULO: " + titulo + "\n"+
                "AUTOR_ID: " + aux_autorid  + '\'' + "\n"+
                "IDIOMA: " + idioma + "\n" +
                "Nº DE DOWNLOADS: " + numeroDownloads+"\n"+
                "----------------------------------"+"\n";
    }
}