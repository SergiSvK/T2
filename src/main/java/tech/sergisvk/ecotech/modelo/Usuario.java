package tech.sergisvk.ecotech.modelo;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
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

    public Usuario() {
    }

    /**
     *
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id && Objects.equals(nombre, usuario.nombre) && Objects.equals(apellidos, usuario.apellidos)
                && Objects.equals(avatar, usuario.avatar) && Objects.equals(fechaAlta, usuario.fechaAlta) &&
                Objects.equals(email, usuario.email) && Objects.equals(password, usuario.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidos, avatar, fechaAlta, email, password);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", avatar='" + avatar + '\'' +
                ", fechaAlta=" + fechaAlta +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
