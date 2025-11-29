package com.loginapp.loginapp.controller;

import com.loginapp.loginapp.model.Cliente;
import com.loginapp.loginapp.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clientes", service.listarTodos());
        model.addAttribute("cliente", new Cliente());  // formulario vacío
        return "clientes";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Cliente cliente) {
        service.guardar(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("cliente", service.buscarPorId(id));
        model.addAttribute("clientes", service.listarTodos());
        return "clientes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/clientes";
    }
}
