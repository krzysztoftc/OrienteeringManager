package pl.edu.model.accommodation.availability;

import lombok.Getter;
import lombok.Setter;
import pl.edu.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "acomodation_avaliabilities")
public class AccommodationAvailability extends BaseEntity<Long> {

    private static final long serialVersionUID = -758076802868616147L;

    public AccommodationAvailability(){}

    @Id
    @Getter
    @GeneratedValue
    @Column(name = "idreservations_options")
    private Long id;

    @Getter @Setter
    @Column(name = "acomodationid")
    private Long accommodationId;

    @Getter	@Setter
    @Column
    private Date date;

    @Getter	@Setter
    @Column
    private Float price;
}
