package med.voll.api.domain.medico;

import med.voll.api.domain.especialidade.Especialidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByStatusTrue(Pageable paginacao);

    @Query("""
            SELECT m.status FROM Medico m
            WHERE m.id = :id
            """)
    Boolean findStatusById(Long id);

    @Query("""
            SELECT m FROM Medico m
            WHERE m.status = false
                AND m.especialidade = :especialidade
                AND m.id not in (
                    SELECT c.medico.id FROM Consulta c
                    where
                    c.dataAgendamento = :dataAgendamento
                )
            ORDER BY rand()
            LIMIT 1
            """)
    Medico escolherMedicoAleatorio(Especialidade especialidade, LocalDateTime dataAgendamento);

}
