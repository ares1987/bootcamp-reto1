package com.ares.reto.simulador.model.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Repository
@Entity
@Table(name = "simulations")
public class Simulation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Debe ingresar DNI")
    @Size(min = 8, max = 8, message = "Debe tener 8 dígitos")
    private String dni;

    @NotBlank(message = "Debe ingresar Tarjeta")
    private String card;

    @NotBlank(message = "Debe ingresar Moneda")
    private String currency;

    @NotNull(message = "Debe ingresar monto")
    @Min(value = 10, message = "El monto debe ser igual o superior a 10")
    private Double amount;

    @NotNull(message = "Debe ingresar el número de Cuotas entre 1 y 36")
    @Min(value = 1, message = "La cuota no debe ser menor a 1")
    @Max(value = 36, message = "La cuota no debe ser mayor a 36")
    private Integer installment;

    @NotNull(message = "Debe ingresar el valor de la TEA")
    @Digits(integer=2, fraction=2)
    private Double tea;

    @NotNull(message = "Debe ingresar el día de pago")
    @Pattern(regexp = "5|20", message = "Debe ser 5 o 20")
    private String paymentDay;



    public Simulation(Long id, @NotBlank(message = "Debe ingresar DNI") @Size(min = 8, max = 8, message = "Debe tener 8 dígitos") String dni, @NotBlank(message = "Debe ingresar Tarjeta") String card, @NotBlank(message = "Debe ingresar Moneda") String currency, @NotNull(message = "Debe ingresar monto") @Min(value = 10, message = "El monto debe ser igual o superior a 10") Double amount, @NotNull(message = "Debe ingresar el número de Cuotas entre 1 y 36") @Min(value = 1, message = "La cuota no debe ser menor a 1") @Max(value = 36, message = "La cuota no debe ser mayor a 36") Integer installment, @NotNull(message = "Debe ingresar el valor de la TEA") @Digits(integer = 2, fraction = 2) Double tea, @NotNull(message = "Debe ingresar el día de pago") @Pattern(regexp = "5|20") String paymentDay) {
        this.id = id;
        this.dni = dni;
        this.card = card;
        this.currency = currency;
        this.amount = amount;
        this.installment = installment;
        this.tea = tea;
        this.paymentDay = paymentDay;

    }

    public Simulation(@NotBlank(message = "Debe ingresar DNI") @Size(min = 8, max = 8, message = "Debe tener 8 dígitos") String dni, @NotBlank(message = "Debe ingresar Tarjeta") String card, @NotBlank(message = "Debe ingresar Moneda") String currency, @NotNull(message = "Debe ingresar monto") @Min(value = 10, message = "El monto debe ser igual o superior a 10") Double amount, @NotNull(message = "Debe ingresar el número de Cuotas entre 1 y 36") @Min(value = 1, message = "La cuota no debe ser menor a 1") @Max(value = 36, message = "La cuota no debe ser mayor a 36") Integer installment, @NotNull(message = "Debe ingresar el valor de la TEA") @Digits(integer = 2, fraction = 2) Double tea, @NotNull(message = "Debe ingresar el día de pago") @Pattern(regexp = "5|20") String paymentDay) {
        this.dni = dni;
        this.card = card;
        this.currency = currency;
        this.amount = amount;
        this.installment = installment;
        this.tea = tea;
        this.paymentDay = paymentDay;

    }

    public Simulation() {
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getInstallment() {
        return installment;
    }

    public void setInstallment(Integer installment) {
        this.installment = installment;
    }

    public Double getTea() {
        return tea;
    }

    public void setTea(Double tea) {
        this.tea = tea;
    }

    public String getPaymentDay() {
        return paymentDay;
    }

    public void setPaymentDay(String paymentDay) {
        this.paymentDay = paymentDay;
    }


}
