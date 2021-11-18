package tech.sergisvk.ecotech;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.sergisvk.ecotech.modelo.Producto;
import tech.sergisvk.ecotech.modelo.Puntuacion;
import tech.sergisvk.ecotech.repositorios.IProductoRepository;

import java.util.List;
import java.util.Random;

/**
 * A partir de la Versión Spring 2.5
 * Como resultado de la etiqueta, escaneará automáticamente los componentes del paquete actual y sus subpaquetes.
 * Por lo tanto, los registrará en el contexto de aplicación de Spring y nos permitirá inyectar beans usando el @Autorwied
 * (Inicio del cableado)
 */
@SpringBootApplication
public class T2Application {

    public static void main(String[] args) {
        SpringApplication.run(T2Application.class, args);
    }
    @Bean
    public CommandLineRunner initData(IProductoRepository productoRepository) {
        return args -> {

            // Rescatamos todos los productos
            List<Producto> productos = productoRepository.findAll();

            Random r = new Random();

            // Para cada uno de ellos
            for (Producto p : productos) {
                // Vamos a añadirle un número aleatorio de puntuaciones, entre 1 y 10
                for (int i = 0; i < r.nextInt(10); i++)
                    // Lo valoramos con una puntuación aleatoria, entre 3 y 5.
                    p.addPuntuacion(new Puntuacion(3 + r.nextInt(2)));
            }
            // Actualizamos los productos, almacenando así su puntuación
            productoRepository.saveAll(productos);
        };
}
