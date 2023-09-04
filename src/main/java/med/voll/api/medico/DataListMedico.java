package med.voll.api.medico;

public record DataListMedico(String name,  String document, Specialty specialty, String email) {
  public DataListMedico(Medico medico){
    this(medico.getName(), medico.getDocument(), Specialty.valueOf(medico.getSpecialty().toString()), medico.getEmail());
  }
}
