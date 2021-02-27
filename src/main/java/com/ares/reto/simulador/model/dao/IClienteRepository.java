package com.ares.reto.simulador.model.dao;

import com.ares.reto.simulador.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IClienteRepository extends JpaRepository<Cliente, Long> {

    public List<Cliente> findByDni(@Param("dni") String dni);

}
