package com.douginfodev.literalura.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

   // @ManyToOne
   // private Livro livro;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Autor(){}

    public Autor(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return  "ID: " + this.id + "\n"+
                "NOME: " + this.nome + "\n"+
                "----------------------------------"+"\n";
    }
}
