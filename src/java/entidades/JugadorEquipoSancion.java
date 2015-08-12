/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eborja
 */
@Entity
@Table(name = "jugador_equipo_sancion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JugadorEquipoSancion.findAll", query = "SELECT j FROM JugadorEquipoSancion j"),
    @NamedQuery(name = "JugadorEquipoSancion.findByIdJugadorEquipoSancion", query = "SELECT j FROM JugadorEquipoSancion j WHERE j.jugadorEquipoSancionPK.idJugadorEquipoSancion = :idJugadorEquipoSancion"),
    @NamedQuery(name = "JugadorEquipoSancion.findByIdJugador", query = "SELECT j FROM JugadorEquipoSancion j WHERE j.jugadorEquipoSancionPK.idJugador = :idJugador"),
    @NamedQuery(name = "JugadorEquipoSancion.findByIdEquipo", query = "SELECT j FROM JugadorEquipoSancion j WHERE j.jugadorEquipoSancionPK.idEquipo = :idEquipo"),
    @NamedQuery(name = "JugadorEquipoSancion.findByIdSancion", query = "SELECT j FROM JugadorEquipoSancion j WHERE j.jugadorEquipoSancionPK.idSancion = :idSancion"),
    @NamedQuery(name = "JugadorEquipoSancion.findByFechaInicio", query = "SELECT j FROM JugadorEquipoSancion j WHERE j.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "JugadorEquipoSancion.findByFechaFin", query = "SELECT j FROM JugadorEquipoSancion j WHERE j.fechaFin = :fechaFin")})
public class JugadorEquipoSancion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JugadorEquipoSancionPK jugadorEquipoSancionPK;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @JoinColumn(name = "id_sancion", referencedColumnName = "id_sancion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sancion sancion;
    @JoinColumns({
        @JoinColumn(name = "id_jugador", referencedColumnName = "id_jugador", insertable = false, updatable = false),
        @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private JugadorEquipo jugadorEquipo;

    public JugadorEquipoSancion() {
    }

    public JugadorEquipoSancion(JugadorEquipoSancionPK jugadorEquipoSancionPK) {
        this.jugadorEquipoSancionPK = jugadorEquipoSancionPK;
    }

    public JugadorEquipoSancion(int idJugadorEquipoSancion, int idJugador, int idEquipo, int idSancion) {
        this.jugadorEquipoSancionPK = new JugadorEquipoSancionPK(idJugadorEquipoSancion, idJugador, idEquipo, idSancion);
    }

    public JugadorEquipoSancionPK getJugadorEquipoSancionPK() {
        return jugadorEquipoSancionPK;
    }

    public void setJugadorEquipoSancionPK(JugadorEquipoSancionPK jugadorEquipoSancionPK) {
        this.jugadorEquipoSancionPK = jugadorEquipoSancionPK;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Sancion getSancion() {
        return sancion;
    }

    public void setSancion(Sancion sancion) {
        this.sancion = sancion;
    }

    public JugadorEquipo getJugadorEquipo() {
        return jugadorEquipo;
    }

    public void setJugadorEquipo(JugadorEquipo jugadorEquipo) {
        this.jugadorEquipo = jugadorEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jugadorEquipoSancionPK != null ? jugadorEquipoSancionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JugadorEquipoSancion)) {
            return false;
        }
        JugadorEquipoSancion other = (JugadorEquipoSancion) object;
        if ((this.jugadorEquipoSancionPK == null && other.jugadorEquipoSancionPK != null) || (this.jugadorEquipoSancionPK != null && !this.jugadorEquipoSancionPK.equals(other.jugadorEquipoSancionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.JugadorEquipoSancion[ jugadorEquipoSancionPK=" + jugadorEquipoSancionPK + " ]";
    }
    
}
