package pl.edu.model.catering.reservation;

import lombok.Getter;
import lombok.Setter;
import pl.edu.model.BaseEntity;
import pl.edu.model.catering.availability.CateringAvailability;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "catering_reservations")
public class CateringReservation extends BaseEntity<Long> {

    private static final long serialVersionUID = -758076802868616147L;

    public CateringReservation(){}

    @Id
    @Getter
    @GeneratedValue
    @Column(name = "idcatering_reservations")
    private Long id;

    @Getter @Setter
    @Column(name = "idcatering_availabilities")
    private Long cateringAvailabilityId;

    @Getter	@Setter
    @Column(name = "competitor")
    private Long competitorId;
}
