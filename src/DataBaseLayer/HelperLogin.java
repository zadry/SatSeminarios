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

    public String getMatriculaAsesor(String pass, String correo) {
        ArrayList<String> id = new ArrayList<>();
        String flag = null;
        try {
            Statement sentencia = conexion.getStatement();

            if (sentencia == null) {
                return flag;
            }

            String query = "SELECT IDASESOR FROM ASESOR WHERE PASS = '" + pass + "'"
                    + " AND CORREO = '" + correo + "'";
            ResultSet resultado = sentencia.executeQuery(query);
            System.out.println(query);
            // System.out.println(resultado.getString("PASS"));
            while (resultado.next()) {
                //flag = 0;
                id.add(resultado.getString("IDASESOR"));
                flag = id.get(0);
                // System.out.println("en helper while " + resultado.getString("PASS"));
            }

        } catch (SQLException ex) {

            System.out.println("Exeption:" + ex.getMessage());
            return null;
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

    public boolean getCorreoAsesor(String correo) {

        boolean flag = false;
        //String consulta = null;
        try {
            Statement sentencia = conexion.getStatement();

            if (sentencia == null) {
                return false;
            }

            String query = "SELECT CORREO FROM ASESOR WHERE CORREO='" + correo + "'";

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
