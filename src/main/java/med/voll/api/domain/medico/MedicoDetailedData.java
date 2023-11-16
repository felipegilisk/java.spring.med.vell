package med.voll.api.domain.medico;

import med.voll.api.domain.endereco.Endereco;
import med.voll.api.domain.especialidade.Especialidade;

public record MedicoDetailedData(Long id, String nome, String email, String crm, String telefone, Especialidade especialidade, Endereco endereco) {

    public MedicoDetailedData(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
