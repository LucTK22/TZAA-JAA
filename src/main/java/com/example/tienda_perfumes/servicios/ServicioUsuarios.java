package com.example.tienda_perfumes.servicios;

import com.example.tienda_perfumes.model.Usuario;
import java.util.List;

public interface ServicioUsuarios {

    List<Usuario> obtenerUsuarios();

    Usuario obtenerUsuarioPorId(int id);

    void guardarUsuario(Usuario usuario);

    void eliminarUsuario(int id);

    Usuario obtenerUsuarioPorEmailYpass(String email, String pass);

    void registrarUsuario(Usuario usuario);
}