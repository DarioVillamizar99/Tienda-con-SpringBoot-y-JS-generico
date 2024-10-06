package com.entornos.tienda.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = Usuario.TABLE_NAME)
public class Usuario {

    public static final String TABLE_NAME = "usuario";

    /*--------------------------------------------------------
     * @id para identificar la llave primaria
     * @GenerateValue para que sea autoincremental el id
    --------------------------------------------------------*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*-----------------------------------------------------------------------------
      * @ManyToOne hace referencia a la relacion muchos a uno en este caso
       muchos usuarios tienen un tipo de documento
      * @JoinColumn el campo que hace la referencia a la llave foranea
    --------------------------------------------------------------------------------*/

    @ManyToOne
    @JoinColumn(name = "idTipoDocumento")
    private Tipodocumento idTipodocumento;

    /*-----------------------------------------------------------------------------
       * @Column nombre de la columna, si el nombre en la base de datos del
       campo es igual a el de la variable no es necesario porner la anotacion
     --------------------------------------------------------------------------------- */
    @NotNull(message = "Este campo no puede ser nulo")
    @NotEmpty(message = "Este campo no puede estar vacío")
    @NotBlank(message = "Este campo no puede estar en blanco")
    @Size(min = 8, max = 10, message = "Debe tener entre 8 y 10 caracteres")
    @Positive(message = "El valor debe ser positivo")
    @Pattern(regexp = "\\d+", message = "El campo solo debe contener números")
    @Column(name = "numeroDocumento")
    private String numeroDocumento;

    @NotNull(message = "Este campo no puede ser nulo")
    @NotEmpty(message = "Este campo no puede estar vacío")
    @NotBlank(message = "Este campo no puede estar en blanco")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "El campo solo debe contener letras")
    @Column(name = "nombre")
    private String nombre;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,20}$", 
        message = "La contraseña debe tener entre 8 y 20 caracteres,"
            +
            "y debe incluir al menos una letra mayúscula, una minúscula, un número" +
            "y un carácter especial (@#$%^&+=)")
    @NotNull(message = "Este campo no puede ser nulo")
    @NotEmpty(message = "Este campo no puede estar vacío")
    @NotBlank(message = "Este campo no puede estar en blanco")
    @Column(name = "password")
    private String password;
    
    @NotNull(message = "Este campo no puede ser nulo")
    @NotEmpty(message = "Este campo no puede estar vacío")
    @NotBlank(message = "Este campo no puede estar en blanco")
    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    @NotNull(message="Este campo no puede ser nulo")
    @NotEmpty(message = "Este campo no puede estar vacío")
    @NotBlank(message = "Este campo no puede estar en blanco")
    @Email(message = "Debe ser un correo electrónico válido")
    @Column(name = "email")
    private String email;

    /*------------------------------Constructores----------------------*/

    public Usuario() {

    }

    public Usuario(Long id, Tipodocumento idTipodocumento,
            String numeroDocumento, String nombre, String password,
            String nombreUsuario, String email) {

        this.id = id;
        this.idTipodocumento = idTipodocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.password = password;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
    }

    /*-------------------Metdoos Getters and Setters---------------------- */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tipodocumento getIdTipodocumento() {
        return idTipodocumento;
    }

    public void setIdTipodocumento(Tipodocumento idTipodocumento) {
        this.idTipodocumento = idTipodocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
