package com.example.springproject.services.validation;


import com.example.springproject.domain.enums.TipoCliente;
import com.example.springproject.dto.ClienteNewDTO;
import com.example.springproject.resources.exception.FieldMessage;
import com.example.springproject.services.validation.utils.BR;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

    @Override
    public void initialize(ClienteInsert ann){
    }

    @Override
    public boolean isValid(ClienteNewDTO objDTO, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        // inclua os testes aqui, inserindo erros na lista
        if( objDTO.getTipo().equals(TipoCliente.PESSOAFISICA.getCodigo()) &&
            !BR.isValidCPF(objDTO.getCpfOuCnpj()) ) {
            list.add(new FieldMessage("cpfOuCnpj", "CPF inválido."));
        }

        if( objDTO.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCodigo()) &&
                !BR.isValidCNPJ(objDTO.getCpfOuCnpj()) ) {
            list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido."));
        }

        for (FieldMessage fm: list){
            context.disableDefaultConstraintViolation();;
            context.buildConstraintViolationWithTemplate(fm.getMessage())
                    .addPropertyNode(fm.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
