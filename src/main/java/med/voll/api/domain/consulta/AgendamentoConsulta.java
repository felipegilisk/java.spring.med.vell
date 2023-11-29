package med.voll.api.domain.consulta;

import med.voll.api.domain.consulta.validations.BookingValidator;
import med.voll.api.domain.exception.ValidacaoException;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<BookingValidator> validatorList;

    public void agendar(AgendamentoConsultaData dados) {
        if (!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("Id do paciente não existe!");
        }

        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("Id do medico não existe!");
        }

        validatorList.forEach(v -> v.validate(dados));

        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = escolherMedico(dados);

        var consulta = new Consulta(null, medico, paciente, dados.dataAgendamento());
        consultaRepository.save(consulta);
    }

    private Medico escolherMedico(AgendamentoConsultaData dados){
        if (dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if (dados.especialidade() == null) {
            throw new ValidacaoException("Especialidade é obrigatória ao não escolher o médico!");
        }

        return medicoRepository.escolherMedicoAleatorio(dados.especialidade(), dados.dataAgendamento());

    }
}
