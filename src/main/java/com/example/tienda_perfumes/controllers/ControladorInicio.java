package com.example.tienda_perfumes.controllers;

import com.example.tienda_perfumes.servicios.ServicioSetUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
public class ControladorInicio {

    //cuando se de la pagina de inicio
    //llamamos al ServicioSetUp para que prepare
    //los registros iniciales si es necesario
    @Autowired
    private ServicioSetUp servicioSetUp;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping({"/", "/index.html"})
    public String inicio(Model model){

        // vamos a llamar a un servicio para asegurar
        // que tengamos unos productos y unas categorias
        // en la base de datos
        servicioSetUp.prepararRegistrosIniciales();

        Locale locale = LocaleContextHolder.getLocale();
        String idioma = locale.getLanguage();
        if (!idioma.equals("en") && !idioma.equals("ja")) idioma = "es";
        model.addAttribute("idiomaActual", idioma);
        model.addAttribute("tituloPagina", messageSource.getMessage("tienda.titulo", null, locale));
        return "index_" + idioma;
    }
}
