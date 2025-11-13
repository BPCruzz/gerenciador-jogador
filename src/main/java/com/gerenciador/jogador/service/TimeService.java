package com.gerenciador.jogador.service;

import com.gerenciador.jogador.model.Jogador;
import com.gerenciador.jogador.model.Time;
import com.gerenciador.jogador.repository.TimeRepository;
import com.gerenciador.jogador.repository.JogadorRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TimeService {

    private final TimeRepository timeRepository;
    private final JogadorRepository jogadorRepository;

    //Injeção de dependências.
    public TimeService(TimeRepository timeRepository, JogadorRepository jogadorRepository) {
        this.timeRepository = timeRepository;
        this.jogadorRepository = jogadorRepository;
    }

    /**
     * Busca TODOS os Times do BANCO DE DADOS.
     */
    public List<Time> listarTodos() {
        return timeRepository.findAll();
    }

    /**
     * Cria um novo time no BANCO DE DADOS.
     */
    public Time criarTime(Time novoTime) {
        return timeRepository.save(novoTime);
    }

    public void deletarTime(Long id) {


        // Busca jogadores que pertencem a este time
        List<Jogador> jogadoresDoTime = jogadorRepository.findByTimeId(id);

        if (!jogadoresDoTime.isEmpty()) {
            throw new RuntimeException("Não é possível excluir um time que possui jogadores cadastrados.");
        } else {
            // Se a lista ESTÁ vazia, é seguro deletar.
            timeRepository.deleteById(id);
        }
    }

    public Time getTimePorId(Long id) {
        // findById retorna um "Optional" (caixa)
        // .orElseThrow() abre a caixa ou lança um erro se estiver vazia
        return timeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Time não encontrado com ID: " + id));
    }

    /**
     * Atualiza um time existente no BANCO DE DADOS.
     */
    public Time atualizarTime(Long id, Time dadosNovos) {
        // Busca o time que já existe no banco
        Time timeExistente = getTimePorId(id); // Reutiliza o método que acabamos de criar

        // Atualiza os campos do time existente com os dados novos
        timeExistente.setNome(dadosNovos.getNome());
        timeExistente.setNomeEstadio(dadosNovos.getNomeEstadio());

        // Salva o time
        return timeRepository.save(timeExistente);
    }


}
