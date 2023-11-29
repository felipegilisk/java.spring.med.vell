package med.voll.api.domain.consulta.validations;

import med.voll.api.domain.consulta.AgendamentoConsultaData;
import med.voll.api.domain.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class WorktimeValidation implements BookingValidator {

    public void validate(AgendamentoConsultaData bookingData){
        var myDate = bookingData.dataAgendamento();
        var is_sunday = myDate.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var is_too_early = myDate.getHour() < 7;
        var is_too_late = myDate.getHour() > 18;

        if (is_sunday || is_too_early || is_too_late) {
            throw new ValidacaoException("Consulta agedada para fora do horário de funcionamento");
        }
    }
}
