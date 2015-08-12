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
public class InscripcionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_equipo")
    private int idEquipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_disciplina")
    private int idDisciplina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_torneo")
    private int idTorneo;

    public InscripcionPK() {
    }

    public InscripcionPK(int idEquipo, int idDisciplina, int idTorneo) {
        this.idEquipo = idEquipo;
        this.idDisciplina = idDisciplina;
        this.idTorneo = idTorneo;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEquipo;
        hash += (int) idDisciplina;
        hash += (int) idTorneo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InscripcionPK)) {
            return false;
        }
        InscripcionPK other = (InscripcionPK) object;
        if (this.idEquipo != other.idEquipo) {
            return false;
        }
        if (this.idDisciplina != other.idDisciplina) {
            return false;
        }
        if (this.idTorneo != other.idTorneo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.InscripcionPK[ idEquipo=" + idEquipo + ", idDisciplina=" + idDisciplina + ", idTorneo=" + idTorneo + " ]";
    }
    
}
