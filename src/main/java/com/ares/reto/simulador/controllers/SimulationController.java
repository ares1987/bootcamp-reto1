package com.ares.reto.simulador.controllers;

import com.ares.reto.simulador.model.dao.ISimulationRepository;

import com.ares.reto.simulador.model.entity.Simulation;

import com.ares.reto.simulador.model.entity.SimulationResponse;
import com.ares.reto.simulador.model.service.ISimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SimulationController {

     @Autowired
    private ISimulationRepository simulationRepository;
    @Autowired
    private ISimulationService simulationService;

    @Autowired
    private SimulationResponse simulationResponse;

    @PostMapping("/simulation")
    public ResponseEntity<SimulationResponse> simulate(@Valid @RequestBody Simulation simulation) {

        if(!simulationService.validateClient(simulation.getDni(), simulation.getCard())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        };
        return ResponseEntity.ok(simulationService.calculateSimulation(simulation));


    }

    @GetMapping("/listSimulation")
    public List<Simulation> listSimulation(){
        return simulationRepository.findAll();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
