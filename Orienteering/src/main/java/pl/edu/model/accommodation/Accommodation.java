package pl.edu.model.accommodation;

import lombok.Getter;
import lombok.Setter;
import pl.edu.model.BaseEntity;
import pl.edu.model.accommodation.availability.AccommodationAvailability;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "accommodations")
public class Accommodation extends BaseEntity<Long> {

    private static final long serialVersionUID = -758076802868616147L;

    public Accommodation(){}

    @Id
    @Getter @Setter
    @GeneratedValue
    @Column(name = "idaccommodation")
    private Long id;

    @Getter @Setter
    @Column
    private String address;

    @Getter	@Setter
    @Column
    private String name;

    @Getter	@Setter
    @Column
    private String description;

    @Getter	@Setter
    @Column
    private Long places;

    @Getter @Setter
    @OneToMany(mappedBy = "accommodationId", fetch = FetchType.EAGER)
    private Set<AccommodationAvailability> accommodationAvailabilities;
}
