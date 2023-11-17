package med.voll.api.domain.especialidade;

import jakarta.validation.constraints.NotNull;

public record EspecialidadeUpdate(
        @NotNull
        Long id,
        String descricao) {

}
