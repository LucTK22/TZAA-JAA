package com.example.tienda_perfumes.controllers;

import com.example.tienda_perfumes.model.Usuario;
import org.springframework.ui.Model;
import com.example.tienda_perfumes.servicios.ServicioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControladorUsuario {

    @Autowired
    private ServicioUsuarios servicioUsuarios;

    @RequestMapping("/admin/usuarios")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", servicioUsuarios.obtenerUsuarios());
        return "admin/usuarios";
    }

    @RequestMapping("/admin/usuarios/nuevo")
    public String nuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "admin/usuario_form";
    }

    @RequestMapping("/admin/usuarios/editar/{id}")
    public String editarUsuario(@PathVariable int id, Model model) {
        Usuario usuario = servicioUsuarios.obtenerUsuarioPorId(id);

        if (usuario == null) {
            return "redirect:/admin/usuarios";
        }

        model.addAttribute("usuario", usuario);
        return "admin/usuario_form";
    }

    @RequestMapping(value = "/admin/usuarios/guardar", method = RequestMethod.POST)
    public String guardarUsuario(Usuario usuario) {
        servicioUsuarios.guardarUsuario(usuario);
        return "redirect:/admin/usuarios";
    }

    @RequestMapping("/admin/usuarios/eliminar/{id}")
    public String eliminarUsuario(@PathVariable int id) {
        servicioUsuarios.eliminarUsuario(id);
        return "redirect:/admin/usuarios";
    }
}

