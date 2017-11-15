/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseLayer;

import static DataBaseLayer.HelperCandidatos.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import satseminarios.Logic.Asesor;
import satseminarios.Logic.Candidato;

/**
 *
 * @author javv
 */
public class HelperAsesor {

    static DBConexion conexion = null;

    public HelperAsesor() {
        conexion = new DBConexion();
    }

    /**
     * Inseta un Asesor en la base de datos
     *
     * @param mAsesor
     * @return
     * @throws SQLException
     */
    public boolean insertAsesor(Asesor mAsesor) throws SQLException {
        // ArrayList<String> sucursales = new ArrayList<>();
        Statement sentencia = conexion.getStatement();

        if (sentencia == null) {
            System.out.println("sentencia es nula");
            return false;
        }
        String query = "INSERT INTO ASESOR (IDASESOR, NOMBRE, APELLIDOPATERNO"
                + ",APELLIDOMATERNO,CUBICULO,ASESORIAS,CORREO,PASS)"
                + "VALUES"
                + "(IDASESOR_SEQ.NEXTVAL,'" + mAsesor.getNombre()
                + "','" + mAsesor.getApellidoP() + "','" + mAsesor.getApellidoM()
                + "','" + mAsesor.getCubiculo()
                + "','" + mAsesor.getCorreo() + "','" + mAsesor.getHorarioAsesorias()
                + "','" + mAsesor.getPass() + "')";
        try {
            System.out.println(query);
            sentencia.executeUpdate(query);

        } catch (SQLException ex) {
            System.out.println("Exeption in insertAsesor" + ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean confirmar() {
        boolean confirmado = true;
        try {
            Statement sentencia = conexion.getStatement();

            String query = "COMMIT";
            sentencia.execute(query);

        } catch (SQLException ex) {
            System.out.println("exeption in confirar: " + ex.getMessage());
            confirmado = false;
        }
        return confirmado;
    }
}
