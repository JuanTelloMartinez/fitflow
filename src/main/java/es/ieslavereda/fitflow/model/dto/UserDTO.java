package es.ieslavereda.fitflow.model.dto;

import es.ieslavereda.fitflow.model.enums.PaymentFrequency;
import es.ieslavereda.fitflow.model.enums.UserStatus;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
}
