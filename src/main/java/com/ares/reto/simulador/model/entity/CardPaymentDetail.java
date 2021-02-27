package com.ares.reto.simulador.model.entity;




public class CardPaymentDetail{


    private String[] card = {"Clásica", "Oro", "Black"};
    private Integer[] installment = new Integer[36];
    private Integer[] paymentDay = {5,20};
    private Double[] tea = {99.90, 95.90, 90.90};

    public CardPaymentDetail(String[] card, Integer[] installment, Integer[] paymentDay, Double[] tea) {
        this.card = card;
        this.installment = installment;
        this.paymentDay = paymentDay;
        this.tea = tea;
    }

    public CardPaymentDetail(Integer[] installment) {
        this.installment = installment;
    }

    public String[] getCard() {
        return card;
    }

    public void setCard(String[] card) {
        this.card = card;
    }

    public Integer[] getInstallment() {
        return installment;
    }

    public void setInstallment(Integer[] installment) {
        this.installment = installment;
    }

    public Integer[] getPaymentDay() {
        return paymentDay;
    }

    public void setPaymentDay(Integer[] paymentDay) {
        this.paymentDay = paymentDay;
    }

    public Double[] getTea() {
        return tea;
    }

    public void setTea(Double[] tea) {
        this.tea = tea;
    }

    public CardPaymentDetail() {
    }
}
