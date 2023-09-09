package med.voll.api.domain.users.records;

import jakarta.validation.constraints.NotBlank;

public record DataAuthUser(@NotBlank String login, @NotBlank String password) {
}
