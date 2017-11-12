/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseLayer;

import java.sql.*;

/**
 *
 * @author Zadry
 */
public class DBConexion {

    static String url;
    static String usuario;
    static String contrasena;
    static Connection conexion = null;
    static boolean estado = true;

    public DBConexion() {
        DBConexion.url = "jdbc:oracle:thin:@localhost:1521:xe";

        try {
            DBConexion.usuario = "system";
            DBConexion.contrasena = "oracle";
            conexion = DriverManager.getConnection(url, DBConexion.usuario, DBConexion.contrasena);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            estado = false;
        }
    }

    public DBConexion(String usuario, String contrasena) {
        DBConexion.url = "jdbc:oracle:thin:@localhost:1521:xe";

        try {
            DBConexion.usuario = usuario;
            DBConexion.contrasena = contrasena;
            conexion = DriverManager.getConnection(url, DBConexion.usuario, DBConexion.contrasena);
        } catch (Exception e) {
            estado = false;
        }
    }

    public void closeConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (Exception e) {
            estado = false;
        }
    }

    public Statement getStatement() {
        try {
            if (conexion.isClosed()) {
                return null;
            }

            return conexion.createStatement();
        } catch (Exception e) {
            return null;
        }
    }

//    public ArrayList RegresaUnaColumna(String atributo,String tabla){
//        ArrayList columna = new ArrayList();
//        try{
//            Statement sentencia = DBConexion.conexion.createStatement();
//
//            ResultSet resultado = sentencia.executeQuery("SELECT " + atributo + " FROM " + tabla);
//
//            while (resultado.next())
//                columna.add(resultado.getString(atributo));
//        }
//        catch(SQLException e){
//            System.err.println(e);
//        }
//        finally{
//            return columna;
//        }
//    }
//
//    public ArrayList RegresaValoresPorCadena(String atributo, String tabla, String atributo2, String cadena){
//        ArrayList valor = new ArrayList();
//        try{
//            Statement sentencia = DBConexion.conexion.createStatement();
//
//            ResultSet resultado = sentencia.executeQuery("SELECT " + atributo + " FROM " + tabla + " WHERE " + atributo2 + " = " + "'" + cadena + "'");
//
//
//            while (resultado.next())
//                valor.add(resultado.getString(atributo));
//        }
//        catch(SQLException e){
//            System.err.println(e);
//        }
//        finally{
//            return valor;
//        }
//    }
}
