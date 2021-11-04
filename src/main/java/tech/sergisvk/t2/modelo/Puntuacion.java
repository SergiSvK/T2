package tech.sergisvk.t2.modelo;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * LA etiqueta Entiy representa una tabla que se almacena en una base de datos. Cada instacia de una Entity representa
 * una fila en la tabla.
 */
@Entity
public class Puntuacion {

    // Define la clave principal
    @Id
    // Genera identificadores diferentes que son espeficadas por la anotación [AUTO, TABLE, SEQUENCE, IDENTITY]
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Con la Etiqueta CreateDate podemo comprobar la fecha de creación
    @CreatedDate
    private Date fecha;

    //Cantidad de Extrellas que le dan los consumidores
    private int puntuacion;

    /** 1:n Uno a muchos
     * La forma de funcionar es a nivel de base de datos es que tenemos una id clave principal en tabla de Productos
     * y tambien una id como clave externa en la tabla de puntacion
     */
    @ManyToOne
    private Producto producto;

    public Puntuacion() {
        //Void
    }

    /**
     * Que valor va a recibir el producto seleccionado, no se puede ni cambiar la fecha de creacíon ni su id
     * @param puntuacion  Que se le da al producto
     * @param producto a asignar la puntuacion
     */
    public Puntuacion(int puntuacion, Producto producto) {
        this.puntuacion = puntuacion;
        this.producto = producto;
    }

    //Getter y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
