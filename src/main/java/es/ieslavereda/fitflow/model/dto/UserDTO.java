package es.ieslavereda.fitflow.model.dto;

import es.ieslavereda.fitflow.model.enums.PaymentFrequency;
import es.ieslavereda.fitflow.model.enums.UserStatus;
import java.time.LocalDate;

public class UserDTO {
    private Long id;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String direccion;
    private PaymentFrequency frecuenciaPago;
    private Integer nivelGamificacion;
    private UserStatus estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
