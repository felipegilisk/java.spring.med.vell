package med.voll.api.domain.consulta.validations;

import med.voll.api.domain.consulta.AgendamentoConsultaData;

public interface BookingValidator {

    void validate(AgendamentoConsultaData bookingData);
}
