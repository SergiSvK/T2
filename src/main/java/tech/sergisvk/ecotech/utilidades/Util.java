package tech.sergisvk.ecotech.utilidades;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    public final static String domain = "eco.tech";
    public final static String phone ="+999 888 777";

    /**
     * Obtiene el host del la web
     * @return URL del host
     */
    public static String host() {
        String host = null;
        try {
            String currentURL =
                    ServletUriComponentsBuilder.
                            fromCurrentContextPath().
                            build().
                            toUriString();

            host = new URL(currentURL).getHost();

        } catch (MalformedURLException e) {
            host = "none";
        }

        return host;
    }

    /**
     * Obtiene el año actual y lo pasa a String
     * @return String en año
     */
    public static String yearString(){
        //Datos usados para obtener el año actual
        Date date = new Date();
        SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
        return getYearFormat.format(date);
    }
}
