package com.ares.reto.simulador.model.service;

import com.ares.reto.simulador.model.entity.Cliente;

import java.util.List;


public interface IClienteService {



    public List<Cliente> findAll();

    public List<Cliente> findByDni(String dni);

    public Cliente save(Cliente cliente);
}
