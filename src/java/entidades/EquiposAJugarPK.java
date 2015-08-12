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
public class EquiposAJugarPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_equipos_a_jugar")
    private int idEquiposAJugar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_encuentro")
    private int idEncuentro;
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

    public EquiposAJugarPK() {
    }

    public EquiposAJugarPK(int idEquiposAJugar, int idEncuentro, int idEquipo, int idDisciplina, int idTorneo) {
        this.idEquiposAJugar = idEquiposAJugar;
        this.idEncuentro = idEncuentro;
        this.idEquipo = idEquipo;
        this.idDisciplina = idDisciplina;
        this.idTorneo = idTorneo;
    }

    public int getIdEquiposAJugar() {
        return idEquiposAJugar;
    }

    public void setIdEquiposAJugar(int idEquiposAJugar) {
        this.idEquiposAJugar = idEquiposAJugar;
    }

    public int getIdEncuentro() {
        return idEncuentro;
    }

    public void setIdEncuentro(int idEncuentro) {
        this.idEncuentro = idEncuentro;
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
        hash += (int) idEquiposAJugar;
        hash += (int) idEncuentro;
        hash += (int) idEquipo;
        hash += (int) idDisciplina;
        hash += (int) idTorneo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquiposAJugarPK)) {
            return false;
        }
        EquiposAJugarPK other = (EquiposAJugarPK) object;
        if (this.idEquiposAJugar != other.idEquiposAJugar) {
            return false;
        }
        if (this.idEncuentro != other.idEncuentro) {
            return false;
        }
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
        return "entidades.EquiposAJugarPK[ idEquiposAJugar=" + idEquiposAJugar + ", idEncuentro=" + idEncuentro + ", idEquipo=" + idEquipo + ", idDisciplina=" + idDisciplina + ", idTorneo=" + idTorneo + " ]";
    }
    
}
