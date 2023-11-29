package med.voll.api.domain.consulta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Boolean existsByMedicoIdAndDataAgendamento(Long id, LocalDateTime dataAgendamento);

    Boolean existsByPacienteIdAndDataAgendamento(Long id, LocalDateTime dataAgendamento);
}
