package com.gerenciador.jogador.model;

//Imports
import jakarta.persistence.*; //Importamos tudo
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
Usando o Lombok para gerar todos os métodos
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

/*
Preparando classe para ser vista como entidade no banco...
 */

@Entity // Marca como uma tabela no banco
@Table(name = "time") // Informa o nome por boas práticas
public class Time {
    @Id // Chave Primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Incremento d ID
    private Long id;

    private String nome;
    private String nomeEstadio;
}
