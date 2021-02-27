package com.ares.reto.simulador.model.service;

import com.ares.reto.simulador.model.entity.CardPaymentDetail;
import org.springframework.stereotype.Service;

@Service
public class CardPaymentDetailImpl implements ICardPaymentDetailService{


    @Override
    public CardPaymentDetail initialize() {
        Integer[] installment= new Integer[36];

        for (int i = 0; i < installment.length ; i++) {
            installment[i] = i+1;
        }

        return new CardPaymentDetail(installment);
    }
}
