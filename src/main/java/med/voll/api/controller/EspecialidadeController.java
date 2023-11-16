package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.especialidade.Especialidade;
import med.voll.api.domain.especialidade.EspecialidadeData;
import med.voll.api.domain.especialidade.EspecialidadeListData;
import med.voll.api.domain.especialidade.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("especialidades")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeRepository repositoryEsp;

    @PostMapping
    public void cadastrar(@RequestBody @Valid EspecialidadeData novaEsp) {
        repositoryEsp.save(new Especialidade(novaEsp));
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
//
//    @PutMapping
//    @Transactional
//    public void atualizar(@RequestBody @Valid MedicoUpdate dadosEsp) {
//        var especialidade = repositoryEsp.getReferenceById(dadosEsp.id());
//        especialidade.atualizar(dadosEsp);
//    }
//
//    @DeleteMapping("/{id}")
//    @Transactional
//    public void excluir(@PathVariable Long id) {
//        var especialidade = repositoryEsp.getReferenceById(id);
//        especialidade.inativar();
//    }
}
