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
public class MarcadorPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_marcador")
    private int idMarcador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_disciplina")
    private int idDisciplina;

    public MarcadorPK() {
    }

    public MarcadorPK(int idMarcador, int idDisciplina) {
        this.idMarcador = idMarcador;
        this.idDisciplina = idDisciplina;
    }

    public int getIdMarcador() {
        return idMarcador;
    }

    public void setIdMarcador(int idMarcador) {
        this.idMarcador = idMarcador;
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
        hash += (int) idMarcador;
        hash += (int) idDisciplina;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MarcadorPK)) {
            return false;
        }
        MarcadorPK other = (MarcadorPK) object;
        if (this.idMarcador != other.idMarcador) {
            return false;
        }
        if (this.idDisciplina != other.idDisciplina) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.MarcadorPK[ idMarcador=" + idMarcador + ", idDisciplina=" + idDisciplina + " ]";
    }
    
}
