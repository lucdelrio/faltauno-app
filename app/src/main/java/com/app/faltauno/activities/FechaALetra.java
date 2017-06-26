package com.app.faltauno.activities;

/**
 * Created by lucas on 25/06/17.
 */

public class FechaALetra {

    // Array con los dias de la semana
    private String[] dias = new String[]{
            "Domingo",
            "Lunes",
            "Martes",
            "Miércoles",
            "Jueves",
            "Viernes",
            "Sabado"};

    // Array con los meses del año
    private String[] meses = new String[]{
            "Enero",
            "Febrero",
            "Marzo",
            "Abril",
            "Mayo",
            "Junio",
            "Julio",
            "Agosto",
            "Septiembre",
            "Octubre",
            "Noviembre",
            "Diciembre",};


    public String getMes(int numeroDeMes){
        return meses[numeroDeMes];
    }

    public String getDia(int numeroDeDia){
        return dias[numeroDeDia];
    }
}
