package med.voll.api.domain.consulta.validations;

import med.voll.api.domain.consulta.AgendamentoConsultaData;
import med.voll.api.domain.exception.ValidacaoException;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActiveDoctorValidation implements BookingValidator {

    @Autowired
    private MedicoRepository repository;

    public void validate (AgendamentoConsultaData bookingData) {
        if (bookingData.idMedico() == null) {
            return ;
        }
        var doctorIsActive = repository.findStatusById(bookingData.idMedico());
        if (!doctorIsActive) {
            throw new ValidacaoException("A(O) Médica(o) selecionada(o) está com o status [inativo]");
        }
    }
}
