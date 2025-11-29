package com.loginapp.loginapp.service;

import com.loginapp.loginapp.model.Usuario;
import com.loginapp.loginapp.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioServiceImpl(UsuarioRepository repo) {
        this.repo = repo;
    }

    @Override
    public Usuario login(String username, String clave) {
        return repo.findByUsernameAndClave(username, clave).orElse(null);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repo.findAll();
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return repo.save(usuario);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
