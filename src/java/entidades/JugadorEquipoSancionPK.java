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
public class JugadorEquipoSancionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_jugador_equipo_sancion")
    private int idJugadorEquipoSancion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_jugador")
    private int idJugador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_equipo")
    private int idEquipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sancion")
    private int idSancion;

    public JugadorEquipoSancionPK() {
    }

    public JugadorEquipoSancionPK(int idJugadorEquipoSancion, int idJugador, int idEquipo, int idSancion) {
        this.idJugadorEquipoSancion = idJugadorEquipoSancion;
        this.idJugador = idJugador;
        this.idEquipo = idEquipo;
        this.idSancion = idSancion;
    }

    public int getIdJugadorEquipoSancion() {
        return idJugadorEquipoSancion;
    }

    public void setIdJugadorEquipoSancion(int idJugadorEquipoSancion) {
        this.idJugadorEquipoSancion = idJugadorEquipoSancion;
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

    public int getIdSancion() {
        return idSancion;
    }

    public void setIdSancion(int idSancion) {
        this.idSancion = idSancion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idJugadorEquipoSancion;
        hash += (int) idJugador;
        hash += (int) idEquipo;
        hash += (int) idSancion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JugadorEquipoSancionPK)) {
            return false;
        }
        JugadorEquipoSancionPK other = (JugadorEquipoSancionPK) object;
        if (this.idJugadorEquipoSancion != other.idJugadorEquipoSancion) {
            return false;
        }
        if (this.idJugador != other.idJugador) {
            return false;
        }
        if (this.idEquipo != other.idEquipo) {
            return false;
        }
        if (this.idSancion != other.idSancion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.JugadorEquipoSancionPK[ idJugadorEquipoSancion=" + idJugadorEquipoSancion + ", idJugador=" + idJugador + ", idEquipo=" + idEquipo + ", idSancion=" + idSancion + " ]";
    }
    
}
