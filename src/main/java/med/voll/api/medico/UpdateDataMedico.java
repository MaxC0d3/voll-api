package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.direction.DataDirection;

public record UpdateDataMedico(@NotNull Long id, String name, String document, DataDirection dataDirection) {
}
