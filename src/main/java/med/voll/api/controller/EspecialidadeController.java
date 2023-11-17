package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.especialidade.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("especialidades")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeRepository repositoryEsp;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid EspecialidadeData novaEsp, UriComponentsBuilder uriBuilder) {
        Especialidade espCriada = new Especialidade(novaEsp);
        repositoryEsp.save(espCriada);
        var uri = uriBuilder.path("/especialidades/{id}").buildAndExpand(espCriada.getId()).toUri();
        return ResponseEntity.created(uri).body(new EspecialidadeData(espCriada));
    }

    @GetMapping
    public ResponseEntity<Page<EspecialidadeListData>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repositoryEsp.findAllByStatusTrue(paginacao).map(EspecialidadeListData::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscar(@PathVariable Long id){
        var esp = repositoryEsp.getReferenceById(id);
        return ResponseEntity.ok(new EspecialidadeData(esp));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid EspecialidadeUpdate dadosEsp) {
        var esp = repositoryEsp.getReferenceById(dadosEsp.id());
        esp.setDescricao(dadosEsp.descricao());

        return ResponseEntity.ok(new EspecialidadeData(esp));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var esp = repositoryEsp.getReferenceById(id);
        esp.inativar();

        return ResponseEntity.noContent().build();
    }

}
