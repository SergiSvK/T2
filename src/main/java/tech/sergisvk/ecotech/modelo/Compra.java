package tech.sergisvk.ecotech.modelo;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter @NoArgsConstructor
@ToString @EqualsAndHashCode
public class Compra {
    @Id
    @Column(nullable = false)
    private Long id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompra;

    @ManyToOne
    private Usuario propietario;

    public Compra(Date fechaCompra, Usuario propietario) {
        this.fechaCompra = fechaCompra;
        this.propietario = propietario;
    }

}
