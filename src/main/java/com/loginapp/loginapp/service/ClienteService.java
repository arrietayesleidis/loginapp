package com.loginapp.loginapp.service;

import com.loginapp.loginapp.model.Cliente;
import java.util.List;

public interface ClienteService {

    List<Cliente> listarTodos();

    Cliente guardar(Cliente cliente);

    Cliente buscarPorId(Long id);

    void eliminar(Long id);
}
