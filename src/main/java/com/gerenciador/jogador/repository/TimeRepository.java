package com.gerenciador.jogador.repository;

import com.gerenciador.jogador.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Diz ao Spring que esta é uma interface de Repositório
public interface TimeRepository extends JpaRepository<Time, Long> {

}
