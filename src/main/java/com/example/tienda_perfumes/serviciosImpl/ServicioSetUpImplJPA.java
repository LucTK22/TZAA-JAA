package com.example.tienda_perfumes.serviciosImpl;

import com.example.tienda_perfumes.model.Categoria;
import com.example.tienda_perfumes.model.Configuracion;
import com.example.tienda_perfumes.model.Perfume;
import com.example.tienda_perfumes.servicios.ServicioSetUp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Service
@Transactional
public class ServicioSetUpImplJPA implements ServicioSetUp {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void prepararRegistrosIniciales(){
        // preparar unos registros si la bd esta vacia
        Configuracion configuracion = null;
        // la idea presentada se basa que va a haber un solo registro
        // en la tabla de Configuracion , ese registro nos indicara
        // si la base de datos ya tiene sus registros iniciales
        // como por ejemplo : productos , categorias , usuarios , pedidos etc.

        //en sql seria como : sselect * from configuracion as c
        try {
            configuracion =
                    (Configuracion)
                            entityManager.createQuery(
                                            "select c from Configuracion c").
                                    getSingleResult();
        }catch (NoResultException e){
            System.out.println(
                    "no se encontro un unico registro en la tabla de Configuracion");
        }
        if( configuracion == null || ! configuracion.isRegistrosIniciales() ){
            //hago todos los registros iniciales
            //categorias
            Categoria cFloral = new Categoria("FL", "floral");
            Categoria cAmaderada = new Categoria("AM", "amaderada");
            Categoria cCitrica = new Categoria("CI", "cítrica");
            Categoria cOriental = new Categoria("OR", "oriental");
            entityManager.persist(cFloral);
            entityManager.persist(cAmaderada);
            entityManager.persist(cCitrica);
            entityManager.persist(cOriental);
            // productos

            // productos

            Perfume v1 = new Perfume(
                    "Baccarat Rouge 540",
                    "Maison Francis Kurkdjian",
                    "Unisex",
                    746,
                    200,
                    "Perfume floral y amaderado con notas de azafran, jazmin, cedro y ambroxan.",
                    "BR540-200"
            );
            v1.setCategoria(cFloral);
            v1.setImagenPortada(leerImagenInicial(
                    "http://localhost:8080/imagenes_productos_iniciales/p1.jpg"));
            entityManager.persist(v1);


            Perfume v2 = new Perfume(
                    "Grand Soir",
                    "Maison Francis Kurkdjian",
                    "Masculino",
                    395,
                    200,
                    "Perfume oriental y ambarado con notas calidas de vainilla, benjui y ambar.",
                    "GS-200"
            );
            v2.setCategoria(cOriental);
            v2.setImagenPortada(leerImagenInicial(
                    "http://localhost:8080/imagenes_productos_iniciales/p2.jpg"));
            entityManager.persist(v2);


            Perfume v3 = new Perfume(
                    "Baccarat Rouge 540 Eau de Parfum",
                    "Maison Francis Kurkdjian",
                    "Unisex",
                    520,
                    200,
                    "Fragancia floral y amaderada con notas de jazmin, azafran, cedro y almizcle.",
                    "BR540-EDP-200"
            );
            v3.setCategoria(cFloral);
            v3.setImagenPortada(leerImagenInicial(
                    "http://localhost:8080/imagenes_productos_iniciales/p3.jpg"));
            entityManager.persist(v3);


            Perfume v4 = new Perfume(
                    "Oud Satin Mood",
                    "Maison Francis Kurkdjian",
                    "Unisex",
                    390,
                    200,
                    "Perfume oriental y amaderado con notas de oud, rosa, violeta y vainilla.",
                    "OSM-200"
            );
            v4.setCategoria(cAmaderada);
            v4.setImagenPortada(leerImagenInicial(
                    "http://localhost:8080/imagenes_productos_iniciales/p4.jpg"));
            entityManager.persist(v4);


            Perfume v5 = new Perfume(
                    "Oud Satin Mood Extrait",
                    "Maison Francis Kurkdjian",
                    "Unisex",
                    450,
                    200,
                    "Fragancia intensa con notas de oud, rosa, violeta y acordes ambarados.",
                    "OSM-EXT-200"
            );
            v5.setCategoria(cAmaderada);
            v5.setImagenPortada(leerImagenInicial(
                    "http://localhost:8080/imagenes_productos_iniciales/p5.jpg"));
            entityManager.persist(v5);


            Perfume v6 = new Perfume(
                    "Gentle Fluidity Gold",
                    "Maison Francis Kurkdjian",
                    "Unisex",
                    235,
                    200,
                    "Fragancia floral y ambarada con notas de vainilla, almizcle, cilantro y enebro.",
                    "GFG-200"
            );
            v6.setCategoria(cFloral);
            v6.setImagenPortada(leerImagenInicial(
                    "http://localhost:8080/imagenes_productos_iniciales/p6.jpg"));
            entityManager.persist(v6);


            //una vez realizados los registros iniciales
            //guardo un registro en la tabla Configuracion
            //indicando que todo esta ok
            configuracion = new Configuracion();
            configuracion.setRegistrosIniciales(true);
            entityManager.persist(configuracion);

        }//end if

        asignarFondoInicialBaccarat();
    }//end prepararRegistrosIniciales

    private void asignarFondoInicialBaccarat() {
        try {
            Perfume baccarat = (Perfume) entityManager.createQuery(
                            "select p from Perfume p where p.sku = :sku")
                    .setParameter("sku", "BR540-200")
                    .getSingleResult();
            if (baccarat.getImagenFondo() == null) {
                ClassPathResource imagen = new ClassPathResource(
                    "static/images/fondos_perfumes/fondo_baccarat_rouge_540.png");
                try (var entrada = imagen.getInputStream()) {
                    baccarat.setImagenFondo(IOUtils.toByteArray(entrada));
                    baccarat.setTipoImagenFondo("image/png");
                }
            }
        } catch (NoResultException e) {
            // La tienda aún no tiene cargado el perfume de ejemplo.
        } catch (IOException e) {
            throw new RuntimeException("No se pudo cargar el fondo inicial de Baccarat Rouge 540", e);
        }
    }

    private byte[] leerImagenInicial(String ruta_imagen){
        byte[] info = null;
        try {
            URL url = new URL(ruta_imagen);
            info = IOUtils.toByteArray(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return info;
    }

}//end class
