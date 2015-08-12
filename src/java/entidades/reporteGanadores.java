/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;



/**
 *
 * @author eborja
 */
public class reporteGanadores  {
    private String Torneo;
    private String Disciplina;
    private String Descripcion;
    private String Equipo;
    private String Lugar;

    public reporteGanadores(String torneo, String disciplina, String descripcion, String equipo, String lugar) {
        this.Torneo = torneo;
        this.Disciplina = disciplina;
        this.Descripcion = descripcion;
        this.Equipo = equipo;
        this.Lugar = lugar;
    }

    public reporteGanadores() {
    }

    /**
     * @return the Torneo
     */
    public String getTorneo() {
        return Torneo;
    }

    /**
     * @param torneo the Torneo to set
     */
    public void setTorneo(String torneo) {
        this.Torneo = torneo;
    }

    /**
     * @return the Disciplina
     */
    public String getDisciplina() {
        return Disciplina;
    }

    /**
     * @param disciplina the Disciplina to set
     */
    public void setDisciplina(String disciplina) {
        this.Disciplina = disciplina;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param descripcion the Descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }

    /**
     * @return the Equipo
     */
    public String getEquipo() {
        return Equipo;
    }

    /**
     * @param equipo the Equipo to set
     */
    public void setEquipo(String equipo) {
        this.Equipo = equipo;
    }

    /**
     * @return the Lugar
     */
    public String getLugar() {
        return Lugar;
    }

    /**
     * @param lugar the Lugar to set
     */
    public void setLugar(String lugar) {
        this.Lugar = lugar;
    }
}
