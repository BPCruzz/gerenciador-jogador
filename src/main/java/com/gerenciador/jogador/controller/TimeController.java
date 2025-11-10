package com.gerenciador.jogador.controller;

import com.gerenciador.jogador.model.Time;
import com.gerenciador.jogador.service.TimeService;
import org.springframework.web.bind.annotation.*; // Importando tudo

import java.util.List;

@RestController
@RequestMapping("/times") // Endpoint base é /times
@CrossOrigin(origins = "*") // Permite acesso de qualquer frontend
public class TimeController {

    // Injetando o TimeService
    private final TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    // Endpoint para CRIAR um time (POST /times)
    @PostMapping
    public Time criarTime(@RequestBody Time novoTime) {
        return timeService.criarTime(novoTime);
    }

    // Endpoint para LISTAR todos os times (GET /times)
    @GetMapping
    public List<Time> listarTodosTimes() {
        return timeService.listarTodos();
    }
}
