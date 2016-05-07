package pl.edu.model.catering;

import lombok.Getter;
import lombok.Setter;
import pl.edu.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "caterings")
public class Catering extends BaseEntity<Long> {

    private static final long serialVersionUID = -758076802868616147L;

    public Catering(){}

    @Id
    @Getter
    @GeneratedValue
    @Column(name = "idcatering")
    private Long id;

    @Getter	@Setter
    @Column(name = "adress")
    private String address;

    @Getter @Setter
    @Column
    private String name;

    @Getter	@Setter
    @Column
    private String description;
}
