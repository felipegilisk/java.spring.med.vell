package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.EnderecoData;
import med.voll.api.domain.especialidade.Especialidade;

public record MedicoData(
        @NotBlank(message = "Campo obrigatório, não pode estar vazio")
        String nome,
        @NotBlank(message = "Campo obrigatório, não pode estar vazio")
        @Email(message = "Formato do e-mail inválido")
        String email,
        @NotNull(message = "Campo obrigatório")
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotBlank(message = "Campo obrigatório, não pode estar vazio")
        @Pattern(regexp = "[(][1-9]{2}[)][\\s]?[9]?[2-9]{1}[0-9]{3}[-][0-9]{4}", message = "Formato inválido! Padrão: (XX) [X]XXXX-XXXX")
        String telefone,
        @NotNull(message = "Campo obrigatório")
        Especialidade especialidade,
        @NotNull(message = "Campo obrigatório")
        @Valid
        EnderecoData endereco) {

}
