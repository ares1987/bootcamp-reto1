package com.ares.reto.simulador.model.service;

import com.ares.reto.simulador.model.dao.IClienteRepository;
import com.ares.reto.simulador.model.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteRepository clienteDao;


    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    public List<Cliente> findByDni(String dni) {
         return (List<Cliente>) clienteDao.findByDni(dni);
    }

    @Override
    public Cliente save(Cliente cliente) {

        return clienteDao.save(cliente);
    }




}
