package com.example.tienda_perfumes.controladoresREST;

import com.example.tienda_perfumes.model.Usuario;
import com.example.tienda_perfumes.servicios.ServicioCarrito;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("restCarrito/")
public class CarritoREST {

    @Autowired
    private ServicioCarrito servicioCarrito;

    @RequestMapping("agregarProducto")
    public String agregarProducto(
            @RequestParam("id") long idPerfume,
            @RequestParam("cantidad") int cantidad,
            HttpServletRequest request) {

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_identificado");
        if (usuario == null) {
            return "Identifícate antes de añadir perfumes al carrito.";
        }
        if (cantidad < 1) {
            return "La cantidad debe ser como mínimo 1.";
        }

        servicioCarrito.agregarProducto(usuario.getId(), idPerfume, cantidad);
        return "Perfume añadido al carrito. Cantidad: " + cantidad;
    }
    @RequestMapping("obtenerProductos")
    public List<Map<String, Object>> obtenerProductos(HttpServletRequest request) {

        Usuario usuario = (Usuario) request.getSession()
                .getAttribute("usuario_identificado");

        if (usuario == null) {
            return java.util.Collections.emptyList();
        }

        return servicioCarrito.obtenerProductosCarrito(usuario.getId());
    }
    @RequestMapping("eliminarProducto")
    public void eliminarProducto(
            HttpServletRequest request,
            @RequestParam long idPerfume) {

        Usuario usuario = (Usuario) request.getSession()
                .getAttribute("usuario_identificado");

        if (usuario != null) {
            servicioCarrito.eliminarProducto(
                    usuario.getId(), idPerfume);
        }
    }

    @RequestMapping("actualizarCantidad")
    public void actualizarCantidad(
            HttpServletRequest request,
            @RequestParam long idPerfume,
            @RequestParam int cantidad) {

        Usuario usuario = (Usuario) request.getSession()
                .getAttribute("usuario_identificado");

        if (usuario != null && cantidad >= 1) {
            servicioCarrito.actualizarCantidad(
                    usuario.getId(), idPerfume, cantidad);
        }
    }

    @RequestMapping("vaciarCarrito")
    public void vaciarCarrito(HttpServletRequest request) {

        Usuario usuario = (Usuario) request.getSession()
                .getAttribute("usuario_identificado");

        if (usuario != null) {
            servicioCarrito.vaciarCarrito(usuario.getId());
        }
    }

}
