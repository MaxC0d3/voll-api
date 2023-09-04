package med.voll.api.direction;

import jakarta.validation.constraints.NotBlank;

public record DataDirection(@NotBlank String street, @NotBlank int number, @NotBlank String complement, @NotBlank String city, @NotBlank String state){

}
