package com.gerenciador.jogador.service;

import com.gerenciador.jogador.model.Jogador;
import com.gerenciador.jogador.model.Time;
import com.gerenciador.jogador.repository.TimeRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TimeService {

    private final TimeRepository timeRepository;

    //Injeção de dependências.
    public TimeService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
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



}
