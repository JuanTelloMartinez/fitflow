package es.ieslavereda.fitflow.model.entity;

import es.ieslavereda.fitflow.model.enums.PaymentFrequency;
import es.ieslavereda.fitflow.model.enums.UserStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellidos;

    private String email;

    private String telefono;

    private LocalDate fechaNacimiento;

    private String direccion;

    @Enumerated(EnumType.STRING)
    private PaymentFrequency frecuenciaPago = PaymentFrequency.MENSUAL;

    private Integer nivelGamificacion = 0;

    @Enumerated(EnumType.STRING)
    private UserStatus estado = UserStatus.ACTIVO;

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
