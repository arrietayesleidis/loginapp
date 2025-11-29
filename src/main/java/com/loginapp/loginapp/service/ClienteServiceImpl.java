package com.loginapp.loginapp.service;

import com.loginapp.loginapp.model.Cliente;
import com.loginapp.loginapp.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repo;

    public ClienteServiceImpl(ClienteRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Cliente> listarTodos() {
        return repo.findAll();
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return repo.save(cliente);
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
