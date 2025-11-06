package com.gerenciador.jogador.model;

import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor



@Entity
@Table(name = "jogador")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int numeroCamisa;

    @Enumerated(EnumType.STRING) // Salva ENUM como texto
    private Posicao  posicao;

    @ManyToOne // Muitos Jogadores podem pertencer a um time
    @JoinColumn(name = "time_id") // Qual será a Chave Estrangeira
    private Time time;

}
