package tech.sergisvk.ecotech.modelo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
/*
 * Al agregar las anotaciones @Getter y @Setter , le dijimos a Lombok que las generara para todos los campos de la clase.
 * @NoArgsConstructor conducirá a una generación de constructor vacía.
 */
@Getter @Setter @NoArgsConstructor
public class Categoria {

    // Define la clave principal en la base de datos
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private boolean destacada;

    private String imagen;

    /**
     * Para crear una categoría tiene que tener los valores
     * @param nombre del producto
     * @param destacada si es o no destacado
     * @param imagen sobre la categoría
     */
    public Categoria(String nombre, boolean destacada, String imagen) {
        this.nombre = nombre;
        this.destacada = destacada;
        this.imagen = imagen;
    }

}