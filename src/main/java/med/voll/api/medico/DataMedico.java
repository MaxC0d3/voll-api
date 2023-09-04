package med.voll.api.medico;

import med.voll.api.direction.DataDirection;

// DTO - Data Transfer Object
public record DataMedico(String name, String email, String document, Specialty specialty, DataDirection dataDirection){

}
