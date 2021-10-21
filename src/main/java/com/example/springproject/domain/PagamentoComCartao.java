package com.example.springproject.domain;

import com.example.springproject.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;

@Entity
@JsonTypeName("pagamentoComCartao")
public class PagamentoComCartao extends Pagamento {
    private static final long serialVersionUID = 1L;

    private Integer nroParcelas;

    public PagamentoComCartao() {
    }

    public PagamentoComCartao(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Integer nroParcelas) {
        super(id, estadoPagamento, pedido);
        this.nroParcelas = nroParcelas;
    }

    public Integer getNroParcelas() {
        return nroParcelas;
    }

    public void setNroParcelas(Integer nroParcelas) {
        this.nroParcelas = nroParcelas;
    }

}
