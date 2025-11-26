package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/InicioSesion")
public class AdminController {
    
    @Autowired
    private UsuarioService usuarioService;

    // Métodos para manejar las solicitudes de inicio de sesión pueden ser añadidos aquí
    @GetMapping
    public String mostrarPaginaInicioSesion(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "inicioSesion"; // Retorna la vista de inicio de sesión
    }

    @PostMapping("/validar")
    public String validarCredenciales(@ModelAttribute Usuario usuario) {
        String correo = usuario.getCorreo();
        String contrasena = usuario.getContrasena();
        boolean esValido = usuarioService.existeUsuarioPorCorreoYContrasena(correo, contrasena);
        if (esValido) {
            return "redirect:/PaginaPrincipal"; // Redirige al dashboard si las credenciales son válidas
        } else {
            return "redirect:/InicioSesion?error=true"; // Redirige de vuelta al inicio de sesión con un error
        }
    }

}
