package med.voll.api.domain.consulta.validations;

import med.voll.api.domain.consulta.AgendamentoConsultaData;
import med.voll.api.domain.exception.ValidacaoException;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActivePatientValidation implements BookingValidator {

    @Autowired
    private PacienteRepository repository;

    public void validate (AgendamentoConsultaData bookingData) {
        var patientIsActive = repository.findStatusById(bookingData.idPaciente());
        if (!patientIsActive) {
            throw new ValidacaoException("Paciente encontra-se com o status [inativo]");
        }
    }
}
