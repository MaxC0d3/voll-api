package med.voll.api.direction;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataDirection(@NotBlank String street, @NotNull int number, @NotBlank String complement, @NotBlank String city, @NotBlank String state){

}
