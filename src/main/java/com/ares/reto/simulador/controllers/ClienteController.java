package com.ares.reto.simulador.controllers;

import com.ares.reto.simulador.model.dao.IClienteRepository;
import com.ares.reto.simulador.model.entity.Cliente;
import com.ares.reto.simulador.model.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ClienteController {

    @Autowired
    public IClienteService clienteService;

    @Autowired
    public IClienteRepository clienteDao;


    @GetMapping("/clienteDNI/{dni}")
    public List<Cliente> listarClientes(@PathVariable String dni){

        return clienteService.findByDni(dni);
    }

    @GetMapping("listar")
    public List<Cliente> listar(){

        return clienteService.findAll();
    }

/*    @PostMapping("/crear")
    ResponseEntity<String> addUser(@Valid @RequestBody Cliente cliente) {

        clienteDao.save(cliente);
        return ResponseEntity.ok("User is valid");
    }*/


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
