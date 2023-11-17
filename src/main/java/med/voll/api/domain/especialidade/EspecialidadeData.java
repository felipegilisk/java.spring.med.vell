package med.voll.api.domain.especialidade;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public record EspecialidadeData(
    @Id
    Long id,
    @NotBlank
    String nome,
    String descricao) {

    public EspecialidadeData (Especialidade especialidade){
        this(especialidade.getId(), especialidade.getNome(), especialidade.getDescricao());
    }
}
