package med.voll.api.domain.medico;

import med.voll.api.domain.especialidade.Especialidade;

public record MedicoListData(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public MedicoListData(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
