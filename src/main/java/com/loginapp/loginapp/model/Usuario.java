package com.loginapp.loginapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombrecompleto;
    private String username;
    private String clave;
    private String correo;
    private String rol;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombrecompleto() { return nombrecompleto; }
    public void setNombrecompleto(String nombrecompleto) { this.nombrecompleto = nombrecompleto; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
}
