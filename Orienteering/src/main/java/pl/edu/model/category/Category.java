package pl.edu.model.category;

import lombok.Getter;
import lombok.Setter;
import pl.edu.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity<Long> {

    private static final long serialVersionUID = -758076802868616147L;

    public Category(){}

    public Category(String name) {
        this.name = name;
    }

    @Id
    @Getter @Setter
    @GeneratedValue
    @Column(name = "idcategory")
    private Long id;

    @Getter @Setter
    @Column
    private String name;
}
