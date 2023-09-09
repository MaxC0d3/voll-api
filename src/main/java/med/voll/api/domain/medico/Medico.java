package med.voll.api.domain.medico;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.direction.Direction;
import med.voll.api.domain.medico.records.DataMedico;
import med.voll.api.domain.medico.records.UpdateDataMedico;

@Entity(name = "Medico")
@Table(name = "medico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
  private String telephone;
  private String document;
  @Enumerated(EnumType.STRING)
  private Specialty specialty;
  @Embedded
  private Direction dataDirection;

  public Medico(DataMedico dataMedico) {
    this.name = dataMedico.name();
    this.email = dataMedico.email();
    this.document = dataMedico.document();
    this.specialty = dataMedico.specialty();
    this.dataDirection = new Direction(dataMedico.dataDirection());
    this.telephone = dataMedico.telephone();
  }

  public void updateData(UpdateDataMedico updateDataMedico) {
    if (updateDataMedico.email() == null && updateDataMedico.telephone() == null && updateDataMedico.dataDirection() == null){
      throw new IllegalArgumentException("No there's data to update or data is null");
    }
    this.telephone = updateDataMedico.telephone();
    this.email = updateDataMedico.email();
    this.dataDirection = dataDirection.update(updateDataMedico.dataDirection());
  }
}
