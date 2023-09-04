package med.voll.api.controller;

import med.voll.api.medico.DataMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medico")
public class MedicoController {

  @Autowired
  private MedicoRepository medicoRepository;

  @PostMapping
  public void registerMedico(@RequestBody DataMedico dataMedico){
    medicoRepository.save(new Medico(dataMedico));
  }
}
