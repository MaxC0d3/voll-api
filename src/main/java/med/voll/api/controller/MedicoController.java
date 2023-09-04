package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DataListMedico;
import med.voll.api.medico.DataMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.UpdateDataMedico;
import med.voll.api.medico.repository.MedicoRepository;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medico")
public class MedicoController {

  @Autowired
  private MedicoRepository medicoRepository;

  @PostMapping
  public void registerMedico(@RequestBody @Valid DataMedico dataMedico){
    medicoRepository.save(new Medico(dataMedico));
  }
  @GetMapping
  public Page<DataListMedico> getMedico(@PageableDefault(size = 2) Pageable pageable){
    return medicoRepository.findAll(pageable).map(DataListMedico::new);
  }

  @PutMapping
  @Transactional
  public void updateMedico(@RequestBody @Valid UpdateDataMedico updateDataMedico){
    Medico medico = medicoRepository.getReferenceById(updateDataMedico.id());
    medico.updateData(updateDataMedico);
  }
}
