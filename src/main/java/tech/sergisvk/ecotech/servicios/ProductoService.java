package tech.sergisvk.ecotech.servicios;

import org.springframework.stereotype.Service;
import tech.sergisvk.ecotech.modelo.Categoria;
import tech.sergisvk.ecotech.modelo.Producto;
import tech.sergisvk.ecotech.repositorios.IProductoRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    // La inyección de dependecias es mejor llevarla al contructor para que sea más fácil realizar test
    private final IProductoRepository repositorio;

    public ProductoService(IProductoRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Producto> findAll() {
        return repositorio.findAll();
    }

    public List<Producto> findAllByCategoria(Categoria categoria) {
        return repositorio.findByCategoria(categoria);
    }

    public List<Producto> findAllByCategoria(Long categoriaId) {
        return repositorio.findByCategoriaId(categoriaId);
    }

    public Producto findById(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Producto save(Producto producto) {
        return repositorio.save(producto);
    }

    public Producto delete(Producto producto) {
        Producto result = findById(producto.getId());
        repositorio.delete(result);
        return result;
    }

    public int numeroProductosCategoria(Categoria categoria) {
        return repositorio.findNumProductosByCategoria(categoria);
    }


    /*
     * Este método sirve para obtener un número de productos aleatorios.
     * Lo realizamos en Java para abstraernos mejor de la base de datos
     * concreta que vamos a usar.
     * Algunos SGBDR nos permitirían usar la función RANDOM, y podríamos
     * hacer esta consulta de forma nativa.
     */
    public List<Producto> obtenerProductosAleatorios(int numero) {
        // Obtenemos los ids de todos los productos
        List<Long> listaIds = repositorio.obtenerIds();
        // Los desordenamos
        Collections.shuffle(listaIds);
        // Nos quedamos con los N primeros, con N = numero.
        listaIds = listaIds.stream().limit(numero).collect(Collectors.toList());
        // Buscamos los productos con esos IDs y devolvemos la lista
        return repositorio.findAllById(listaIds);
    }

}
