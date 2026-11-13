package com.example.tienda_perfumes.controladorImagen;

import com.example.tienda_perfumes.servicios.ServicioPerfumes;
import com.example.tienda_perfumes.model.Perfume;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.text.Normalizer;
import java.util.Locale;
import java.util.Map;

@Controller
public class ControladorImagen {

    // Fondos editoriales separados de las fotos pequeñas usadas en el catálogo.
    // El nombre se relaciona con el SKU, así cada perfume puede tener su propia escena.
    private static final Map<String, String> FONDOS_POR_SKU = Map.of(
            "BR540-200", "fondo_baccarat_rouge_540.png",
            "GS-200", "fondo_grand_soir.png",
            "BR540-EDP-200", "fondo_baccarat_rouge_540_eau_de_parfum.png",
            "OSM-200", "fondo_oud_satin_mood.png",
            "OSM-EXT-200", "fondo_oud_satin_mood_extrait.png",
            "GFG-200", "fondo_gentle_fluidity_gold.png"
    );

    @Autowired
    private ServicioPerfumes servicioPerfumes;

    @RequestMapping("mostrar_imagen")
    public void mostrarImagen(@RequestParam("id") Long id,
                              HttpServletResponse response) throws IOException {

        byte[] info =
                servicioPerfumes.obtenerPerfumePorId(id).getImagenPortada();

        if (info == null){
            return;
        }

        response.setContentType("image/jpeg");
        response.getOutputStream().write(info);
        response.getOutputStream().close();
    }

    @RequestMapping("mostrar_fondo")
    public void mostrarFondo(@RequestParam("id") Long id,
                              HttpServletResponse response) throws IOException {
        Perfume perfume = servicioPerfumes.obtenerPerfumePorId(id);
        if (perfume == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // Primero se identifica por nombre para que las diferencias de SKU no hagan
        // que la ficha vuelva a mostrar una imagen antigua y recortada de la base de datos.
        String nombreFondo = resolverFondoPorNombre(perfume.getNombre());

        // Si el nombre no corresponde a uno de los fondos conocidos, se prueba el SKU.
        String sku = perfume.getSku();
        if (nombreFondo == null && sku != null) nombreFondo = FONDOS_POR_SKU.get(sku);
        if (nombreFondo != null) {
            ClassPathResource imagen = new ClassPathResource(
                    "static/images/fondos_perfumes/" + nombreFondo);
            if (imagen.exists()) {
                byte[] fondo;
                try (var entrada = imagen.getInputStream()) {
                    fondo = IOUtils.toByteArray(entrada);
                }
                response.setContentType("image/png");
                response.setContentLength(fondo.length);
                response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
                response.getOutputStream().write(fondo);
                return;
            }
        }

        byte[] info = perfume.getImagenFondo();
        String tipo = perfume.getTipoImagenFondo();
        if (info == null || info.length == 0) {
            info = perfume.getImagenPortada();
            tipo = "image/jpeg";
        }
        if (info == null || info.length == 0) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        response.setContentType(tipo == null || tipo.isBlank() ? "image/jpeg" : tipo);
        response.setContentLength(info.length);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.getOutputStream().write(info);
    }

    private String resolverFondoPorNombre(String nombrePerfume) {
        if (nombrePerfume == null || nombrePerfume.isBlank()) return null;

        String nombre = Normalizer.normalize(nombrePerfume, Normalizer.Form.NFD)
                .replaceAll("\\p{M}+", "")
                .replace("'", " ")
                .replace("’", " ")
                .toLowerCase(Locale.ROOT);

        if (nombre.contains("baccarat rouge 540")
                && (nombre.contains("edp") || nombre.contains("eau de parfum"))) {
            return "fondo_baccarat_rouge_540_eau_de_parfum.png";
        }
        if (nombre.contains("oud satin mood") && nombre.contains("extrait")) {
            return "fondo_oud_satin_mood_extrait.png";
        }
        if (nombre.contains("oud satin mood")) return "fondo_oud_satin_mood.png";
        if (nombre.contains("grand soir")) return "fondo_grand_soir.png";
        if (nombre.contains("gentle fluidity gold")) return "fondo_gentle_fluidity_gold.png";
        if (nombre.contains("absolue pour le soir")) return "fondo_absolue_pour_le_soir.png";
        if (nombre.contains("reflets d ambre")) return "fondo_reflets_d_ambre.png";
        if (nombre.contains("baccarat rouge 540")) return "fondo_baccarat_rouge_540.png";
        return null;
    }
}
