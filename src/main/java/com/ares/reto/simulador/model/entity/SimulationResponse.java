package com.ares.reto.simulador.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Repository;


@Repository
public class SimulationResponse {

    @JsonProperty(value = "cuota")
    private Double installment;
    private String currency;
    private String firstInstallment;
    private String status;

    public SimulationResponse(Double installment, String currency, String firstInstallment, String status) {
        this.installment = installment;
        this.currency = currency;
        this.firstInstallment = firstInstallment;
        this.status = status;
    }

    public SimulationResponse() {
    }

    public Double getInstallment() {
        return installment;
    }

    public void setInstallment(Double installment) {
        this.installment = installment;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFirstInstallment() {
        return firstInstallment;
    }

    public void setFirstInstallment(String firstInstallment) {
        this.firstInstallment = firstInstallment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
