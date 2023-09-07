package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.direction.DataDirection;

public record UpdateDataMedico(@NotNull Long id, String telephone, String email, DataDirection dataDirection) {
}
