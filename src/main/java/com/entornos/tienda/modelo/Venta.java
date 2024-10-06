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
@Table(name=Venta.TABLE_NAME) 
public class Venta {

    public static final String TABLE_NAME = "venta";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="idCliente")
    private Cliente idCliente; //private de tipo cliente porque es la llave foranea

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario idUsuario;

    @NotNull(message = "Este campo no puede ser nulo")
    @NotEmpty(message = "Este campo no puede estar vacío")
    @NotBlank(message = "Este campo no puede estar en blanco")
    @Positive(message = "El valor debe ser positivo")
    @Pattern(regexp = "\\d+", message = "El campo solo debe contener números")
    @Digits(integer = 15, fraction = 2, message = "Debe tener hasta 6 dígitos enteros y 4 decimales")
    @Column(name="ivaVenta")
    private String ivaVenta;

    @NotNull(message = "Este campo no puede ser nulo")
    @NotEmpty(message = "Este campo no puede estar vacío")
    @NotBlank(message = "Este campo no puede estar en blanco")
    @Positive(message = "El valor debe ser positivo")
    @Pattern(regexp = "\\d+", message = "El campo solo debe contener números")
    @Digits(integer = 15, fraction = 2, message = "Debe tener hasta 6 dígitos enteros y 4 decimales")
    @Column(name="totalVenta")
    private String totalVenta;

    @NotNull(message = "Este campo no puede ser nulo")
    @NotEmpty(message = "Este campo no puede estar vacío")
    @NotBlank(message = "Este campo no puede estar en blanco")
    @Positive(message = "El valor debe ser positivo")
    @Pattern(regexp = "\\d+", message = "El campo solo debe contener números")
    @Digits(integer = 15, fraction = 2, message = "Debe tener hasta 6 dígitos enteros y 4 decimales")
    @Column(name="valorVenta")
    private String valorVenta;

    public Venta() {

    }


    public Venta(Long id, Cliente idCliente, Usuario idUsuario, String ivaVenta, String totalVenta, String valorVenta) {
        this.id = id;
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.ivaVenta = ivaVenta;
        this.totalVenta = totalVenta;
        this.valorVenta = valorVenta;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Cliente getIdCliente() {
        return idCliente;
    }


    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }


    public Usuario getIdUsuario() {
        return idUsuario;
    }


    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }


    public String getIvaVenta() {
        return ivaVenta;
    }


    public void setIvaVenta(String ivaVenta) {
        this.ivaVenta = ivaVenta;
    }


    public String getTotalVenta() {
        return totalVenta;
    }


    public void setTotalVenta(String totalVenta) {
        this.totalVenta = totalVenta;
    }


    public String getValorVenta() {
        return valorVenta;
    }


    public void setValorVenta(String valorVenta) {
        this.valorVenta = valorVenta;
    }

    

}
