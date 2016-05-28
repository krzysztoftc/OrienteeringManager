package pl.edu.model.accommodation.availability;

import lombok.Getter;
import lombok.Setter;
import pl.edu.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "accommodation_availabilities")
public class AccommodationAvailability extends BaseEntity<Long> {

    private static final long serialVersionUID = -758076802868616147L;

    public AccommodationAvailability(){}

    @Id
    @Getter
    @GeneratedValue
    @Column(name = "idaccommodation_availabilities")
    private Long id;

    @Getter @Setter
    @Column(name = "idaccommodation")
    private Long accommodationId;

    @Getter	@Setter
    @Column
    private Date date;

    @Getter	@Setter
    @Column
    private Float price;
}
