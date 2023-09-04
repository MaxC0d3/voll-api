package med.voll.api.direction;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Direction {
  private String street;
  private int number;
  private String complement;
  private String city;
  private String state;

  public Direction(DataDirection dataDirection) {
    this.street = dataDirection.street();
    this.number = dataDirection.number();
    this.complement = dataDirection.complement();
    this.city = dataDirection.city();
    this.state = dataDirection.state();
  }

  public Direction update(DataDirection dataDirection) {
    this.street = dataDirection.street();
    this.number = dataDirection.number();
    this.complement = dataDirection.complement();
    this.city = dataDirection.city();
    this.state = dataDirection.state();
    return this;
  }
}

