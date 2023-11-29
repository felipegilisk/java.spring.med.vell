package med.voll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.especialidade.Especialidade;

import java.time.LocalDateTime;

public record AgendamentoConsultaData(
    Long idMedico,
    @NotNull
    Long idPaciente,
    @NotNull
    @Future
    LocalDateTime dataAgendamento,
    Especialidade especialidade){
}
