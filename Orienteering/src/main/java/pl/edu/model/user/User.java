package pl.edu.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.edu.model.BaseEntity;

import java.util.Date;

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
    @Column(nullable=false, name = "idclub")
    private int clubId;
}
