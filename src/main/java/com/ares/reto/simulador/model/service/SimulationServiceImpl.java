package com.ares.reto.simulador.model.service;

import com.ares.reto.simulador.model.dao.IClienteRepository;
import com.ares.reto.simulador.model.dao.ISimulationRepository;
import com.ares.reto.simulador.model.entity.Cliente;
import com.ares.reto.simulador.model.entity.Simulation;
import com.ares.reto.simulador.model.entity.SimulationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SimulationServiceImpl implements ISimulationService {

    @Autowired
    private Simulation simulation;

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private ISimulationRepository simulationRepository;

    @Autowired
    private IClienteService clienteService;

    @Override
    public SimulationResponse calculateSimulation(Simulation simulation) {

        SimulationResponse sr = new SimulationResponse();

        Double tem = null;
        Double frc = null;
        Double cuota = null;

        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(simulation.getPaymentDay()));
        date = calendar.getTime();

        tem = Math.pow((1+(simulation.getTea()/100)),(0.083))-1;
        frc= (tem*Math.pow((1+tem),simulation.getInstallment()))/(Math.pow((1+tem),simulation.getInstallment())-1);
        cuota = simulation.getAmount()*frc;
        BigDecimal fn = new BigDecimal(cuota);
        fn = fn.setScale(2, RoundingMode.HALF_UP);

        simulationRepository.save(simulation);
        sr.setCurrency(simulation.getCurrency());
        sr.setInstallment(fn.doubleValue());
        sr.setStatus("Conforme");
        sr.setFirstInstallment(sdf.format(date));

        return sr;
    }

    public Boolean validateClient(String dni, String card){

        boolean hasCard = false;

        List<Cliente> listClientes = clienteService.findByDni(dni);
        if (!listClientes.isEmpty()){
            hasCard = listClientes.stream().anyMatch(x -> x.getCard().equals(card));
        }

        return hasCard;
    }
}
