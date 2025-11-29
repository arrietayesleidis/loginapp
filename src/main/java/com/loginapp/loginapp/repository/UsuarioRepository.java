package com.loginapp.loginapp.repository;

import com.loginapp.loginapp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsernameAndClave(String username, String clave);
}
