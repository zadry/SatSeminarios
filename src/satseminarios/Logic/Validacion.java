/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satseminarios.Logic;

/**
 *
 * @author javv
 */
public class Validacion {

    public static boolean validarCadenas(String cadena) {
        if (cadena.matches("[A-Za-z]{20}")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validarTelefono(String cadena) {
        if (cadena.matches("[0-9]{10}")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validarCorreo(String cadena) {
        if (cadena.matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+.[a-zA-Z]{2,6}")) {
            return true;
        } else {
            return false;
        }
    }
}
