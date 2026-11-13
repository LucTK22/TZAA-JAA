
package com.example.tienda_perfumes.controllers;

import com.example.tienda_perfumes.model.Pedido;
import com.example.tienda_perfumes.constantesPedidos.EstadosPedido;
import com.example.tienda_perfumes.servicios.ServicioPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("admin/")
public class ControladorPedido {

    @Autowired
    private ServicioPedido servicioPedidos;

    @RequestMapping("gestionarPedidos")
    public String gestionarPedidos(Model model) {
        model.addAttribute("pedidos", servicioPedidos.obtenerPedidos());
        return "admin/gestionar_pedidos";
    }

    @RequestMapping("verDetallesPedido")
    public String verDetallesPedido(@RequestParam("id") Long id, Model model) {
        Pedido p = servicioPedidos.obtenerPedidoPorId(id);

        if (p == null) {
            return "redirect:/admin/gestionarPedidos";
        }

        model.addAttribute("pedido", p);
        model.addAttribute("estados", EstadosPedido.values());
        return "admin/pedidos_detalle";
    }
}
