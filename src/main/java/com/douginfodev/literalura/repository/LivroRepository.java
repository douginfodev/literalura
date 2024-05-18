package com.douginfodev.literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douginfodev.literalura.model.Livro;

public interface LivroRepository extends JpaRepository<Livro,Integer> {

}
