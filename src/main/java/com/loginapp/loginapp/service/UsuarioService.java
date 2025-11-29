package com.loginapp.loginapp.service;

import com.loginapp.loginapp.model.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario login(String username, String clave);

    List<Usuario> listarTodos();
    Usuario guardar(Usuario usuario);
    Usuario buscarPorId(Long id);
    void eliminar(Long id);
}
