package galaxy.ishop.models;

import galaxy.templates.models.GEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Owner extends GEntity<Long> {

    @Id
    @GeneratedValue
    private Long id;

    private String domain;
    private String code;
    private String phone;
    private String email;

    private String locale;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "on_registered")
    private Date registered;

    @Column(name = "on_disabled")
    private Date disabled;

    @Column(name = "on_deleted")
    private Date deleted;

}
