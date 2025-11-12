package com.gerenciador.jogador.controller;

// Imports
import com.gerenciador.jogador.model.Jogador;
import com.gerenciador.jogador.service.JogadorService; // Importamos o Service!
import org.springframework.web.bind.annotation.*;


import java.util.List; // Vamos retornar uma Lista

@RestController
@CrossOrigin(origins = "*")
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
    public Jogador criarJogador(@RequestBody Jogador novoJogador) {
        // (Chama o service para criar
        return jogadorService.criarJogador(novoJogador);
    }

    // /jogadores/time/ e um ID dinâmico
    @GetMapping("/time/{timeId}")
    public List<Jogador> getJogadoresPorTime(@PathVariable Long timeId) {

        // Chama o service com o ID recebido da URL
        return jogadorService.listarJogadoresPorTime(timeId);
    }

    @DeleteMapping("/{id}")
    public void deletarJogador(@PathVariable Long id) {

        // Chama o service para deletar
        jogadorService.deletarJogador(id);
    }

    //
    @GetMapping("/{id}")
    public Jogador getJogadorPorId(@PathVariable Long id) {
        return jogadorService.getJogadorPorId(id);
    }

    @PutMapping("/{id}")
    public Jogador atualizarJogador(@PathVariable Long id, @RequestBody Jogador dadosNovos) {
        // Chama o service passando o ID da URL e os dados do formulário
        return jogadorService.atualizarJogador(id, dadosNovos);
    }


}
