package tech.sergisvk.ecotech.modelo;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Compra {
    @Id
    @Column(nullable = false)
    private Long id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompra;

    @ManyToOne
    private Usuario propietario;

    public Compra() {

    }

    public Compra(Date fechaCompra, Usuario propietario) {
        this.fechaCompra = fechaCompra;
        this.propietario = propietario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compra compra = (Compra) o;
        return Objects.equals(id, compra.id) && Objects.equals(fechaCompra, compra.fechaCompra) && Objects.equals(propietario, compra.propietario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechaCompra, propietario);
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", fechaCompra=" + fechaCompra +
                ", propietario=" + propietario +
                '}';
    }
}
