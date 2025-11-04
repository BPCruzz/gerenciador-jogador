package com.gerenciador.jogador.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Jogador {

    private Long id;
    private String nome;
    private int numeroCamisa;
    private Posicao  posicao;
    private Time time;

}
