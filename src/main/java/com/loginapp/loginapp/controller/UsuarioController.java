package com.loginapp.loginapp.controller;

import com.loginapp.loginapp.model.Usuario;
import com.loginapp.loginapp.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", service.listarTodos());
        model.addAttribute("usuario", new Usuario());  // formulario vacío
        return "usuarios";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Usuario usuario) {
        service.guardar(usuario);                      // si tiene id actualiza, si no crea
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", service.buscarPorId(id));
        model.addAttribute("usuarios", service.listarTodos());
        return "usuarios";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/usuarios";
    }
}
