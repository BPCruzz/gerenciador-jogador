package com.gerenciador.jogador.service;

import com.gerenciador.jogador.model.Jogador;
import com.gerenciador.jogador.model.Time;
import com.gerenciador.jogador.repository.JogadorRepository; // (1) Importamos os repositórios
import com.gerenciador.jogador.repository.TimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

        // Pegamos o ID do time que o usuário escolheu no formulário
        Long idDoTime = novoJogador.getTime().getId();

        // Buscamos esse time no banco de dados
        Time timeDoJogador = timeRepository.findById(idDoTime)
                .orElseThrow(() -> new RuntimeException("Time com ID " + idDoTime + " não encontrado!"));

        // Setamos o objeto Time "completo" no jogador
        novoJogador.setTime(timeDoJogador);

        // Salvamos o jogador completo no BANCO DE DADOS
        return jogadorRepository.save(novoJogador);
    }

    /**
     * Busca TODOS os jogadores de um TIME específico.
     */
    public List<Jogador> listarJogadoresPorTime(Long timeId) {
        return jogadorRepository.findByTimeId(timeId);
    }

    /**
     * Deleta um jogador do BANCO DE DADOS pelo ID.
     */
    public void deletarJogador(Long id) {
        // O JpaRepository já nos dá esse método de graça.
        jogadorRepository.deleteById(id);
    }

    /**
     * Busca UM jogador pelo seu ID. Usar para edição de jogadores.
     */
    public Jogador getJogadorPorId(Long id) {
        return jogadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado com ID: " + id));
    }

    /**
     * Atualiza um jogador existente no BANCO DE DADOS.
     */
    public Jogador atualizarJogador(Long id, Jogador dadosNovos) {
        // Busca o jogador que já existe no banco
        Jogador jogadorExistente = getJogadorPorId(id); // Reutiliza o método que acabamos de criar

        // Atualiza os campos do jogador existente com os dados novos
        jogadorExistente.setNome(dadosNovos.getNome());
        jogadorExistente.setNumeroCamisa(dadosNovos.getNumeroCamisa());
        jogadorExistente.setPosicao(dadosNovos.getPosicao());

        // Lógica para atualizar o time (igual à que fizemos no criarJogador)
        Long idDoTime = dadosNovos.getTime().getId();
        Time timeDoJogador = timeRepository.findById(idDoTime)
                .orElseThrow(() -> new RuntimeException("Time com ID " + idDoTime + " não encontrado!"));
        jogadorExistente.setTime(timeDoJogador);

        // Salva o jogador ATUALIZADO. O JPA é inteligente:
        // Como o 'jogadorExistente' já TEM um ID, ele faz um UPDATE, não um INSERT.
        return jogadorRepository.save(jogadorExistente);
    }

}