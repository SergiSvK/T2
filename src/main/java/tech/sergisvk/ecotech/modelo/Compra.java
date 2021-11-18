package tech.sergisvk.ecotech.modelo;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter @NoArgsConstructor
@ToString
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Compra compra = (Compra) o;
        return id != null && Objects.equals(id, compra.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
