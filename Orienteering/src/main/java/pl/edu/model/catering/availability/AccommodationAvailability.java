package pl.edu.model.catering.availability;

import lombok.Getter;
import lombok.Setter;
import pl.edu.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "catering_avaliabilities")
public class AccommodationAvailability extends BaseEntity<Long> {

    private static final long serialVersionUID = -758076802868616147L;

    public AccommodationAvailability(){}

    @Id
    @Getter
    @GeneratedValue
    @Column(name = "idreservations_options")
    private Long id;

    @Getter @Setter
    @Column(name = "cateringid")
    private Long cateringId;

    @Getter	@Setter
    @Column
    private Date date;

    @Getter	@Setter
    @Column(name = "meal_time")
    private String mealTime;

    @Getter	@Setter
    @Column
    private String description;

    @Getter	@Setter
    @Column(name = "phone_number")
    private Float price;
}
