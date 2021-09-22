package com.example.springproject.services;

import com.example.springproject.domain.Categoria;
import com.example.springproject.repositories.CategoriaRepository;
import com.example.springproject.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscar(Integer id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElseThrow(
                () -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }
}
