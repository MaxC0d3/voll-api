package med.voll.api.domain.medico.records;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.direction.records.DataDirection;
import med.voll.api.domain.medico.Specialty;

// DTO - Data Transfer Object
public record DataMedico(@NotBlank String name, @NotBlank @Email String email, @NotBlank @Pattern(regexp = "\\d{4,6}") String document, @NotNull Specialty specialty, @NotNull @Valid DataDirection dataDirection, @NotBlank String telephone){

}
