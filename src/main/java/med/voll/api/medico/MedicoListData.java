package med.voll.api.medico;

public record MedicoListData(String nome, String email, String crm, Especialidade especialidade) {

    public MedicoListData(Medico medico){
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
