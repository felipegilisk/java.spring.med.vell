package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repositoryPac;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid PacienteData novoPac, UriComponentsBuilder uriBuilder) {
        Paciente pacienteCriado = new Paciente(novoPac);
        repositoryPac.save(pacienteCriado);
        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(pacienteCriado.getId()).toUri();

        return ResponseEntity.created(uri).body(new PacienteDetailedData(pacienteCriado));
    }

    @GetMapping
    public ResponseEntity<Page<PacienteListData>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repositoryPac.findAllByStatusTrue(paginacao).map(PacienteListData::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
        var paciente = repositoryPac.getReferenceById(id);
        return ResponseEntity.ok(new PacienteDetailedData(paciente));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid PacienteUpdate dados) {
        var paciente = repositoryPac.getReferenceById(dados.id());
        paciente.atualizar(dados);
        return ResponseEntity.ok(new PacienteDetailedData(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var paciente = repositoryPac.getReferenceById(id);
        paciente.excluir();
    }


}
