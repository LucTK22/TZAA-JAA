package com.example.tienda_perfumes.serviciosImpl;

import com.example.tienda_perfumes.constantesPedidos.EstadosPedido;
import com.example.tienda_perfumes.model.Carrito;
import com.example.tienda_perfumes.model.Pedido;
import com.example.tienda_perfumes.model.Perfume;
import com.example.tienda_perfumes.model.ProductoCarrito;
import com.example.tienda_perfumes.model.ProductoPedido;
import com.example.tienda_perfumes.model.Usuario;
import com.example.tienda_perfumes.responseData.ResumenPedido;
import com.example.tienda_perfumes.servicios.ServicioCarrito;
import com.example.tienda_perfumes.servicios.ServicioPedido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ServicioPedidoImplJPA implements ServicioPedido {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ServicioCarrito servicioCarrito;

    @Override
    public List<Pedido> obtenerPedidos() {
        return entityManager.createQuery("SELECT p FROM Pedido p ORDER BY p.id DESC", Pedido.class)
                .getResultList();
    }

    @Override
    public Pedido obtenerPedidoPorId(Long id) {
        return id == null ? null : entityManager.find(Pedido.class, id);
    }

    @Override
    public void actualizarEstadoPedido(Long id, String estado) {
        if (estado == null || estado.trim().isEmpty()) {
            throw new IllegalArgumentException("El estado del pedido es obligatorio.");
        }
        String estadoValidado;
        try {
            estadoValidado = EstadosPedido.valueOf(estado.trim()).name();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("El estado seleccionado no es válido.");
        }
        Pedido pedido = obtenerPedidoPorId(id);
        if (pedido == null) {
            throw new IllegalArgumentException("No se ha encontrado el pedido.");
        }
        pedido.setEstado(estadoValidado);
    }

    @Override
    public void procesarPaso1(String nombreCompleto, String direccion, String provincia,
                              String localidad, String codigoPostal, String telefono, String correo, int idUsuario) {
        validarTexto(nombreCompleto, "El nombre completo");
        validarTexto(direccion, "La dirección");
        validarTexto(provincia, "La provincia");
        validarTexto(localidad, "La localidad");
        validarTexto(codigoPostal, "El código postal");
        validarTexto(telefono, "El teléfono");
        validarTexto(correo, "El correo electrónico");
        Pedido pedido = obtenerPedidoActual(idUsuario);
        pedido.setNombreCompleto(nombreCompleto.trim());
        pedido.setDireccion(direccion.trim());
        pedido.setProvincia(provincia.trim());
        pedido.setLocalidad(localidad.trim());
        pedido.setCodigoPostal(codigoPostal.trim());
        pedido.setTelefonoContacto(telefono.trim());
        pedido.setCorreoContacto(correo.trim());
        if (pedido.getId() == null) {
            entityManager.persist(pedido);
        } else {
            entityManager.merge(pedido);
        }
    }

    @Override
    public void procesarPaso2(String titular, String numero, String tipoTarjeta, int idUsuario) {
        validarTexto(titular, "El titular de la tarjeta");
        validarTexto(numero, "El número de tarjeta");
        validarTexto(tipoTarjeta, "El tipo de tarjeta");
        Pedido pedido = obtenerPedidoActual(idUsuario);
        if (pedido.getNombreCompleto() == null || pedido.getDireccion() == null ||
                pedido.getProvincia() == null || pedido.getCodigoPostal() == null) {
            throw new IllegalStateException("Completa primero los datos de envío.");
        }
        String numeroLimpio = numero.replaceAll("\\s+", "");
        if (!numeroLimpio.matches("[0-9]{12,19}")) {
            throw new IllegalArgumentException("El número de tarjeta debe contener entre 12 y 19 dígitos.");
        }
        pedido.setTitularTarjeta(titular.trim());
        pedido.setTipoTarjeta(tipoTarjeta.trim());
        // No guardamos el número completo de la tarjeta en la base de datos.
        pedido.setUltimosCuatroTarjeta(numeroLimpio.substring(numeroLimpio.length() - 4));
        if (pedido.getId() == null) {
            entityManager.persist(pedido);
        } else {
            entityManager.merge(pedido);
        }
    }

    @Override
    public ResumenPedido obtenerResumenPedido(int idUsuario) {
        Pedido pedido = obtenerPedidoActual(idUsuario);
        ResumenPedido resumen = new ResumenPedido();
        resumen.setIdPedido(pedido.getId());
        resumen.setNombreCompleto(pedido.getNombreCompleto());
        resumen.setDireccion(pedido.getDireccion());
        resumen.setProvincia(pedido.getProvincia());
        resumen.setLocalidad(pedido.getLocalidad());
        resumen.setCodigoPostal(pedido.getCodigoPostal());
        resumen.setTelefono(pedido.getTelefonoContacto());
        resumen.setCorreo(pedido.getCorreoContacto());
        resumen.setEsRegalo(pedido.getEsRegalo());
        resumen.setTitularTarjeta(pedido.getTitularTarjeta());
        resumen.setTipoTarjeta(pedido.getTipoTarjeta());
        resumen.setUltimosCuatroTarjeta(pedido.getUltimosCuatroTarjeta());
        List<Map<String, Object>> perfumes = servicioCarrito.obtenerProductosCarrito(idUsuario);
        resumen.setPerfumes(perfumes);
        double total = 0;
        for (Map<String, Object> perfume : perfumes) {
            Object subtotal = perfume.get("SUBTOTAL");
            if (subtotal instanceof Number) total += ((Number) subtotal).doubleValue();
        }
        resumen.setTotal(total);
        return resumen;
    }

    @Override
    public void procesarRegalo(boolean esRegalo, int idUsuario) {
        Pedido pedido = obtenerPedidoActual(idUsuario);
        if (pedido.getTitularTarjeta() == null || pedido.getTipoTarjeta() == null) {
            throw new IllegalStateException("Completa primero los datos de pago.");
        }
        pedido.setEsRegalo(esRegalo);
        if (pedido.getId() == null) entityManager.persist(pedido);
        else entityManager.merge(pedido);
    }

    @Override
    public Long confirmarPedido(int idUsuario) {
        Pedido pedido = obtenerPedidoActual(idUsuario);
        if (pedido.getNombreCompleto() == null || pedido.getDireccion() == null ||
                pedido.getProvincia() == null || pedido.getCodigoPostal() == null) {
            throw new IllegalStateException("Faltan los datos de envío.");
        }
        if (pedido.getTipoTarjeta() == null || pedido.getTitularTarjeta() == null ||
                pedido.getUltimosCuatroTarjeta() == null) {
                throw new IllegalStateException("Faltan los datos de pago.");
        }
        if (pedido.getEsRegalo() == null) throw new IllegalStateException("Indica si el pedido es para regalo.");

        List<Carrito> carritos = entityManager.createQuery(
                "SELECT c FROM Carrito c WHERE c.usuario.id = :idUsuario", Carrito.class)
                .setParameter("idUsuario", idUsuario).getResultList();
        if (carritos.isEmpty()) throw new IllegalStateException("No se ha encontrado el carrito.");
        Carrito carrito = carritos.get(0);
        if (carrito.getProductosCarrito().isEmpty()) {
            throw new IllegalStateException("El carrito está vacío.");
        }

        // Persistir el pedido antes de las líneas para asegurar su identificador.
        if (pedido.getId() == null) entityManager.persist(pedido);
        for (ProductoCarrito productoCarrito : new ArrayList<>(carrito.getProductosCarrito())) {
            Perfume perfume = productoCarrito.getPerfume();
            if (perfume == null) continue;
            ProductoPedido linea = new ProductoPedido();
            linea.setPedido(pedido);
            linea.setPerfume(perfume);
            linea.setCantidad(productoCarrito.getCantidad());
            linea.setPrecioUnitario(perfume.getPrecio());
            pedido.getProductosPedido().add(linea);
            entityManager.persist(linea);
            entityManager.remove(productoCarrito);
        }
        pedido.setEstado(EstadosPedido.Completado.name());
        entityManager.merge(pedido);
        return pedido.getId();
    }

    private Pedido obtenerPedidoActual(int idUsuario) {
        List<Pedido> pedidos = entityManager.createQuery(
                "SELECT p FROM Pedido p WHERE p.estado = :estado AND p.usuario.id = :idUsuario ORDER BY p.id DESC",
                Pedido.class)
                .setParameter("estado", EstadosPedido.EnProceso.name())
                .setParameter("idUsuario", idUsuario).getResultList();
        if (!pedidos.isEmpty()) return pedidos.get(0);

        Usuario usuario = entityManager.find(Usuario.class, idUsuario);
        if (usuario == null) throw new IllegalArgumentException("No se ha encontrado el usuario.");
        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setEstado(EstadosPedido.EnProceso.name());
        return pedido;
    }

    private void validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " es obligatorio.");
        }
    }
}
