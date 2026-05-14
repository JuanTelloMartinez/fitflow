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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
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
}
