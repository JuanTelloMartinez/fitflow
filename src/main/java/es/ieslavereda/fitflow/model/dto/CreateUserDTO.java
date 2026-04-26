package es.ieslavereda.fitflow.model.dto;

import es.ieslavereda.fitflow.model.enums.PaymentFrequency;
import es.ieslavereda.fitflow.model.enums.UserStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;

public class CreateUserDTO {
    @NotBlank
    private String nombre;

    @NotBlank
    private String apellidos;

    @Email
    @NotBlank
    private String email;

    private String telefono;

    @Past
    private LocalDate fechaNacimiento;

    private String direccion;

    @NotNull
    private PaymentFrequency frecuenciaPago;

    private Integer nivelGamificacion;

    @NotNull
    private UserStatus estado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public PaymentFrequency getFrecuenciaPago() {
        return frecuenciaPago;
    }

    public void setFrecuenciaPago(PaymentFrequency frecuenciaPago) {
        this.frecuenciaPago = frecuenciaPago;
    }

    public Integer getNivelGamificacion() {
        return nivelGamificacion;
    }

    public void setNivelGamificacion(Integer nivelGamificacion) {
        this.nivelGamificacion = nivelGamificacion;
    }

    public UserStatus getEstado() {
        return estado;
    }

    public void setEstado(UserStatus estado) {
        this.estado = estado;
    }
}
