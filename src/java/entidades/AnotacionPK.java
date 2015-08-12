/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author eborja
 */
@Embeddable
public class AnotacionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_anotacion")
    private int idAnotacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_partido")
    private int idPartido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_torneo")
    private int idTorneo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_disciplina")
    private int idDisciplina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_encuentro")
    private int idEncuentro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_jugador")
    private int idJugador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_equipo")
    private int idEquipo;

    public AnotacionPK() {
    }

    public AnotacionPK(int idAnotacion, int idPartido, int idTorneo, int idDisciplina, int idEncuentro, int idJugador, int idEquipo) {
        this.idAnotacion = idAnotacion;
        this.idPartido = idPartido;
        this.idTorneo = idTorneo;
        this.idDisciplina = idDisciplina;
        this.idEncuentro = idEncuentro;
        this.idJugador = idJugador;
        this.idEquipo = idEquipo;
    }

    public int getIdAnotacion() {
        return idAnotacion;
    }

    public void setIdAnotacion(int idAnotacion) {
        this.idAnotacion = idAnotacion;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public int getIdEncuentro() {
        return idEncuentro;
    }

    public void setIdEncuentro(int idEncuentro) {
        this.idEncuentro = idEncuentro;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAnotacion;
        hash += (int) idPartido;
        hash += (int) idTorneo;
        hash += (int) idDisciplina;
        hash += (int) idEncuentro;
        hash += (int) idJugador;
        hash += (int) idEquipo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnotacionPK)) {
            return false;
        }
        AnotacionPK other = (AnotacionPK) object;
        if (this.idAnotacion != other.idAnotacion) {
            return false;
        }
        if (this.idPartido != other.idPartido) {
            return false;
        }
        if (this.idTorneo != other.idTorneo) {
            return false;
        }
        if (this.idDisciplina != other.idDisciplina) {
            return false;
        }
        if (this.idEncuentro != other.idEncuentro) {
            return false;
        }
        if (this.idJugador != other.idJugador) {
            return false;
        }
        if (this.idEquipo != other.idEquipo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.AnotacionPK[ idAnotacion=" + idAnotacion + ", idPartido=" + idPartido + ", idTorneo=" + idTorneo + ", idDisciplina=" + idDisciplina + ", idEncuentro=" + idEncuentro + ", idJugador=" + idJugador + ", idEquipo=" + idEquipo + " ]";
    }
    
}
