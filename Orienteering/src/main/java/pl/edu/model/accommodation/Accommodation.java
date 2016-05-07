package pl.edu.model.accommodation;

import lombok.Getter;
import lombok.Setter;
import pl.edu.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "acomodations")
public class Accommodation extends BaseEntity<Long> {

    private static final long serialVersionUID = -758076802868616147L;

    public Accommodation(){}

    @Id
    @Getter
    @GeneratedValue
    @Column(name = "idacomodation")
    private Long id;

    @Getter @Setter
    @Column(name = "adress")
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
}
