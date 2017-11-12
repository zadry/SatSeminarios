/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseLayer;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author vos
 */
public class HelperLogin {

    static DBConexion conexion = null;

    public HelperLogin() {
        conexion = new DBConexion();
    }

    /**
     *
     * @return
     */
    public boolean getMatricula(String matricula, String correo) {
        //ArrayList<String> sucursales = new ArrayList<>();
        boolean flag = false;
        try {
            Statement sentencia = conexion.getStatement();

            if (sentencia == null) {
                return false;
            }

            String query = "SELECT MATRICULA FROM CANDIDATOS WHERE MATRICULA='" + matricula + "'"
                    + "AND CORREO = '" + correo + "'";
            ResultSet resultado = sentencia.executeQuery(query);

            while (resultado.next()) {
                flag = true;
            }

        } catch (SQLException ex) {
            return false;
        }
        return flag;
    }

    public boolean getCorreo(String correo) {

        boolean flag = false;
        //String consulta = null;
        try {
            Statement sentencia = conexion.getStatement();

            if (sentencia == null) {
                return false;
            }

            String query = "SELECT CORREO FROM CANDIDATOS WHERE CORREO='" + correo + "'";

            ResultSet resultado = sentencia.executeQuery(query);

            while (resultado.next()) {
                flag = true;
            }

        } catch (SQLException ex) {
            System.out.println("Exception :" + ex.getMessage());
            return false;
        }
        return flag;
    }

    public ArrayList<String> getOtraCosa(String matricula) {
        ArrayList<String> sucursales = new ArrayList<>();
        try {
            Statement sentencia = conexion.getStatement();

            if (sentencia == null) {
                return sucursales;
            }

            String query = "SELECT MATRICULA FROM CANDIDATOS WHERE MATRICULA=" + matricula + ";";
            ResultSet resultado = sentencia.executeQuery(query);

            while (resultado.next()) {
                sucursales.add(resultado.getString("NOMBRE"));
            }

        } catch (SQLException ex) {
            return sucursales;
        }
        return sucursales;
    }

}
