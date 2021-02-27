package com.ares.reto.simulador.model.dao;

import com.ares.reto.simulador.model.entity.Simulation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISimulationRepository extends JpaRepository<Simulation, Long> {
}
