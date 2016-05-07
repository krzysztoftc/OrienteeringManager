package pl.edu.model.accommodation.reservation;

import lombok.Getter;
import lombok.Setter;
import pl.edu.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "acomodation_reservations")
public class AccommodationReservation extends BaseEntity<Long> {

    private static final long serialVersionUID = -758076802868616147L;

    public AccommodationReservation(){}

    @Id
    @Getter
    @GeneratedValue
    @Column(name = "idacomodation_reservations")
    private Long id;

    @Getter @Setter
    @Column(name = "acomodation_option")
    private Long accommodationOption;

    @Getter	@Setter
    @Column(name = "competitor")
    private Long competitorId;
}
