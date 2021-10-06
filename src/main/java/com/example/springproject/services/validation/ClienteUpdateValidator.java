package com.example.springproject.services.validation;


import com.example.springproject.domain.Cliente;
import com.example.springproject.dto.ClienteDTO;
import com.example.springproject.repositories.ClienteRepository;
import com.example.springproject.resources.exception.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void initialize(ClienteUpdate ann){
    }

    @Override
    public boolean isValid(ClienteDTO objDTO, ConstraintValidatorContext context) {

        @SuppressWarnings("unchecked")
        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer uriId = Integer.parseInt(map.get("id"));

        List<FieldMessage> list = new ArrayList<>();

        Cliente aux = clienteRepository.findByEmail(objDTO.getEmail());

        if(aux != null && !aux.getId().equals(uriId)){
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
