package galaxy.ishop.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Proxy(lazy = false)
@Table(name = "clients")
@EqualsAndHashCode(callSuper = true)
public class Client extends Owner {

    private String idn;
    private String avatar;

    @Column(name = "on_phone_confirmed")
    private Date phoneConfirmed;

    @Column(name = "on_email_confirmed")
    private Date emailConfirmed;

    private Boolean readonly;

}
