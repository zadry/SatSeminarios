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
public class Asesor {

    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String correo;
    private String cubiculo;
    private String horarioAsesorias;
    private String pass;

    public Asesor(String nombre, String apellidoP, String apellidoM, String correo, String cubiculo, String horarioAsesorias, String pass) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.correo = correo;
        this.cubiculo = cubiculo;
        this.horarioAsesorias = horarioAsesorias;
        this.pass = pass;
    }

    public String getCubiculo() {
        return cubiculo;
    }

    public void setCubiculo(String cubiculo) {
        this.cubiculo = cubiculo;
    }

    public String getHorarioAsesorias() {
        return horarioAsesorias;
    }

    public void setHorarioAsesorias(String horarioAsesorias) {
        this.horarioAsesorias = horarioAsesorias;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Asesor() {
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
