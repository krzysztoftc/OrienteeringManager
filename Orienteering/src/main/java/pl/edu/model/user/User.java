package pl.edu.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import pl.edu.model.BaseEntity;
import pl.edu.model.club.Club;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity<Long> {

    private static final long serialVersionUID = -758076802868616147L;

    public User(){}

    public User(String email, String password){
        this.email=email;
        this.password=password;
    }

    @Id
    @Getter
    @GeneratedValue
    @Column(name = "iduser")
    private Long id;

    @Getter
    @Setter
    @Column(nullable=false, unique=true)
    private String email;

    @JsonIgnore
    @Column(nullable=false)
    @Getter	@Setter
    private String password;

    @Getter	@Setter
    @Column(nullable=false)
    private String type;

    @Getter	@Setter
//    @Column(nullable=false, name = "idclub")
    @ManyToOne
    @JoinColumn(name="idclub",
            insertable=false, updatable=false,
            nullable=false)
    private Club club;
}
