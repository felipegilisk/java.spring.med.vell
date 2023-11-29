package med.voll.api.domain.consulta.validations;

import med.voll.api.domain.consulta.AgendamentoConsultaData;
import med.voll.api.domain.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class MinimumAdvanceValidation implements BookingValidator {

    public void validate (AgendamentoConsultaData bookingData) {
        var myDate = bookingData.dataAgendamento();
        var now = LocalDateTime.now();
        var differenceInMinutes = Duration.between(now, myDate).toMinutes();

        if (differenceInMinutes < 30) {
            throw new ValidacaoException("A antecedência mínima do agendamento é de 30 minutos!");
        }
    }
}
