package com.example.tienda_perfumes.serviciosImpl;

import com.example.tienda_perfumes.constantesSQL.ConstantesSQL;
import com.example.tienda_perfumes.model.Perfume;
import com.example.tienda_perfumes.servicios.ServicioPerfumes;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.sql.internal.NativeQueryImpl;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.tienda_perfumes.model.Categoria;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ServicioPerfumesImplJPA implements ServicioPerfumes {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void registrarPerfume(Perfume p) {
        try {
            if (p.getFotoSubida() != null &&
                    p.getFotoSubida().getSize() > 0) {

                p.setImagenPortada(
                        p.getFotoSubida().getBytes()
                );
            }
            if (p.getFondoSubido() != null && p.getFondoSubido().getSize() > 0) {
                p.setImagenFondo(p.getFondoSubido().getBytes());
                p.setTipoImagenFondo(p.getFondoSubido().getContentType());
            }
        } catch (IOException e) {
            System.out.println("NO PUDE PROCESAR LAS IMAGENES SUBIDAS");
            throw new RuntimeException(e);
        }

        Categoria c =
                entityManager.find(
                        Categoria.class,
                        p.getIdCategoria()
                );

        p.setCategoria(c);

        entityManager.persist(p);
    }

    @Override
    public List<Perfume> obtenerPerfumes() {
        return entityManager.createQuery("select p from Perfume p").getResultList();
    }

    @Override
    public List<Perfume> obtenerPerfumesPorNombre(String nombre, int comienzo, int limite) {
        String busqueda = nombre == null ? "" : nombre.trim();
        return entityManager.createQuery(
                        "SELECT p FROM Perfume p WHERE " +
                                "LOWER(p.nombre) LIKE LOWER(:busqueda) OR " +
                                "LOWER(p.marca) LIKE LOWER(:busqueda) ORDER BY p.id", Perfume.class)
                .setParameter("busqueda", "%" + busqueda + "%")
                .setFirstResult(Math.max(0, comienzo))
                .setMaxResults(Math.max(1, limite))
                .getResultList();
    }

    @Override
    public long obtenerTotalPerfumes(String nombre) {
        String busqueda = nombre == null ? "" : nombre.trim();
        return entityManager.createQuery(
                        "SELECT COUNT(p) FROM Perfume p WHERE " +
                                "LOWER(p.nombre) LIKE LOWER(:busqueda) OR " +
                                "LOWER(p.marca) LIKE LOWER(:busqueda)", Long.class)
                .setParameter("busqueda", "%" + busqueda + "%")
                .getSingleResult();
    }

    @Override
    public Perfume obtenerPerfumePorId(long id) {
        return entityManager.find(Perfume.class, id);
    }

    @Override
    public void borrarPerfume(long id) {
        Perfume perfumeABorrar = entityManager.find(Perfume.class, id);
        if (perfumeABorrar != null) {
            entityManager.remove(perfumeABorrar);
        } else {
            System.out.println("id no encontrada");
        }
    }

    @Override
    public void guardarCambiosPerfume(Perfume perfumeEditar) throws Exception {
        Perfume original = entityManager.find(Perfume.class, perfumeEditar.getId());

        if (perfumeEditar.getFotoSubida() == null ||
                perfumeEditar.getFotoSubida().getSize() == 0) {
            if (original != null) {
                perfumeEditar.setImagenPortada(original.getImagenPortada());
            }
        } else {
            perfumeEditar.setImagenPortada(
                    perfumeEditar.getFotoSubida().getBytes()
            );
        }

        if (perfumeEditar.getFondoSubido() == null || perfumeEditar.getFondoSubido().getSize() == 0) {
            if (original != null) {
                perfumeEditar.setImagenFondo(original.getImagenFondo());
                perfumeEditar.setTipoImagenFondo(original.getTipoImagenFondo());
            }
        } else {
            perfumeEditar.setImagenFondo(perfumeEditar.getFondoSubido().getBytes());
            perfumeEditar.setTipoImagenFondo(perfumeEditar.getFondoSubido().getContentType());
        }

        Categoria categoria = entityManager.find(
                Categoria.class, perfumeEditar.getIdCategoria());

        perfumeEditar.setCategoria(categoria);

        entityManager.merge(perfumeEditar);
    }

    @Override
    public List<Map<String, Object>> obtenerJSONperfumes() {
        // con JPA hemos asociado categoria a producto
        // problema : el json recibido en portada no es correcto
        // solucion: dejar claro en una consulta a base de datos que informacion
        // va a formar el json que necesitamos en portada

        //Map de String es un conjunto de elementos
        // donde cada elementos tiene un string y un Object
        // un Object en java es cualquier tipo de dato
        // Object es la clase padre de todas las clases d java
        //Map<String, Object> json = new HashMap<>();
        //json.put("titulo" , "GTAV");
        //json.put("precio" , 45);
        //json.put(56 , 60);//da error porq lo primero no es un String
        Query consulta =
                entityManager.createNativeQuery(
                        ConstantesSQL.SQL_OBTENER_PERFUMES_JSON
                );
        //usar la consulta directamente es mucho mas lioso
        //que lo siguiente
        NativeQueryImpl nativeQuery = (NativeQueryImpl) consulta;
        nativeQuery.setTupleTransformer(AliasToEntityMapResultTransformer.INSTANCE);

        return nativeQuery.getResultList();
    }

    @Override
    public Map<String, Object> obtenerJSONPerfumePorId(Long id) {
        return (Map<String, Object>) ((NativeQueryImpl) entityManager.createNativeQuery(ConstantesSQL.SQL_OBTENER_PERFUME_JSON))
                .setParameter("id", id)
                .setTupleTransformer(AliasToEntityMapResultTransformer.INSTANCE)
                .getResultList().get(0);
    }
}
