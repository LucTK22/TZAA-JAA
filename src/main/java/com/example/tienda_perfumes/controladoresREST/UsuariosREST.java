package com.example.tienda_perfumes.controladoresREST;

import com.example.tienda_perfumes.model.Usuario;
import com.example.tienda_perfumes.servicios.ServicioUsuarios;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("restUsuarios/")
public class UsuariosREST {

    @Autowired
    private ServicioUsuarios servicioUsuarios;

    @RequestMapping("registrarUsuario")
    public String registrarUsuario(@RequestParam Map<String, Object> formData) {

        System.out.println("Recibido form data: " + formData);

        Gson gson = new Gson();
        JsonElement json = gson.toJsonTree(formData);
        Usuario usuario = gson.fromJson(json, Usuario.class);

        servicioUsuarios.registrarUsuario(usuario);

        return "Te has registrado correctamente, ya puedes identificarte";
    }

    @RequestMapping("identificarUsuario")
    public String identificarUsuario(
            @RequestParam("email") String email,
            @RequestParam("pass") String pass,
            HttpServletRequest request) {

        Usuario usuario = servicioUsuarios.obtenerUsuarioPorEmailYpass(email, pass);
        if (usuario == null) {
            return "email o contraseña incorrectos";
        }

        request.getSession().setAttribute("usuario_identificado", usuario);
        return "ok," + usuario.getNombre();
    }

    @RequestMapping("cerrarSesion")
    public String cerrarSesion(HttpServletRequest request) {
        // Conserva la sesión de administración y el idioma; solo desconecta al cliente.
        request.getSession().removeAttribute("usuario_identificado");
        return "ok";
    }
}
