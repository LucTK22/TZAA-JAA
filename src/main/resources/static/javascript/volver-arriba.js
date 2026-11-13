document.addEventListener("DOMContentLoaded", () => {
    const boton = document.querySelector(".volver-arriba");
    if (!boton) return;

    const actualizarVisibilidad = () => {
        boton.classList.toggle("is-visible", window.scrollY > 280);
    };

    window.addEventListener("scroll", actualizarVisibilidad, { passive: true });
    actualizarVisibilidad();

    boton.addEventListener("click", () => {
        const movimientoReducido = window.matchMedia("(prefers-reduced-motion: reduce)").matches;
        window.scrollTo({ top: 0, behavior: movimientoReducido ? "auto" : "smooth" });
    });
});
