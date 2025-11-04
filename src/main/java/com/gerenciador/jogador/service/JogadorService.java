package com.gerenciador.jogador.service;
import com.gerenciador.jogador.model.Jogador;
import com.gerenciador.jogador.model.Posicao;
import com.gerenciador.jogador.model.Time;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JogadorService {
    List<Jogador> jogadores = new ArrayList<>();

    /*
    Classe teste para adicionar jogador
     */
    public JogadorService(){
        Time time = new Time(1L, "Cruzeiro", "Mineirão");
        Jogador j1 = new Jogador(1L, "Bryan", 10, Posicao.ATACANTE, time);
        jogadores.add(j1);
    }

    /*
    Retornar jogadores listados
     */
    public List<Jogador> listarTodos() {
        return this.jogadores;
    }







}
