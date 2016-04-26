package pl.edu.model.club;

import lombok.Getter;
import lombok.Setter;
import pl.edu.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "clubs")
public class Club extends BaseEntity<Long> {

    private static final long serialVersionUID = -758076802868616147L;

    public Club(){}

    @Id
    @Getter
    @GeneratedValue
    @Column(name = "idclub")
    private Long id;

    @Getter @Setter
    @Column
    private String name;

    @Getter	@Setter
    @Column
    private String address;

    @Getter	@Setter
    @Column(name = "agent_name")
    private String agentName;

    @Getter	@Setter
    @Column(name = "agent_surname")
    private String agentSurname;

    @Getter	@Setter
    @Column(name = "club_number")
    private String clubNumber;

    @Getter	@Setter
    @Column(name = "phone_number")
    private String phoneNumber;
}
