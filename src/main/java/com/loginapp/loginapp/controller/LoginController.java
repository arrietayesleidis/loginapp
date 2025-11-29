package com.loginapp.loginapp.controller;

import com.loginapp.loginapp.model.Usuario;
import com.loginapp.loginapp.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String clave,
                        HttpSession session,
                        Model model) {

        Usuario usuario = usuarioService.login(username, clave);

        if (usuario != null) {
            // guardamos en sesión
            session.setAttribute("nombre", usuario.getNombrecompleto());
            session.setAttribute("correo", usuario.getCorreo());
            session.setAttribute("rol", usuario.getRol());

            // redirigimos al home (panel)
            return "redirect:/home";
        }

        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "login";
    }

    // Vista del panel (home) usando los datos de la sesión
    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        model.addAttribute("nombre", session.getAttribute("nombre"));
        model.addAttribute("correo", session.getAttribute("correo"));
        model.addAttribute("rol", session.getAttribute("rol"));
        return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
