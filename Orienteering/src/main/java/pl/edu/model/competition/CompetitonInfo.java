package pl.edu.model.competition;

import lombok.Getter;
import lombok.Setter;
import pl.edu.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "competiton_info")
public class CompetitonInfo extends BaseEntity<Long> {

    private static final long serialVersionUID = -758076802868616147L;

    public CompetitonInfo(){}

    @Id
    @Getter
    @GeneratedValue
    @Column(name = "idcompetiton_info")
    private Long id;

    @Getter @Setter
    @Column
    private String description;

    @Getter	@Setter
    @Column
    private String name;

    @Getter	@Setter
    @Column
    private String address;

    @Getter	@Setter
    @Column
    private Date begin;

    @Getter	@Setter
    @Column
    private Date end;

    @Getter	@Setter
    @Column(name = "entry_fee")
    private Float entryFee;

    @Getter	@Setter
    @Column(name = "overdue_entry_fee")
    private Float overdueEntryFee;

    @Getter	@Setter
    @Column(name = "chip_borrow_fee")
    private Float chipBorrowFee;

    @Getter	@Setter
    @Column(name = "chip_lost_fee")
    private Float chipLostFee;

    @Getter	@Setter
    @Column(name = "aplication_deadline")
    private Date aplicationDeadline;

    @Getter	@Setter
    @Column(name = "aplication_start")
    private Date aplicationStart;
}
