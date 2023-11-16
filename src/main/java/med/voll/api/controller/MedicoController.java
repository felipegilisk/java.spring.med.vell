package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.especialidade.EspecialidadeRepository;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoListData;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repositoryMed;

    @Autowired
    private EspecialidadeRepository repositoryEsp;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid MedicoData novoMed, UriComponentsBuilder uriBuilder) {
        Medico medicoCriado = new Medico(novoMed);
        repositoryMed.save(medicoCriado);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medicoCriado.getId()).toUri();

        return ResponseEntity.created(uri).body(new MedicoDetailedData(medicoCriado));
    }

    @GetMapping
    public ResponseEntity<Page<MedicoListData>> listar(@PageableDefault(size = 10, sort = {"especialidade"}) Pageable paginacao) {
        var page = repositoryMed.findAllByStatusTrue(paginacao).map(MedicoListData::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
        var medico = repositoryMed.getReferenceById(id);
        return ResponseEntity.ok(new MedicoDetailedData(medico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid MedicoUpdate dadosMed) {
        var medico = repositoryMed.getReferenceById(dadosMed.id());
        medico.atualizar(dadosMed);

        return ResponseEntity.ok(new MedicoDetailedData(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var medico = repositoryMed.getReferenceById(id);
        medico.inativar();

        return ResponseEntity.noContent().build();
    }
}
