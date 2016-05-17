package pl.edu.model.competitor;

import lombok.Getter;
import lombok.Setter;
import pl.edu.model.BaseEntity;

import javax.persistence.*;

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
    @Column(name = "idclub")
    private Long clubId;

    @Getter	@Setter
    @Column(name = "birth_year")
    private Long birthYear;

    @Getter	@Setter
    @Column
    private Character gender;

    @Getter	@Setter
    @Column
    private Long category;
}
