/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.models;

/**
 *
 * @author jesus
 */
public class Utils {
    
    public static String string2Date(String contenido) {
        String salida = null;
        if(!contenido.equals("")) {
            salida = contenido;
            salida = salida.replace("-", ":");
            salida = salida.replace("%20", " ");
            salida = salida.replace("%82", ",");
        } else {
            salida = "Es la primera vez que entras en la aplicación";
        }
        
        return salida;
    }
    
}
