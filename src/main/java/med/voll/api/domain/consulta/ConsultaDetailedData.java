package med.voll.api.domain.consulta;

import java.time.LocalDateTime;

public record ConsultaDetailedData(
        Long id,
        Long idMedico,
        Long idPaciente,
        LocalDateTime dataAgendamento) {
}
