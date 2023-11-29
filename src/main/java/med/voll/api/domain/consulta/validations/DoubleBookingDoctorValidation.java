package med.voll.api.domain.consulta.validations;

import med.voll.api.domain.consulta.AgendamentoConsultaData;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoubleBookingDoctorValidation implements BookingValidator {

    @Autowired
    private ConsultaRepository repository;

    public void validate (AgendamentoConsultaData bookingData) {
        var hasDoubleBooking = repository.existsByMedicoIdAndDataAgendamento(bookingData.idMedico(), bookingData.dataAgendamento());
        if (hasDoubleBooking) {
            throw new ValidacaoException("Já existe uma consulta deste médico agendada neste dia e horário!");
        }
    }
}
