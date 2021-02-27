package com.ares.reto.simulador.model.service;

import com.ares.reto.simulador.model.entity.Simulation;
import com.ares.reto.simulador.model.entity.SimulationResponse;

public interface ISimulationService {

    public SimulationResponse calculateSimulation(Simulation simulation);
    public Boolean validateClient(String dni, String card);
}
