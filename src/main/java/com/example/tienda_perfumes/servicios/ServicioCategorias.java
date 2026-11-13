package com.example.tienda_perfumes.servicios;

import com.example.tienda_perfumes.model.Categoria;
import java.util.List;

public interface ServicioCategorias {

    List<Categoria> obtenerCategorias();

    Categoria obtenerCategoriaPorId(int id);

    void guardarCategoria(Categoria categoria);

    void eliminarCategoria(int id);
}