package com.example.tienda_perfumes.servicios;

import java.util.List;
import java.util.Map;

public interface ServicioCarrito {

    void agregarProducto(int idUsuario, long idPerfume, int cantidad);

    void eliminarProducto(int idUsuario, long idPerfume);

    void actualizarCantidad(int idUsuario, long idPerfume, int cantidad);

    void vaciarCarrito(int idUsuario);

    // Se mantiene la operación del profesor para consultar el carrito.
    // En la versión del profesor todavía está pendiente de implementar.
    List<Map<String, Object>> obtenerProductosCarrito(int idUsuario);
}
