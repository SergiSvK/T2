package tech.sergisvk.ecotech.modelo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Categoria {

    // Define la clave principal en la base de datos
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private boolean destacada;

    private String imagen;

    public Categoria() { }

    /**
     * Para crear una categoría se le tiene que añadir los siguientes valores
     * @param nombre del producto
     * @param destacada si es o no destacado
     * @param imagen sobre la categoría
     */
    public Categoria(String nombre, boolean destacada, String imagen) {
        this.nombre = nombre;
        this.destacada = destacada;
        this.imagen = imagen;
    }

    //getter and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isDestacada() {
        return destacada;
    }

    public void setDestacada(boolean destacada) {
        this.destacada = destacada;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}