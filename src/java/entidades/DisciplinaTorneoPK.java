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
public class DisciplinaTorneoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_torneo")
    private int idTorneo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_disciplina")
    private int idDisciplina;

    public DisciplinaTorneoPK() {
    }

    public DisciplinaTorneoPK(int idTorneo, int idDisciplina) {
        this.idTorneo = idTorneo;
        this.idDisciplina = idDisciplina;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTorneo;
        hash += (int) idDisciplina;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisciplinaTorneoPK)) {
            return false;
        }
        DisciplinaTorneoPK other = (DisciplinaTorneoPK) object;
        if (this.idTorneo != other.idTorneo) {
            return false;
        }
        if (this.idDisciplina != other.idDisciplina) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DisciplinaTorneoPK[ idTorneo=" + idTorneo + ", idDisciplina=" + idDisciplina + " ]";
    }
    
}
