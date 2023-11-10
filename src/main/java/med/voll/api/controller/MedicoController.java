package med.voll.api.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repositoryMed;

    @PostMapping
    public void cadastrarMedico(@RequestBody @Valid MedicoData novoMed) {
        repositoryMed.save(new Medico(novoMed));
    }

    @GetMapping
    public Page<MedicoListData> listarMedicos(@PageableDefault(size = 10, sort = {"especialidade"}) Pageable paginacao) {
        return repositoryMed.findAllByStatusTrue(paginacao).map(MedicoListData::new);
    }

//    @GetMapping("/{crm}")
//    public Page<Medico> buscarMedico(@PathVariable String crm) {
//        return repositoryMed.findAllByCrm(crm);
//    }

    @PutMapping
    @Transactional
    public void atualizarMedico(@RequestBody @Valid MedicoUpdate dadosMed) {
        var medico = repositoryMed.getReferenceById(dadosMed.id());
        medico.atualizar(dadosMed);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirMedico(@PathVariable Long id) {
        var medico = repositoryMed.getReferenceById(id);
        medico.inativar();
    }
}
