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
public class JugadorEquipoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_jugador")
    private int idJugador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_equipo")
    private int idEquipo;

    public JugadorEquipoPK() {
    }

    public JugadorEquipoPK(int idJugador, int idEquipo) {
        this.idJugador = idJugador;
        this.idEquipo = idEquipo;
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
        hash += (int) idJugador;
        hash += (int) idEquipo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JugadorEquipoPK)) {
            return false;
        }
        JugadorEquipoPK other = (JugadorEquipoPK) object;
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
        return "entidades.JugadorEquipoPK[ idJugador=" + idJugador + ", idEquipo=" + idEquipo + " ]";
    }
    
}
