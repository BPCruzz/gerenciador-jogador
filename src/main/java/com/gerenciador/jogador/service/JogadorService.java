package com.gerenciador.jogador.service;

import com.gerenciador.jogador.model.Jogador;
import com.gerenciador.jogador.model.Time;
import com.gerenciador.jogador.repository.JogadorRepository; // (1) Importamos os repositórios
import com.gerenciador.jogador.repository.TimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//CLASSE DE REGRAS DE NEGÓCIOS
@Service
public class JogadorService {

    // Chamamos os repositórios
    private final JogadorRepository jogadorRepository;
    private final TimeRepository timeRepository;

    // Injeção de Dependência via construtor
    public JogadorService(JogadorRepository jogadorRepository, TimeRepository timeRepository) {
        this.jogadorRepository = jogadorRepository;
        this.timeRepository = timeRepository;
    }

    /**
     * Busca TODOS os jogadores do BANCO DE DADOS.
     */
    public List<Jogador> listarTodos() {
        return jogadorRepository.findAll();
    }

    /**
     * Cria um novo jogador no BANCO DE DADOS.
     */
    public Jogador criarJogador(Jogador novoJogador) {

        // Buscamos o time no banco.
        // findById retorna um "Optional" que pode ou não ter um time.
        // .get() pega o time de dentro da caixa.
        Time timePadrao = timeRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Time padrão (ID 1) não encontrado!"));

        // (Definimos o time no jogador
        novoJogador.setTime(timePadrao);


        // Salvamos o jogador no BANCO DE DADOS e retornamos.
        return jogadorRepository.save(novoJogador);
    }
}