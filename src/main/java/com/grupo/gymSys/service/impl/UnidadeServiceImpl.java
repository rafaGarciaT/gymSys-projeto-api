package com.grupo.gymSys.service.impl;

import com.grupo.gymSys.domain.model.Unidade;
import com.grupo.gymSys.domain.model.Usuario;
import com.grupo.gymSys.domain.repository.UnidadeRepository;
import com.grupo.gymSys.domain.repository.UsuarioRepository;
import com.grupo.gymSys.service.UnidadeService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UnidadeServiceImpl implements UnidadeService {

    private final UnidadeRepository unidadeRepository;

    public UnidadeServiceImpl(UnidadeRepository unidadeRepository) {
        this.unidadeRepository = unidadeRepository;
    }
    @Override
    public Unidade findById(Long id) {
        return unidadeRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Unidade create(Usuario userToCreate) {
        if(unidadeRepository.existsById(Long id)unidadeTocreate.getid){}
        return unidadeRepository.save(unidadeToCreate);
    }

    @Override
    public void deleteById(Long id) {
        if (!unidadeRepository.existsById(id)) {
            throw new NoSuchElementException("Nenhuma unidade encontrado com esse id.");
        }
        unidadeRepository.deleteById(id);
    }
}
