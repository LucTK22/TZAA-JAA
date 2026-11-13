package com.example.tienda_perfumes.controladoresREST.admin;

import com.example.tienda_perfumes.servicios.ServicioPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/restPedidos/")
public class PedidoRESTAdmin {

    @Autowired
    private ServicioPedido servicioPedido;

    @PostMapping("actualizarEstadoPedido")
    public String actualizarEstadoPedido(@RequestParam("id") Long id,
                                         @RequestParam("estado") String estado) {
        servicioPedido.actualizarEstadoPedido(id, estado);
        return "Estado actualizado correctamente.";
    }
}
