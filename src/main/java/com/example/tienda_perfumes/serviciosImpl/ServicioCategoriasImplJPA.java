package com.example.tienda_perfumes.serviciosImpl;

import com.example.tienda_perfumes.model.Categoria;
import com.example.tienda_perfumes.servicios.ServicioCategorias;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ServicioCategoriasImplJPA implements ServicioCategorias {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Categoria> obtenerCategorias() {
        return entityManager.createQuery(
                "select c from Categoria c"
        ).getResultList();
    }

    @Override
    public Categoria obtenerCategoriaPorId(int id) {
        return entityManager.find(Categoria.class, id);
    }

    @Override
    public void guardarCategoria(Categoria categoria) {
        if (categoria.getId() == 0) {
            entityManager.persist(categoria);
        } else {
            entityManager.merge(categoria);
        }
    }

    @Override
    public void eliminarCategoria(int id) {
        Categoria categoria = entityManager.find(Categoria.class, id);

        if (categoria != null) {
            entityManager.remove(categoria);
        }
    }
}