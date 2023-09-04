package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.direction.Direction;

@Entity(name = "Medico")
@Table(name = "medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
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
  }
}
