package pl.edu.model.catering;

import lombok.Getter;
import lombok.Setter;
import pl.edu.model.BaseEntity;
import pl.edu.model.catering.availability.CateringAvailability;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "caterings")
public class Catering extends BaseEntity<Long> {

    private static final long serialVersionUID = -758076802868616147L;

    public Catering(){}

    @Id
    @Getter @Setter
    @GeneratedValue
    @Column(name = "idcatering")
    private Long id;

    @Getter	@Setter
    @Column
    private String address;

    @Getter @Setter
    @Column
    private String name;

    @Getter	@Setter
    @Column
    private String description;

    @Getter @Setter
    @OneToMany(mappedBy = "cateringId", fetch = FetchType.EAGER)
    private Set<CateringAvailability> cateringAvailabilities;
}
