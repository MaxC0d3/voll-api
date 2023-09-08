package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.direction.DataDirection;

public record UpdateDataMedico(@NotNull Long id, String telephone, String email, DataDirection dataDirection) {
}
