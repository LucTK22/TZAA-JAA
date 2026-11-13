package com.example.tienda_perfumes.controladoresREST;

import com.example.tienda_perfumes.model.Pedido;
import com.example.tienda_perfumes.model.Usuario;
import com.example.tienda_perfumes.responseData.ResumenPedido;
import com.example.tienda_perfumes.servicios.ServicioPedido;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("restPedidos/")
public class PedidoREST {

    @Autowired
    private ServicioPedido servicioPedido;

    @RequestMapping("procesarPaso1")
    public String procesarPaso1(@RequestParam String nombreCompleto,
                                @RequestParam String direccion,
                                @RequestParam String provincia,
                                @RequestParam String localidad,
                                @RequestParam String codigoPostal,
                                @RequestParam String telefono,
                                @RequestParam String correo,
                                HttpServletRequest request) {
        Usuario usuario = usuarioIdentificado(request);
        servicioPedido.procesarPaso1(nombreCompleto, direccion, provincia, localidad, codigoPostal,
                telefono, correo, usuario.getId());
        return "Datos de envío guardados.";
    }

    @RequestMapping("procesarRegalo")
    public String procesarRegalo(@RequestParam boolean esRegalo, HttpServletRequest request) {
        servicioPedido.procesarRegalo(esRegalo, usuarioIdentificado(request).getId());
        return "Preferencia de regalo guardada.";
    }

    @RequestMapping("procesarPaso2")
    public String procesarPaso2(@RequestParam String titular,
                                @RequestParam String numero,
                                @RequestParam String tipoTarjeta,
                                HttpServletRequest request) {
        Usuario usuario = usuarioIdentificado(request);
        servicioPedido.procesarPaso2(titular, numero, tipoTarjeta, usuario.getId());
        return "Datos de pago guardados.";
    }

    @RequestMapping("obtenerResumenPedido")
    public ResumenPedido obtenerResumenPedido(HttpServletRequest request) {
        return servicioPedido.obtenerResumenPedido(usuarioIdentificado(request).getId());
    }

    @RequestMapping("confirmarPedido")
    public String confirmarPedido(HttpServletRequest request) {
        Long idPedido = servicioPedido.confirmarPedido(usuarioIdentificado(request).getId());
        return "Pedido confirmado correctamente. Número de pedido: " + idPedido;
    }

    private Usuario usuarioIdentificado(HttpServletRequest request) {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_identificado");
        if (usuario == null) throw new IllegalStateException("Debes identificarte para realizar esta operación.");
        return usuario;
    }
}
