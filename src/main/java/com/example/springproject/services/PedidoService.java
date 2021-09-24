package com.example.springproject.services;

import com.example.springproject.domain.Pedido;
import com.example.springproject.repositories.PedidoRepository;
import com.example.springproject.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido buscar(Integer id){
        Optional<Pedido> cliente = pedidoRepository.findById(id);
        return cliente.orElseThrow(
                () -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }
}
