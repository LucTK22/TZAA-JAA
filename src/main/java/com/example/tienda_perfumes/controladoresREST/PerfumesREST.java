package com.example.tienda_perfumes.controladoresREST;

import com.example.tienda_perfumes.model.Perfume;
import com.example.tienda_perfumes.servicios.ServicioPerfumes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("RESTPerfumes/")
public class PerfumesREST {

    @Autowired
    private ServicioPerfumes servicioPerfumes;

    //@RequestMapping("listar")
    //public List<Perfume> listar(){
    //    return servicioPerfumes.obtenerPerfumes();
    //}

    //ahora que se ha complicado un poco
    //vamos a tomar mas control en devolver el json con el
    //listado de videojuegos
    @RequestMapping("listar")
    public List<Map<String, Object>> listar() {
        return servicioPerfumes.obtenerJSONperfumes();
    }

    @RequestMapping("obtener-perfume")
    public Map<String, Object> obtenerPerfume(@RequestParam("id") Long id) {
        return servicioPerfumes.obtenerJSONPerfumePorId(id);
    }
}
