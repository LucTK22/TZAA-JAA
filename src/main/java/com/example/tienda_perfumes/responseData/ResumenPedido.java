package com.example.tienda_perfumes.responseData;

import java.util.List;
import java.util.Map;

/** Datos que el navegador necesita para mostrar la confirmación de compra. */
public class ResumenPedido {
    private Long idPedido;
    private String nombreCompleto;
    private String direccion;
    private String provincia;
    private String localidad;
    private String codigoPostal;
    private String telefono;
    private String correo;
    private Boolean esRegalo;
    private String titularTarjeta;
    private String tipoTarjeta;
    private String ultimosCuatroTarjeta;
    private List<Map<String, Object>> perfumes;
    private double total;

    public Long getIdPedido() { return idPedido; }
    public void setIdPedido(Long idPedido) { this.idPedido = idPedido; }
    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getProvincia() { return provincia; }
    public void setProvincia(String provincia) { this.provincia = provincia; }
    public String getLocalidad() { return localidad; }
    public void setLocalidad(String localidad) { this.localidad = localidad; }
    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public Boolean getEsRegalo() { return esRegalo; }
    public void setEsRegalo(Boolean esRegalo) { this.esRegalo = esRegalo; }
    public String getTitularTarjeta() { return titularTarjeta; }
    public void setTitularTarjeta(String titularTarjeta) { this.titularTarjeta = titularTarjeta; }
    public String getTipoTarjeta() { return tipoTarjeta; }
    public void setTipoTarjeta(String tipoTarjeta) { this.tipoTarjeta = tipoTarjeta; }
    public String getUltimosCuatroTarjeta() { return ultimosCuatroTarjeta; }
    public void setUltimosCuatroTarjeta(String ultimosCuatroTarjeta) { this.ultimosCuatroTarjeta = ultimosCuatroTarjeta; }
    public List<Map<String, Object>> getPerfumes() { return perfumes; }
    public void setPerfumes(List<Map<String, Object>> perfumes) { this.perfumes = perfumes; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}
