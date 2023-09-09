package med.voll.api.domain.medico.records;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.direction.records.DataDirection;

public record UpdateDataMedico(@NotNull Long id, String telephone, String email, DataDirection dataDirection) {
}
