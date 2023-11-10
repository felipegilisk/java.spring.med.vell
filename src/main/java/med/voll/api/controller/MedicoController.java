package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.MedicoData;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoListData;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody @Valid MedicoData novoMed) {
        repository.save(new Medico(novoMed));
    }

    @GetMapping
    public Page<MedicoListData> listarMedicos(@PageableDefault(size = 10, sort = {"especialidade"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(MedicoListData::new);
    }
}
