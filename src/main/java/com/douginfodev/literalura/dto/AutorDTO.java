package com.douginfodev.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorDTO(@JsonAlias( "name" ) String nome,
                  @JsonAlias("birth_year") Integer anonascimento,
                  @JsonAlias("death_year") Integer anofalecimento){

}
