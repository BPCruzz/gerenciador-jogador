package com.gerenciador.jogador.service;
import com.gerenciador.jogador.model.Jogador;
import com.gerenciador.jogador.model.Posicao;
import com.gerenciador.jogador.model.Time;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/*
Só lembrando que essa classe é responsável pelas regras de negócio.
 */

@Service
public class JogadorService {
    List<Jogador> jogadores = new ArrayList<>();
    List<Time> times = new ArrayList<>();

    /*
    Classe teste para adicionar jogador
     */


    public JogadorService(){
        Time time = new Time(1L, "Cruzeiro", "Mineirão");
        times.add(time);
        Jogador j1 = new Jogador(1L, "Bryan", 10, Posicao.ATACANTE, times.getFirst());
        jogadores.add(j1);
    }

    /*
    Retornar jogadores listados
     */


    public Jogador criarJogador(Jogador novoJogador) {
        // Simula o "auto_increment" do banco de dados.
        long proximoId = jogadores.size() + 1L;

        novoJogador.setId(proximoId);

        //Pegando o primeiro time por referencia()
        novoJogador.setTime(times.getFirst());

        // Adiciona na lista
        this.jogadores.add(novoJogador);

        return novoJogador;
    }










    public List<Jogador> listarTodos() {
        return this.jogadores;
    }







}
