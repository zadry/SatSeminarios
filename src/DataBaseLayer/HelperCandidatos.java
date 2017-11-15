/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseLayer;

import static DataBaseLayer.HelperLogin.conexion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import satseminarios.Logic.Candidato;

/**
 *
 * @author javv
 */
public class HelperCandidatos {

    static DBConexion conexion = null;

    public HelperCandidatos() {
        conexion = new DBConexion();
    }

    public boolean insertCandidato(Candidato mCandidato) throws SQLException {
        // ArrayList<String> sucursales = new ArrayList<>();
        Statement sentencia = conexion.getStatement();

        if (sentencia == null) {
            System.out.println("sentencia es nula");
            return false;
        }
        String query = "INSERT INTO CANDIDATOS"
                + "(MATRICULA, NOMBRE, APELLIDOPATERNO,APELLIDOMATERNO,"
                + "TELEFONO,CARRERA,TEMATESIS,CORREO,DIRECTORTESIS,TRABAJA,"
                + "LUGARDETRABAJO,HORARIODETRABAJO,ESTADO,IDASESOR,IDSEMINARIO)"
                + "VALUES"
                + "('" + mCandidato.getMatricula() + "','" + mCandidato.getNombre()
                + "','" + mCandidato.getApellidoP() + "','" + mCandidato.getApellidoM()
                + "','" + mCandidato.getTelefono() + "','" + mCandidato.getCarrera()
                + "','" + mCandidato.getTemaTesis() + "','" + mCandidato.getCorreo()
                + "','" + mCandidato.getDirectorTesis() + "'," + mCandidato.getTrabaja()
                + ",'" + mCandidato.getLugarDeTrabajo() + "','" + mCandidato.getHorario()
                + "'," + 0 + "," + 1 + "," + 1 + ")";
        try {
            System.out.println(query);
            sentencia.executeUpdate(query);

            confirmar();
        } catch (SQLException ex) {
            System.out.println("Exeption in insertCandidato" + ex.getMessage());
            return false;
        }
        return true;
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

    public final boolean setCartaCompromiso(final Candidato mCandidato) {
        boolean transaccion = true;

        try {
            PreparedStatement ops;

            String query2 = "UPDATE CANDIDATOS SET CARTACOMPROMISO = ? "
                    + "WHERE MATRICULA = ?";

            ops = conexion.getConexion().prepareStatement(query2);
            System.out.println("Direccion de archivo: " + mCandidato.getCartaComprimisoS());

            File fBlob = new File(mCandidato.getCartaComprimisoS());
            FileInputStream is = null;
            try {
                is = new FileInputStream(fBlob);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(HelperCandidatos.class.getName()).log(Level.SEVERE, null, ex);
            }

            ops.setBinaryStream(1, is, fBlob.length());
            ops.setString(2, mCandidato.getMatricula());
            //ops.setString(2, mCandidato.getMatricula());
            System.out.println("justo antes del que se ejecute el EXCUTE OPS");
            ops.executeUpdate();
            confirmar();
        } catch (SQLException ex) {
            System.out.println("BaseDatos.CandidatoDBHelper"
                    + ".SetCartaCompromiso() " + ex);
            transaccion = false;
        }

        return transaccion;
    }

    public final boolean setCartaMotivos(final Candidato mCandidato) {
        boolean transaccion = true;

        try {
            PreparedStatement ops;

            String query2 = "UPDATE CANDIDATOS SET CARTAMOTIVOS = ? "
                    + "WHERE MATRICULA = ?";

            ops = conexion.getConexion().prepareStatement(query2);
            System.out.println("Direccion de archivo: " + mCandidato.getCartaMotivos());

            File fBlob = new File(mCandidato.getCartaMotivos());
            FileInputStream is = null;
            try {
                is = new FileInputStream(fBlob);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(HelperCandidatos.class.getName()).log(Level.SEVERE, null, ex);
            }

            ops.setBinaryStream(1, is, fBlob.length());
            ops.setString(2, mCandidato.getMatricula());
            //ops.setString(2, mCandidato.getMatricula());
            System.out.println("justo antes del que se ejecute el EXCUTE OPS");
            ops.executeUpdate();
            confirmar();
        } catch (SQLException ex) {
            System.out.println("BaseDatos.CandidatoDBHelper"
                    + ".SetCartaCompromiso() " + ex);
            transaccion = false;
        }

        return transaccion;
    }

    public final boolean setFoto(final Candidato mCandidato) {
        boolean transaccion = true;

        try {
            PreparedStatement ops;

            String query2 = "UPDATE CANDIDATOS SET FOTOGRAFIA = ? "
                    + "WHERE MATRICULA = ?";

            ops = conexion.getConexion().prepareStatement(query2);
            System.out.println("Direccion de archivo: " + mCandidato.getFotografia());

            File fBlob = new File(mCandidato.getFotografia());
            FileInputStream is = null;
            try {
                is = new FileInputStream(fBlob);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(HelperCandidatos.class.getName()).log(Level.SEVERE, null, ex);
            }

            ops.setBinaryStream(1, is, fBlob.length());
            ops.setString(2, mCandidato.getMatricula());
            //ops.setString(2, mCandidato.getMatricula());
            System.out.println("justo antes del que se ejecute el EXCUTE OPS");
            ops.executeUpdate();
            confirmar();
        } catch (SQLException ex) {
            System.out.println("BaseDatos.CandidatoDBHelper"
                    + ".SetCartaCompromiso() " + ex);
            transaccion = false;
        }

        return transaccion;
    }

}
