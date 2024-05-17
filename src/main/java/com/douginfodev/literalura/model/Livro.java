package com.douginfodev.literalura.model;

public class Livro {
    private Integer id;
    private String titulo;
    private String autor;
    private String idioma;
    private String anoLancamento;

    public Livro(String Titulo, String Autor, String Idioma, String AnoLancamento) {
        this.titulo = Titulo;
        this.autor = Autor;
        this.idioma = Idioma;
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

}
