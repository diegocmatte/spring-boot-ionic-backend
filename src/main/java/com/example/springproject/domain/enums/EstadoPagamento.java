package com.example.springproject.domain.enums;

public enum EstadoPagamento {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private int codigo;
    private String descricao;

    EstadoPagamento(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EstadoPagamento toEnum(Integer cod){
        if(cod == null){
            return null;
        }

        for(EstadoPagamento estadoPagamento: EstadoPagamento.values()){
            if(cod.equals(estadoPagamento.getCodigo())){
                return estadoPagamento;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
