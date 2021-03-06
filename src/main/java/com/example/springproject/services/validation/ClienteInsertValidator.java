package com.example.springproject.services.validation;


import com.example.springproject.domain.Cliente;
import com.example.springproject.domain.enums.TipoCliente;
import com.example.springproject.dto.ClienteNewDTO;
import com.example.springproject.repositories.ClienteRepository;
import com.example.springproject.resources.exception.FieldMessage;
import com.example.springproject.services.validation.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void initialize(ClienteInsert ann){
    }

    @Override
    public boolean isValid(ClienteNewDTO objDTO, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if( objDTO.getTipo().equals(TipoCliente.PESSOAFISICA.getCodigo()) &&
            !BR.isValidCPF(objDTO.getCpfOuCnpj()) ) {
            list.add(new FieldMessage("cpfOuCnpj", "CPF inválido."));
        }

        if( objDTO.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCodigo()) &&
                !BR.isValidCNPJ(objDTO.getCpfOuCnpj()) ) {
            list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido."));
        }

        Cliente aux = clienteRepository.findByEmail(objDTO.getEmail());
        if(aux != null){
            list.add(new FieldMessage("email", "E-mail já existente"));
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
