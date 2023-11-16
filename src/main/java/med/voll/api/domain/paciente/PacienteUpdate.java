package med.voll.api.domain.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.EnderecoData;

public record PacienteUpdate(
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoData endereco) {
}
