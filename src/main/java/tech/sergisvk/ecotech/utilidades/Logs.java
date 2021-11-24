package tech.sergisvk.ecotech.utilidades;

import javax.servlet.http.HttpSession;
import java.net.InetAddress;

/**
 * La idea principal del los logs sería hacer en un principio un handler interceptor
 * https://www.baeldung.com/spring-mvc-custom-handler-interceptor
 * pero por el momento vamos a implementar con el http host con la info de la sesión
 */
public class Logs {
    
    public Logs(){
        HttpSession session = null;
        InetAddress addr=null;
        assert false;
        String sessionId = session.getId();
        long sessionTime = session.getCreationTime();

        String texto = Fecha.hoy().toString() + session + sessionId + sessionTime + addr;

        Archivos.createFileIfNotExit(Util.ruta);
        Archivos.anyadirTexto(Util.ruta,texto);

    }

}
