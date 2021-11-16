package tech.sergisvk.ecotech.config;


import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConfigVariables {

    public final static String domain = "eco.tech";
    public final static String phone ="+999 888 777";

    /**
     * Obtiene el host del la web
     * @return URL del host
     * @throws MalformedURLException Si es null puede lanzar un error a tratar
     */
    public static URL hostURL() throws MalformedURLException {
        String currentURL =
                ServletUriComponentsBuilder.
                        fromCurrentContextPath().
                        build().
                        toUriString();
        return new URL(currentURL);
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
