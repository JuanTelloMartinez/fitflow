package es.ieslavereda.fitflow.model.dto;

import es.ieslavereda.fitflow.model.enums.PaymentFrequency;
import es.ieslavereda.fitflow.model.enums.UserStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
}
