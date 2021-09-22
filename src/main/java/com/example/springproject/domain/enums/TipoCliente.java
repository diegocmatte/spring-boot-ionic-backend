package com.example.springproject.domain.enums;



public enum TipoCliente {

    PESSOAFISICA(1, "Pessoa Fisíca"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    private int codigo;
    private String descricao;

    TipoCliente(int cod, String descricao) {
        this.codigo = cod;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente toEnum(Integer cod){
        if(cod == null){
            return null;
        }

        for(TipoCliente tipoCliente: TipoCliente.values()){
            if(cod.equals(tipoCliente.getCodigo())){
                return tipoCliente;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
