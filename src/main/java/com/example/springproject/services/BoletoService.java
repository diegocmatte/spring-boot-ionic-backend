package com.example.springproject.services;

import com.example.springproject.domain.PagamentoComBoleto;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class BoletoService {

    public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instatePedido){
        Calendar calender = Calendar.getInstance();
        calender.setTime(instatePedido);
        calender.add(Calendar.DAY_OF_MONTH, 7);
        pagto.setDataPagamento(calender.getTime());
    }
}
