package com.douginfodev.literalura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douginfodev.literalura.model.Autor;


public interface AutorRepository extends JpaRepository<Autor,Integer> {
  List<Autor> findByanofalecimentoLessThan(Integer anofalecimento);
}
