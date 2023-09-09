package med.voll.api.domain.direction.records;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataDirection(@NotBlank String street, @NotNull int number, @NotBlank String complement, @NotBlank String city, @NotBlank String state){

}
