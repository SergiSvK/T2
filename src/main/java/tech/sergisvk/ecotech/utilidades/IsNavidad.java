package tech.sergisvk.ecotech.utilidades;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@Setter @Getter
public class IsNavidad {

    private boolean isNavidad;

    public IsNavidad(Calendar calendar, boolean isNavidad){
        this.isNavidad = isNavidad;
        Fecha fechaIni = Fecha.parse(20,12,calendar.get(Calendar.YEAR));
        Fecha fechaFin = Fecha.parse(7,1,calendar.get(Calendar.YEAR)+1);
        setNavidad(Fecha.hoy().isBetween(fechaIni,fechaFin));
    }

}
