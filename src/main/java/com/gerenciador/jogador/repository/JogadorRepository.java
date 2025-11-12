package com.gerenciador.jogador.repository;

import com.gerenciador.jogador.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {
    // vai gerar o SQL: "SELECT * FROM jogador WHERE time_id = ?"
    List<Jogador> findByTimeId(Long timeId);
}