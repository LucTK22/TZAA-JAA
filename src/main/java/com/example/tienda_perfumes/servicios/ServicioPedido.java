package com.example.tienda_perfumes.servicios;

import com.example.tienda_perfumes.model.Pedido;
import com.example.tienda_perfumes.responseData.ResumenPedido;
import java.util.List;

public interface ServicioPedido {
    // Gestión de administración
    List<Pedido> obtenerPedidos();
    Pedido obtenerPedidoPorId(Long id);
    void actualizarEstadoPedido(Long id, String estado);

    // Operaciones del checkout
    void procesarPaso1(String nombreCompleto, String direccion, String provincia,
                       String localidad, String codigoPostal, String telefono, String correo, int idUsuario);
    void procesarPaso2(String titular, String numero, String tipoTarjeta, int idUsuario);
    void procesarRegalo(boolean esRegalo, int idUsuario);
    ResumenPedido obtenerResumenPedido(int idUsuario);
    Long confirmarPedido(int idUsuario);
}
