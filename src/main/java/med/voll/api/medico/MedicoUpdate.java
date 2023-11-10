package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.EnderecoData;

public record MedicoUpdate(
        @NotNull
        Long id,
        String nome,
        @Pattern(regexp = "[(][1-9]{2}[)][\\s]?[9]?[2-9]{1}[0-9]{3}[-][0-9]{4}")
        String telefone,
        EnderecoData endereco) {

}
