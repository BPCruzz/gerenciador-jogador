package com.gerenciador.jogador.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

/*
Usando o Lombok para gerar todos os métodos
 */

public class Time {
    private Long id;
    private String nome;
    private String nomeEstadio;
}
