package com.gerenciador.jogador.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// (1) Diz ao Spring que esta classe vai controlar rotas web (APIs)
@RestController
// (2) Define o "prefixo" da URL para esta classe.
// Todas as rotas aqui dentro vão começar com /jogadores
@RequestMapping("/jogadores")


public class JogadorController {

    // Mapeia este método para requisições GET
    @GetMapping("/teste")
    public String fazerTeste() {
        return "Teste Inicial";
    }


}
