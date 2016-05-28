package pl.edu.model.competitor;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import pl.edu.model.BaseEntity;
import pl.edu.model.accommodation.availability.AccommodationAvailability;
import pl.edu.model.accommodation.reservation.AccommodationReservation;
import pl.edu.model.category.Category;
import pl.edu.model.club.Club;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "competitors")
public class Competitor extends BaseEntity<Long> {

    private static final long serialVersionUID = -758076802868616147L;

    public Competitor(){}

    @Id
    @Getter @Setter
    @GeneratedValue
    @Column(name = "idcompetitor")
    private Long id;

    @Getter @Setter
    @Column
    private String name;

    @Getter	@Setter
    @Column
    private String surname;

    @Getter	@Setter
    @Column(name = "licence_number")
    private String licenceNumber;

    @Getter	@Setter
    @Column(name = "chip_number")
    private Long chipNumber;

    @Getter	@Setter
//    @Column(name = "idclub")
    @ManyToOne
    @JoinColumn(name="idclub",
            insertable=false, updatable=false,
            nullable=false)
    private Club club;

    @Getter	@Setter
    @Column(name = "idclub")
    private Long clubId;

    @Getter	@Setter
    @Column(name = "birth_year")
    private Long birthYear;

    @Getter	@Setter
    @Column
    private Character gender;

    @Getter	@Setter
//    @Column
    @ManyToOne
    @JoinColumn(name="category",
            insertable=false, updatable=false,
            nullable=false)
    private Category category;

    @Getter	@Setter
    @Column(name = "category")
    private Long categoryId;

    @Getter @Setter
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "accommodation_reservations", joinColumns = {
            @JoinColumn(name = "idcompetitor", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "idaccommodation_availabilities",
                    nullable = false, updatable = false)
    })
    private Set<AccommodationAvailability> accommodationAvailabilities;
}
