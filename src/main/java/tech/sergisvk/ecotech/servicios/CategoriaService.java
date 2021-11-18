package tech.sergisvk.ecotech.servicios;

import org.springframework.stereotype.Service;
import tech.sergisvk.ecotech.modelo.Categoria;
import tech.sergisvk.ecotech.repositorios.ICategoriaRepository;

import java.util.List;

/**
 * Es principalmente decirle a Spring que esta clase va a ser un @Component y marcarla con un estereotipo especial,
 * que es @Service en nuestro caso.
 */
@Service
public class CategoriaService {

    private final ICategoriaRepository repositorio;

    public CategoriaService(ICategoriaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Categoria> findAll() {
        return repositorio.findAll();
    }

    public List<Categoria> findDestacadas() {
        return repositorio.findDestacadas();
    }

    public Categoria save(Categoria categoria) {
        return repositorio.save(categoria);
    }

    public Categoria findById(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    /**
     * Borra una categoría
     * @param categoria objeto
     * @return la categoría borrada
     */
    public Categoria delete(Categoria categoria) {
        Categoria result = findById(categoria.getId());
        repositorio.delete(result);
        return result;
    }



}
