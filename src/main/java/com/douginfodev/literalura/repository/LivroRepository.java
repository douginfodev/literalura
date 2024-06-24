package com.douginfodev.literalura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douginfodev.literalura.model.Livro;

public interface LivroRepository extends JpaRepository<Livro,Integer> {
   List<Livro> findByidiomaContainingIgnoreCase(String idioma);
}
