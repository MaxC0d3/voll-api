package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.direction.DataDirection;

// DTO - Data Transfer Object
public record DataMedico(@NotBlank String name, @NotBlank @Email String email, @NotBlank @Pattern(regexp = "\\d{4,6}") String document, @NotNull Specialty specialty, @NotNull @Valid DataDirection dataDirection, @NotBlank String telephone){

}
