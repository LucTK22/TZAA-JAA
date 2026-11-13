CAMBIOS AÑADIDOS AL PROYECTO TZAA JAA!

Se ha adaptado la parte de carrito del proyecto del profesor a Perfume y al paquete com.example.tienda_perfumes.

Archivos Java nuevos:
- src/main/java/com/example/tienda_perfumes/model/Carrito.java
- src/main/java/com/example/tienda_perfumes/model/ProductoCarrito.java
- src/main/java/com/example/tienda_perfumes/servicios/ServicioCarrito.java
- src/main/java/com/example/tienda_perfumes/serviciosImpl/ServicioCarritoImplJPA.java
- src/main/java/com/example/tienda_perfumes/controladoresREST/CarritoREST.java

Archivos existentes modificados:
- src/main/java/com/example/tienda_perfumes/controladoresREST/UsuariosREST.java: añadido identificarUsuario y guardado de usuario en sesión.
- src/main/resources/static/index.html: añadido flujo de identificación y petición para añadir al carrito.
- src/main/resources/static/plantillas_html/listado_productos.html: cantidad y acción de añadir al carrito.
- src/main/resources/static/plantillas_html/detalles_producto.html: cantidad y acción de añadir al carrito.

Archivo nuevo de plantilla:
- src/main/resources/static/plantillas_html/identificar_usuario.html

IMPORTANTE:
- No se han modificado los CSS ni las imágenes.
- El archivo data/base_de_datos.mv.db se ha conservado sin cambios.
- Como en la versión actual del profesor, consultar/mostrar el contenido del carrito aún está pendiente. El botón CARRITO avisa de ello; la operación de añadir perfumes sí está conectada.
- No se ha cambiado el pom.xml ni la configuración de Java del proyecto.
