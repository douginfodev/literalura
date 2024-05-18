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
    private String autor;
    private String idioma;

    @Column(unique = true)
    private Integer isbn;

    private String anoLancamento;

    public Livro(){}

    public Livro(String Titulo, String Autor, String Idioma,Integer Isbn, String AnoLancamento) {
        this.titulo = Titulo;
        this.autor = Autor;
        this.idioma = Idioma;
        this.isbn = Isbn;
        this.anoLancamento = AnoLancamento;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }


    public Integer getIsbn() {
        return isbn;
    }


    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "titulo=" + titulo +
                ", autor='" + autor + '\'' +
                ", idioma=" + idioma +
                ", isbn=" + isbn +
                ", Ano Lancamento=" + anoLancamento;
    }
}