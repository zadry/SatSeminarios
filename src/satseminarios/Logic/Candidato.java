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
public class Candidato {

    private String fotografia;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String matricula;
    private String correo;
    private String telefono;
    private String generacion;
    private String temaTesis;
    private String directorTesis;
    private String carrera;
    private int trabaja;
    private String horario;
    private String lugarDeTrabajo;
    private String cartaMotivos;

    private String cartaComprimisoS;

    /**
     *
     */
    public Candidato() {
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
    public Candidato(String fotografia, String nombre, String apellidoP,
            String apellidoM, String matricula, String correo, String telefono,
            String generacion, String temaTesis, String directorTesis,
            String carrera, int trabaja) {
        this.fotografia = fotografia;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.matricula = matricula;
        this.correo = correo;
        this.telefono = telefono;
        this.generacion = generacion;
        this.temaTesis = temaTesis;
        this.directorTesis = directorTesis;
        this.carrera = carrera;
        this.trabaja = trabaja;
    }

    public String getCartaComprimisoS() {
        return cartaComprimisoS;
    }

    public void setCartaComprimisoS(String cartaComprimisoS) {
        this.cartaComprimisoS = cartaComprimisoS;
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
    /**
     *
     * @return
     */
    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGeneracion() {
        return generacion;
    }

    public void setGeneracion(String generacion) {
        this.generacion = generacion;
    }

    public String getTemaTesis() {
        return temaTesis;
    }

    public void setTemaTesis(String temaTesis) {
        this.temaTesis = temaTesis;
    }

    public String getDirectorTesis() {
        return directorTesis;
    }

    public void setDirectorTesis(String directorTesis) {
        this.directorTesis = directorTesis;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getTrabaja() {
        return trabaja;
    }

    public void setTrabaja(int trabaja) {
        this.trabaja = trabaja;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getLugarDeTrabajo() {
        return lugarDeTrabajo;
    }

    public void setLugarDeTrabajo(String lugarDeTrabajo) {
        this.lugarDeTrabajo = lugarDeTrabajo;
    }

    public String getCartaMotivos() {
        return cartaMotivos;
    }

    public void setCartaMotivos(String cartaMotivos) {
        this.cartaMotivos = cartaMotivos;
    }

}
