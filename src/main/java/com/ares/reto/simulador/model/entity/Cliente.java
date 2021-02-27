package com.ares.reto.simulador.model.entity;


import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Repository
@Entity
@Table(name = "clientes")
public class Cliente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dni;

    @NotBlank(message = "Debe ingresar tarjeta")
    private String card;

    public Cliente(Long id, String dni, @NotBlank(message = "Debe ingresar tarjeta") String card) {
        this.id = id;
        this.dni = dni;
        this.card = card;
    }

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }
}
