package tech.sergisvk.t2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A partir de la Versión Spring 2.5
 * Como resultado de la etiqueta, escaneará automáticamenmte los componentes del paquete actual y sus subpaquetes.
 * Por lo tanto, los registrará en el contexto de aplicación de Spring y nos permitirá inyectar beans usando el @Autorwied
 * (Inicio del cableado)
 */
@SpringBootApplication
public class T2Application {

    public static void main(String[] args) {
        SpringApplication.run(T2Application.class, args);
    }

}
