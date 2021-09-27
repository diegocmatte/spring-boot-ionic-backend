package com.example.springproject.services;

import com.example.springproject.domain.Categoria;
import com.example.springproject.domain.Cliente;
import com.example.springproject.repositories.ClienteRepository;
import com.example.springproject.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente find(Integer id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(
                () -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }
}
