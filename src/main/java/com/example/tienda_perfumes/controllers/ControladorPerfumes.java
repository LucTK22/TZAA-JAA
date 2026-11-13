package com.example.tienda_perfumes.controllers;

import com.example.tienda_perfumes.model.Perfume;
import com.example.tienda_perfumes.servicios.ServicioCategorias;
import com.example.tienda_perfumes.servicios.ServicioPerfumes;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin/")
public class ControladorPerfumes {

    @Autowired
    private ServicioPerfumes servicioPerfumes;

    @Autowired
    private ServicioCategorias servicioCategorias;

    @RequestMapping("gestionarPerfumes")
    public String gestionarPerfumes(
            @RequestParam(name = "nombre", defaultValue = "") String nombre,
            @RequestParam(name = "comienzo", defaultValue = "0") int comienzo,
            Model model){
        int pagina = Math.max(0, comienzo);
        long total = servicioPerfumes.obtenerTotalPerfumes(nombre);
        model.addAttribute("perfumes", servicioPerfumes.obtenerPerfumesPorNombre(nombre, pagina, 10));
        model.addAttribute("nombre", nombre);
        model.addAttribute("comienzo", pagina);
        model.addAttribute("anterior", pagina - 10);
        model.addAttribute("siguiente", pagina + 10);
        model.addAttribute("desde", total == 0 ? 0 : pagina + 1);
        model.addAttribute("hasta", Math.min((long) pagina + 10, total));
        model.addAttribute("total", total);
        return "admin/gestionar_productos";
    }

    @RequestMapping("registrarPerfume")
    public String registrarPerfume(Model model){
        Perfume nuevo = new Perfume();
        nuevo.setPrecio(1);

        model.addAttribute("nuevo", nuevo);

        model.addAttribute(
                "categorias",
                servicioCategorias.obtenerCategorias()
        );

        return "admin/registro_producto";
    }

    @RequestMapping("guardarPerfume")
    public String guardarPerfume(
            @ModelAttribute("nuevo")
            @Valid
            Perfume nuevo,
            BindingResult resultadoValidacion,
            Model model){
        System.out.println("recibido para registrar: " + nuevo);
        if (resultadoValidacion.hasErrors()){
            return "admin/registro_producto";
        }
        servicioPerfumes.registrarPerfume(nuevo);
        return "admin/registro_producto_ok";
    }

    @RequestMapping("guardarCambiosPerfume")
    public String guardarCambiosPerfume(
            @ModelAttribute("perfumeEditar")
            @Valid
            Perfume perfumeEditar,
            BindingResult resultadoValidacion,
            Model model) throws Exception {
        if (resultadoValidacion.hasErrors()) {
            model.addAttribute("categorias", servicioCategorias.obtenerCategorias());
            return "admin/editar_producto";
        }
        servicioPerfumes.guardarCambiosPerfume(perfumeEditar);
        return gestionarPerfumes("", 0, model);
    }

    @RequestMapping("editarPerfume")
    public String editarPerfume(@RequestParam("id") Long id, Model model){
        Perfume perfume = servicioPerfumes.obtenerPerfumePorId(id);
        if (perfume == null) {
            return "redirect:/admin/gestionarPerfumes";
        }
        if (perfume.getCategoria() != null) {
            perfume.setIdCategoria(perfume.getCategoria().getId());
        }
        model.addAttribute("perfumeEditar", perfume);
        model.addAttribute("categorias", servicioCategorias.obtenerCategorias());
        return "admin/editar_producto";
    }

    @RequestMapping("borrarPerfume")
    public String borrarPerfume(@RequestParam("id") Long id, Model model){
        System.out.println("id recibida para borrar registro: " + id);
        servicioPerfumes.borrarPerfume(id);
        return gestionarPerfumes("", 0, model);
    }
}
