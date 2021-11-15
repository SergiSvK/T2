package tech.sergisvk.ecotech.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor
public class Logs {

    @Id
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    public Logs(Long id, Usuario usuario, Date fechaRegistro) {
        this.id = id;
        this.usuario = usuario;
        this.fechaRegistro = fechaRegistro;
    }
}
