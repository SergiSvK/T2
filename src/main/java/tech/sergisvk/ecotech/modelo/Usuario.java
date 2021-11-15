package tech.sergisvk.ecotech.modelo;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter @NoArgsConstructor
@ToString @EqualsAndHashCode
public class Usuario {

    @Id
    @GeneratedValue
    private long id;
    private String nombre;
    private String apellidos;
    private String avatar;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;

    @NotNull
    private String email;
    private String password;

    /**
     * Los datos que se pueden establecer al usuario son todos me la ID
     * @param nombre
     * @param apellidos
     * @param avatar
     * @param fechaAlta
     * @param email
     * @param password
     */
    public Usuario(String nombre, String apellidos, String avatar, Date fechaAlta, String email, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.avatar = avatar;
        this.fechaAlta = fechaAlta;
        this.email = email;
        this.password = password;
    }
}
