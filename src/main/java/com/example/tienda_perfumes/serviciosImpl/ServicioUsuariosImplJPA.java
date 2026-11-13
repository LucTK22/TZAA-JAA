package com.example.tienda_perfumes.serviciosImpl;

import com.example.tienda_perfumes.model.Usuario;
import com.example.tienda_perfumes.servicios.ServicioUsuarios;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ServicioUsuariosImplJPA implements ServicioUsuarios {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario> obtenerUsuarios() {
        return entityManager.createQuery(
                "select u from Usuario u", Usuario.class
        ).getResultList();
    }

    @Override
    public Usuario obtenerUsuarioPorId(int id) {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        if (usuario.getId() == 0) {
            entityManager.persist(usuario);
        } else {
            entityManager.merge(usuario);
        }
    }

    @Override
    public void eliminarUsuario(int id) {
        Usuario usuario = entityManager.find(Usuario.class, id);

        if (usuario != null) {
            entityManager.remove(usuario);
        }
    }

    @Override
    public Usuario obtenerUsuarioPorEmailYpass(String email, String pass) {
        List<Usuario> usuarios = entityManager.createQuery(
                        "select u from Usuario u where u.email = :email and u.pass = :pass",
                        Usuario.class
                )
                .setParameter("email", email)
                .setParameter("pass", pass)
                .getResultList();

        if (usuarios.isEmpty()) {
            return null;
        }

        return usuarios.get(0);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        entityManager.persist(usuario);
    }


}