package pl.edu.model.catering.availability;

import lombok.Getter;
import lombok.Setter;
import pl.edu.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "catering_availabilities")
public class CateringAvailability extends BaseEntity<Long> {

    private static final long serialVersionUID = -758076802868616147L;

    public CateringAvailability(){}

    @Id
    @Getter
    @GeneratedValue
    @Column(name = "idcatering_availabilities")
    private Long id;

    @Getter @Setter
    @Column(name = "idcatering")
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
