package com.example.tienda_perfumes.serviciosImpl;

import com.example.tienda_perfumes.model.Carrito;
import com.example.tienda_perfumes.model.Perfume;
import com.example.tienda_perfumes.model.ProductoCarrito;
import com.example.tienda_perfumes.model.Usuario;
import com.example.tienda_perfumes.servicios.ServicioCarrito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ServicioCarritoImplJPA implements ServicioCarrito {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void agregarProducto(int idUsuario, long idPerfume, int cantidad) {
        if (cantidad < 1) {
            throw new IllegalArgumentException("La cantidad debe ser como mínimo 1.");
        }

        Usuario usuario = entityManager.find(Usuario.class, idUsuario);
        if (usuario == null) {
            throw new IllegalArgumentException("No se ha encontrado el usuario.");
        }

        // getResultList evita la excepción que produciría getSingleResult
        // cuando el usuario todavía no tiene un carrito.
        List<Carrito> carritos = entityManager.createQuery(
                        "SELECT c FROM Carrito c WHERE c.usuario.id = :idUsuario",
                        Carrito.class)
                .setParameter("idUsuario", idUsuario)
                .getResultList();

        Carrito carrito;
        if (carritos.isEmpty()) {
            carrito = new Carrito();
            carrito.setUsuario(usuario);
            entityManager.persist(carrito);
        } else {
            carrito = carritos.get(0);
        }

        Perfume perfume = entityManager.find(Perfume.class, idPerfume);
        if (perfume == null) {
            throw new IllegalArgumentException("No se ha encontrado el perfume.");
        }

        for (ProductoCarrito productoCarrito : carrito.getProductosCarrito()) {
            if (productoCarrito.getPerfume().getId() == idPerfume) {
                productoCarrito.setCantidad(productoCarrito.getCantidad() + cantidad);
                return;
            }
        }

        ProductoCarrito productoCarrito = new ProductoCarrito();
        productoCarrito.setCarrito(carrito);
        productoCarrito.setPerfume(perfume);
        productoCarrito.setCantidad(cantidad);
        entityManager.persist(productoCarrito);
    }

    @Override
    public void eliminarProducto(int idUsuario, long idPerfume) {
        List<ProductoCarrito> productos = entityManager.createQuery(
                        "SELECT pc FROM ProductoCarrito pc " +
                                "WHERE pc.carrito.usuario.id = :idUsuario " +
                                "AND pc.perfume.id = :idPerfume",
                        ProductoCarrito.class)
                .setParameter("idUsuario", idUsuario)
                .setParameter("idPerfume", idPerfume)
                .getResultList();

        for (ProductoCarrito producto : productos) {
            entityManager.remove(producto);
        }
    }

    @Override
    public void actualizarCantidad(int idUsuario, long idPerfume, int cantidad) {
        if (cantidad < 1) {
            throw new IllegalArgumentException(
                    "La cantidad debe ser como mínimo 1.");
        }

        List<ProductoCarrito> productos = entityManager.createQuery(
                        "SELECT pc FROM ProductoCarrito pc " +
                                "WHERE pc.carrito.usuario.id = :idUsuario " +
                                "AND pc.perfume.id = :idPerfume",
                        ProductoCarrito.class)
                .setParameter("idUsuario", idUsuario)
                .setParameter("idPerfume", idPerfume)
                .getResultList();

        for (ProductoCarrito producto : productos) {
            producto.setCantidad(cantidad);
        }
    }

    @Override
    public void vaciarCarrito(int idUsuario) {
        List<Carrito> carritos = entityManager.createQuery(
                        "SELECT c FROM Carrito c " +
                                "WHERE c.usuario.id = :idUsuario",
                        Carrito.class)
                .setParameter("idUsuario", idUsuario)
                .getResultList();

        for (Carrito carrito : carritos) {
            carrito.getProductosCarrito().clear();
        }
    }

    @Override
    public List<Map<String, Object>> obtenerProductosCarrito(int idUsuario) {

        List<ProductoCarrito> productos = entityManager.createQuery(
                        "SELECT pc FROM ProductoCarrito pc " +
                                "WHERE pc.carrito.usuario.id = :idUsuario",
                        ProductoCarrito.class)
                .setParameter("idUsuario", idUsuario)
                .getResultList();

        List<Map<String, Object>> resultado = new java.util.ArrayList<>();

        for (ProductoCarrito producto : productos) {
            Map<String, Object> datos = new java.util.HashMap<>();

            datos.put("ID", producto.getPerfume().getId());
            datos.put("NOMBRE", producto.getPerfume().getNombre());
            datos.put("MARCA", producto.getPerfume().getMarca());
            datos.put("PRECIO", producto.getPerfume().getPrecio());
            datos.put("MILILITROS", producto.getPerfume().getMililitros());
            datos.put("CANTIDAD", producto.getCantidad());
            datos.put("SUBTOTAL", producto.getPerfume().getPrecio()
                    * producto.getCantidad());

            resultado.add(datos);
        }

        return resultado;
    }
}