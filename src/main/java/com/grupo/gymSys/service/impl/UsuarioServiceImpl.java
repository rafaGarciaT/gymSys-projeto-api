package com.grupo.gymSys.service.impl;

import com.grupo.gymSys.domain.model.Usuario;
import com.grupo.gymSys.domain.repository.UsuarioRepository;
import com.grupo.gymSys.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Usuario create(Usuario userToCreate) {
        if (usuarioRepository.existsByEmail(userToCreate.getEmail())) {
            throw new IllegalArgumentException("Já existe um usuário cadastrado com esse email.");
        }

        if (usuarioRepository.existsByTelefone(userToCreate.getTelefone())) {
            throw new IllegalArgumentException("Já existe um usuário cadastrado com esse telefone.");
        }

        return usuarioRepository.save(userToCreate);
    }

    @Override
    public void deleteById(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new NoSuchElementException("Nenhum usuário encontrado com esse id.");
        }
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario update(Long id, Usuario updatedUser) {
        Usuario existingUser = usuarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Nenhum usuário encontrado com esse id."));

        existingUser.setNome(updatedUser.getNome());

        if (usuarioRepository.existsByEmail(updatedUser.getEmail())) {
            throw new IllegalArgumentException("Já existe um usuário cadastrado com esse email.");
        }

        existingUser.setEmail(updatedUser.getEmail());

        if (usuarioRepository.existsByTelefone(updatedUser.getTelefone())) {
            throw new IllegalArgumentException("Já existe um usuário cadastrado com esse email.");
        }

        existingUser.setTelefone(updatedUser.getTelefone());

        return usuarioRepository.save(existingUser);
    }
}
