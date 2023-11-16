package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.EnderecoData;
import med.voll.api.domain.especialidade.Especialidade;

public record MedicoData(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotNull
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotBlank
        @Pattern(regexp = "[(][1-9]{2}[)][\\s]?[9]?[2-9]{1}[0-9]{3}[-][0-9]{4}")
        String telefone,
        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid
        EnderecoData endereco) {

}
