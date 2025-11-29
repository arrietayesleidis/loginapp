package com.loginapp.loginapp.repository;

import com.loginapp.loginapp.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
