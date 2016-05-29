package pl.edu.model.accommodation.reservation;

import lombok.Getter;
import lombok.Setter;
import pl.edu.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "accommodation_reservations")
public class AccommodationReservation extends BaseEntity<Long> {

    private static final long serialVersionUID = -758076802868616147L;

    public AccommodationReservation(){}

    @Id
    @Getter
    @GeneratedValue
    @Column(name = "idaccommodation_reservations")
    private Long id;

    @Getter @Setter
    @Column(name = "idaccommodation_availabilities")
    private Long accommodationAvailability;

    @Getter	@Setter
    @Column(name = "idcompetitor")
    private Long competitorId;
}
