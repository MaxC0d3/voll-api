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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/medico")
public class MedicoController {

  @Autowired
  private MedicoRepository medicoRepository;

  @PostMapping
  public ResponseEntity<Medico> registerMedico(@RequestBody @Valid DataMedico dataMedico){
    Medico medico = medicoRepository.save(new Medico(dataMedico));
    URI uri = URI.create("/medico/" + medico.getId());

    return ResponseEntity.created(uri).body(medico);
  }
  @GetMapping
  public ResponseEntity<Page<DataListMedico>> getMedico(Pageable pageable){
    return ResponseEntity.ok(medicoRepository.findAll(pageable).map(DataListMedico::new));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Medico> getMedicoById(@PathVariable Long id){
    Medico medico = medicoRepository.getReferenceById(id);
    return ResponseEntity.ok(medico);
  }

  @PutMapping
  @Transactional
  public ResponseEntity<Medico> updateMedico(@RequestBody @Valid UpdateDataMedico updateDataMedico){
    Medico medico = medicoRepository.getReferenceById(updateDataMedico.id());
    medico.updateData(updateDataMedico);
    return ResponseEntity.ok(medico);
  }
}
