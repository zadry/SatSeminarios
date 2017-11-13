/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satseminarios.Logic;

import java.sql.Blob;

/**
 *
 * @author javv
 */
public class CandidatoAceptado extends Candidato {

    private Asesor asesor;

    public CandidatoAceptado() {
    }

    /**
     *
     * @param fotografia
     * @param nombre
     * @param apellidoP
     * @param apellidoM
     * @param matricula
     * @param correo
     * @param telefono
     * @param generacion
     * @param temaTesis
     * @param directorTesis
     * @param carrera
     * @param trabaja
     */
    public CandidatoAceptado(Blob fotografia, String nombre, String apellidoP,
            String apellidoM, String matricula, String correo, String telefono,
            String generacion, String temaTesis, String directorTesis,
            String carrera, int trabaja, Asesor asesor) {
        super(fotografia, nombre, apellidoP, apellidoM, matricula, correo,
                telefono, generacion, temaTesis, directorTesis, carrera,
                trabaja);
        this.asesor = asesor;
    }

    /**
     *
     * @param fotografia
     * @param nombre
     * @param apellidoP
     * @param apellidoM
     * @param matricula
     * @param correo
     * @param telefono
     * @param generacion
     * @param temaTesis
     * @param directorTesis
     * @param carrera
     * @param trabaja
     * @param horario
     * @param lugarDeTrabajo
     * @param cartaMotivos
     * @param cartaCompromiso
     */
    public CandidatoAceptado(Blob fotografia, String nombre, String apellidoP,
            String apellidoM, String matricula, String correo, String telefono,
            String generacion, String temaTesis, String directorTesis,
            String carrera, int trabaja, String horario,
            String lugarDeTrabajo, Blob cartaMotivos, Blob cartaCompromiso,
            Asesor asesor) {
        super(fotografia, nombre, apellidoP, apellidoM, matricula, correo,
                telefono, generacion, temaTesis, directorTesis, carrera,
                trabaja, horario, lugarDeTrabajo, cartaMotivos,
                cartaCompromiso);
        this.asesor = asesor;
    }

    /**
     *
     * @return
     */
    public Asesor getAsesor() {
        return asesor;
    }

    /**
     *
     * @param asesor
     */
    public void setAsesor(Asesor asesor) {
        this.asesor = asesor;
    }

}
