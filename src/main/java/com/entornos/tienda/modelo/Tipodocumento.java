package com.entornos.tienda.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity //mapear la clase java como entidad o tabla en la DB
@Table(name=Tipodocumento.TABLE_NAME)
public class Tipodocumento {

    public static final String TABLE_NAME = "tipodocumento";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message="Este campo no puede ser nulo")
    @NotEmpty(message = "Este campo no puede estar vacío")
    @NotBlank(message = "Este campo no puede estar en blanco")
    @Column(name="tipo")
    private String tipo;
    
    //Contructor

    public Tipodocumento() {

    }

    public Tipodocumento(Long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }
    //Metodos Getters ant Setters
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    
}
