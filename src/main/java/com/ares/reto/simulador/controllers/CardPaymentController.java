package com.ares.reto.simulador.controllers;

import com.ares.reto.simulador.model.entity.CardPaymentDetail;
import com.ares.reto.simulador.model.service.ICardPaymentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CardPaymentController {
    @Autowired
    public ICardPaymentDetailService iCardPaymentDetailService;


    @GetMapping("/load")
    public CardPaymentDetail listar(){

        return iCardPaymentDetailService.initialize();
    }

}
