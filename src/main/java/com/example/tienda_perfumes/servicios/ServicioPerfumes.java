package com.example.tienda_perfumes.servicios;

import com.example.tienda_perfumes.model.Perfume;
import java.util.List;
import java.util.Map;

public interface ServicioPerfumes {
    void registrarPerfume(Perfume p);
    List<Perfume> obtenerPerfumes();
    List<Perfume> obtenerPerfumesPorNombre(String nombre, int comienzo, int limite);
    long obtenerTotalPerfumes(String nombre);
    Perfume obtenerPerfumePorId(long id);
    void borrarPerfume(long id);
    void guardarCambiosPerfume(Perfume perfumeEditar) throws Exception;

    List<Map<String, Object>> obtenerJSONperfumes();

    Map<String, Object> obtenerJSONPerfumePorId(Long id);
}
