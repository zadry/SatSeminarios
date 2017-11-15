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
        if (cadena.matches("[A-Za-z]+{2,25}")) {
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
        if (cadena.matches("[a-zA-Z0-9\\.\\_\\-]{2,30}@[a-zA-Z0-9\\.]{1,50}")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validarMatricula(String cadena) {
        if (cadena.matches("[0-9]{2}-[0-9]{3}-[0-9]{4}")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validarCubiculo(String cadena) {
        if (cadena.matches("[a-zA-Z]{1}-[0-9]{3}")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validarContraseña(String cadena) {
        if (cadena.matches("[a-zA-Z0-9\\.\\_\\-]{2,30}")) {
            return true;
        } else {
            return false;
        }
    }
}
