package com.gerenciador.jogador.controller;

// Imports
import com.gerenciador.jogador.model.Jogador;
import com.gerenciador.jogador.service.JogadorService; // Importamos o Service!
import org.springframework.web.bind.annotation.*;

import java.util.List; // Vamos retornar uma Lista

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    // Criamos um campo para o Service
    private final JogadorService jogadorService;

    /* Criamos um construtor que recebe o Service.
     O Spring vai ver esse construtor e automaticamente,
     vai injetar o JogadorService que ele criou aqui.
    */

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    // Criamos nosso novo método para listar

    @GetMapping // Mapeia para a raiz da controller: /jogadores
    public List<Jogador> listarTodosJogadores() {
        // Chamamos o Service para pegar os dados!
        return jogadorService.listarTodos();
    }

    @PostMapping // Mapeia para requisições POST em /jogadores
    public Jogador criarJogador(@RequestBody Jogador novoJogador) { // (2)
        // (Chama o service para criar
        return jogadorService.criarJogador(novoJogador);
    }


}
