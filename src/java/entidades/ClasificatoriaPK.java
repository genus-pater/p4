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
public class ClasificatoriaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_clasificatoria")
    private int idClasificatoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_clasificatoria")
    private int idTipoClasificatoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_torneo")
    private int idTorneo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_equipo")
    private int idEquipo;

    public ClasificatoriaPK() {
    }

    public ClasificatoriaPK(int idClasificatoria, int idTipoClasificatoria, int idTorneo, int idEquipo) {
        this.idClasificatoria = idClasificatoria;
        this.idTipoClasificatoria = idTipoClasificatoria;
        this.idTorneo = idTorneo;
        this.idEquipo = idEquipo;
    }

    public int getIdClasificatoria() {
        return idClasificatoria;
    }

    public void setIdClasificatoria(int idClasificatoria) {
        this.idClasificatoria = idClasificatoria;
    }

    public int getIdTipoClasificatoria() {
        return idTipoClasificatoria;
    }

    public void setIdTipoClasificatoria(int idTipoClasificatoria) {
        this.idTipoClasificatoria = idTipoClasificatoria;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
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
        hash += (int) idClasificatoria;
        hash += (int) idTipoClasificatoria;
        hash += (int) idTorneo;
        hash += (int) idEquipo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClasificatoriaPK)) {
            return false;
        }
        ClasificatoriaPK other = (ClasificatoriaPK) object;
        if (this.idClasificatoria != other.idClasificatoria) {
            return false;
        }
        if (this.idTipoClasificatoria != other.idTipoClasificatoria) {
            return false;
        }
        if (this.idTorneo != other.idTorneo) {
            return false;
        }
        if (this.idEquipo != other.idEquipo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ClasificatoriaPK[ idClasificatoria=" + idClasificatoria + ", idTipoClasificatoria=" + idTipoClasificatoria + ", idTorneo=" + idTorneo + ", idEquipo=" + idEquipo + " ]";
    }
    
}
