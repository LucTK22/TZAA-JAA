package com.example.tienda_perfumes.controllers;

import com.example.tienda_perfumes.model.Categoria;
import com.example.tienda_perfumes.servicios.ServicioCategorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControladorCategorias {

    @Autowired
    private ServicioCategorias servicioCategorias;

    @RequestMapping("/admin/categorias")
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", servicioCategorias.obtenerCategorias());
        return "admin/categorias";
    }

    @RequestMapping("/admin/categorias/nueva")
    public String nuevaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "admin/categoria_form";
    }

    @RequestMapping("/admin/categorias/editar/{id}")
    public String editarCategoria(@PathVariable int id, Model model) {
        Categoria categoria = servicioCategorias.obtenerCategoriaPorId(id);
        model.addAttribute("categoria", categoria);
        return "admin/categoria_form";
    }

    @RequestMapping(value = "/admin/categorias/guardar", method = RequestMethod.POST)
    public String guardarCategoria(Categoria categoria) {
        servicioCategorias.guardarCategoria(categoria);
        return "redirect:/admin/categorias";
    }

    @RequestMapping("/admin/categorias/eliminar/{id}")
    public String eliminarCategoria(@PathVariable int id) {
        servicioCategorias.eliminarCategoria(id);
        return "redirect:/admin/categorias";
    }
}