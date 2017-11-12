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
    public String getMatricula(String matricula) {
        //ArrayList<String> sucursales = new ArrayList<>();
        String consulta = null;
        try {
            Statement sentencia = conexion.getStatement();

            if (sentencia == null) {
                return consulta;
            }

            String query = "SELECT MATRICULA FROM CANDIDATOS WHERE MATRICULA=" + matricula + ";";
            ResultSet resultado = sentencia.executeQuery(query);

            while (resultado.next()) {
                consulta = resultado.getString("MATRICULA");
            }

        } catch (SQLException ex) {
            return consulta;
        }
        return consulta;
    }

    public ArrayList<String> getCorreo(String correo) {
        ArrayList<String> consulta = new ArrayList<>();
        //String consulta = null;
        try {
            Statement sentencia = conexion.getStatement();

            if (sentencia == null) {
                System.out.println("cnsulta = null");
                return consulta;
            }
            System.out.println(" se va a ejecutar la sentencia");
            String query = "SELECT CORREO FROM CANDIDATOS WHERE CORREO='" + correo + "';";
            System.out.println("query = " + query);
            ResultSet resultado = sentencia.executeQuery(query);
            //consulta.add(resultado.getString("CORREO"));
            System.out.println("resultado= " + resultado.toString());
            while (resultado.next()) {
                consulta.add(resultado.getString("CORREO"));
                System.out.println(resultado.getString("CORREO"));
            }

        } catch (SQLException ex) {
            System.out.println("Exception :" + ex.getMessage());
            return consulta;
        }
        return consulta;
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
