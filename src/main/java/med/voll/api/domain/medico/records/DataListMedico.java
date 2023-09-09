package med.voll.api.domain.medico.records;

import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.Specialty;

public record DataListMedico(Long id, String name, String document, Specialty specialty, String email) {
  public DataListMedico(Medico medico){
    this(medico.getId(), medico.getName(), medico.getDocument(), Specialty.valueOf(medico.getSpecialty().toString()), medico.getEmail());
  }
}
