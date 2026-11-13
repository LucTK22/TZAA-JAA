package com.example.tienda_perfumes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "tabla_perfumes")
public class Perfume {

    @Size(min = 3, max = 40, message = "el nombre debe tener entre 3 y 40 caracteres")
    @NotEmpty(message = "debes insertar un nombre")
    @Pattern(
            regexp = "[a-z+áéíóúñA-ZÁÉÍÓÚÑUüÜ 0-9]+",
            message = "el nombre solo puede tener letras numeros y espacios"
    )
    private String nombre;

    @NotNull(message = "debes indicar una marca")
    private String marca;

    private String genero;

    @Min(value = 1, message = "precio minimo 1 euro")
    @Max(value = 999999, message = "el precio maximo es 999999 euros")
    private double precio;

    @Min(value = 1, message = "los mililitros deben ser mayores que 0")
    @Max(value = 10000, message = "los mililitros son demasiado altos")
    private int mililitros;

    @Lob
    private String descripcion;

    private String sku; //stock keeping unit //numero de control del producto

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Transient
    private MultipartFile fotoSubida;

    @Lob
    private byte[] imagenPortada;

    @Transient
    private MultipartFile fondoSubido;

    @Lob
    private byte[] imagenFondo;

    @Column(length = 100)
    private String tipoImagenFondo;

    @ManyToOne
    private Categoria categoria;

    @Transient
    private int idCategoria;

    public Perfume() {}

    public Perfume(String nombre, String marca, String genero, double precio, int mililitros, String descripcion, String sku) {
        this.nombre = nombre;
        this.marca = marca;
        this.genero = genero;
        this.precio = precio;
        this.mililitros = mililitros;
        this.descripcion = descripcion;
        this.sku = sku;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getMililitros() { return mililitros; }
    public void setMililitros(int mililitros) { this.mililitros = mililitros; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public MultipartFile getFotoSubida() { return fotoSubida; }
    public void setFotoSubida(MultipartFile fotoSubida) { this.fotoSubida = fotoSubida; }

    public byte[] getImagenPortada() { return imagenPortada; }
    public void setImagenPortada(byte[] imagenPortada) { this.imagenPortada = imagenPortada; }

    public MultipartFile getFondoSubido() { return fondoSubido; }
    public void setFondoSubido(MultipartFile fondoSubido) { this.fondoSubido = fondoSubido; }

    public byte[] getImagenFondo() { return imagenFondo; }
    public void setImagenFondo(byte[] imagenFondo) { this.imagenFondo = imagenFondo; }

    public String getTipoImagenFondo() { return tipoImagenFondo; }
    public void setTipoImagenFondo(String tipoImagenFondo) { this.tipoImagenFondo = tipoImagenFondo; }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        return "Perfume{" +
                "nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", genero='" + genero + '\'' +
                ", precio=" + precio +
                ", mililitros=" + mililitros +
                ", descripcion='" + descripcion + '\'' +
                ", id=" + id +
                '}';
    }
}
