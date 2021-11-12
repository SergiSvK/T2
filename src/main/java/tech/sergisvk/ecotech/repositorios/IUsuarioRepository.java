package tech.sergisvk.ecotech.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.sergisvk.ecotech.modelo.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Busca el email del usuario
     * @param email clave única
     * @return el primero que encuentre por email
     */
    Usuario findFirstByEmail(String email);
}
