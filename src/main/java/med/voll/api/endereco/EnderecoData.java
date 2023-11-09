package med.voll.api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EnderecoData(
        @NotBlank
        String logradouro,
        String numero,
        String complemento,
        @NotBlank
        @Pattern(regexp = "\\d{5}-\\d{3}")
        String cep,
        @NotBlank
        String bairro,
        @NotBlank
        String cidade,
        @NotBlank
        String uf) {

}
