package med.voll.api.domain.especialidade;

import jakarta.validation.constraints.NotBlank;

public record EspecialidadeData(
    @NotBlank
    String nome,
    String descricao,
    boolean status
    ) {

    public EspecialidadeData (Especialidade especialidade){
        this(especialidade.getNome(), especialidade.getDescricao(), especialidade.getStatus());
    }
}
