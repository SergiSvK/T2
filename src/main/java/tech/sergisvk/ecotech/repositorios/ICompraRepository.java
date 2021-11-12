package tech.sergisvk.ecotech.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.sergisvk.ecotech.modelo.Compra;
import tech.sergisvk.ecotech.modelo.Usuario;

import java.util.List;

public interface ICompraRepository extends JpaRepository<Compra,Long> {

    /**
     * Para buscar todas las litas de compras de un propietario
     * @param propietario tipo usuario
     * @return lista de compras del usuario en particular
     */
    List<Compra> findByPropietario(Usuario propietario);
}
