package med.voll.api.domain.especialidade;

public record EspecialidadeListData(Long id, String nome, String descricao, boolean status) {

    public EspecialidadeListData(Especialidade especialidade){
        this(especialidade.getId(), especialidade.getNome(), especialidade.getDescricao(), especialidade.getStatus());
    }
}
