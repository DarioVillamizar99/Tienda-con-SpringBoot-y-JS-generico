package com.entornos.tienda.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity 
@Table(name=Producto.TABLE_NAME)
public class Producto {

    public static final String TABLE_NAME = "producto";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="idProveedor")
    private Proveedor idProveedor;

    @NotNull(message = "Este campo no puede ser nulo")
    @NotEmpty(message = "Este campo no puede estar vacío")
    @NotBlank(message = "Este campo no puede estar en blanco")
    @Positive(message = "El valor debe ser positivo")
    @Pattern(regexp = "\\d+", message = "El campo solo debe contener números")
    @Digits(integer = 15, fraction = 2, message = "Debe tener hasta 6 dígitos enteros y 4 decimales")
    @Column(name="ivaCompra")
    private String ivaCompra;

    @NotNull(message="Este campo no puede ser nulo")
    @NotEmpty(message = "Este campo no puede estar vacío")
    @NotBlank(message = "Este campo no puede estar en blanco")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "El campo solo debe contener letras y espacios")
    @Column(name="nombre")
    private String nombre;

    @NotNull(message = "Este campo no puede ser nulo")
    @NotEmpty(message = "Este campo no puede estar vacío")
    @NotBlank(message = "Este campo no puede estar en blanco")
    @Positive(message = "El valor debe ser positivo")
    @Pattern(regexp = "\\d+", message = "El campo solo debe contener números")
    @Digits(integer = 15, fraction = 2, message = "Debe tener hasta 6 dígitos enteros y 4 decimales")
    @Column(name="precioCompra")
    private String precioCompra;

    @NotNull(message = "Este campo no puede ser nulo")
    @NotEmpty(message = "Este campo no puede estar vacío")
    @NotBlank(message = "Este campo no puede estar en blanco")
    @Positive(message = "El valor debe ser positivo")
    @Pattern(regexp = "\\d+", message = "El campo solo debe contener números")
    @Digits(integer = 15, fraction = 2, message = "Debe tener hasta 6 dígitos enteros y 4 decimales")
    @Column(name="precioVenta")
    private String precioVenta;

    public Producto() {

    }

    public Producto(Long id, Proveedor idProveedor, String ivaCompra, String nombre,
        String precioCompra,String precioVenta) {
        this.id = id;
        this.idProveedor = idProveedor;
        this.ivaCompra = ivaCompra;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getIvaCompra() {
        return ivaCompra;
    }

    public void setIvaCompra(String ivaCompra) {
        this.ivaCompra = ivaCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(String precioCompra) {
        this.precioCompra = precioCompra;
    }

    public String getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(String precioVenta) {
        this.precioVenta = precioVenta;
    }

    
}

