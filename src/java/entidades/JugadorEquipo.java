/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author eborja
 */
@Entity
@Table(name = "jugador_equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JugadorEquipo.findAll", query = "SELECT j FROM JugadorEquipo j"),
    @NamedQuery(name = "JugadorEquipo.findByIdJugador", query = "SELECT j FROM JugadorEquipo j WHERE j.jugadorEquipoPK.idJugador = :idJugador"),
    @NamedQuery(name = "JugadorEquipo.findByIdEquipo", query = "SELECT j FROM JugadorEquipo j WHERE j.jugadorEquipoPK.idEquipo = :idEquipo"),
    @NamedQuery(name = "JugadorEquipo.findByNJugador", query = "SELECT j FROM JugadorEquipo j WHERE j.nJugador = :nJugador")})
public class JugadorEquipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JugadorEquipoPK jugadorEquipoPK;
    @Column(name = "n_jugador")
    private Integer nJugador;
    @Column(name = "foto")
    private Byte[] foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jugadorEquipo")
    private List<Anotacion> anotacionList;
    @JoinColumn(name = "id_jugador", referencedColumnName = "id_jugador", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Jugador jugador;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipo equipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jugadorEquipo")
    private List<JugadorEquipoSancion> jugadorEquipoSancionList;

    public JugadorEquipo() {
        jugador=new Jugador();
    }

    public JugadorEquipo(JugadorEquipoPK jugadorEquipoPK) {
        this.jugadorEquipoPK = jugadorEquipoPK;
    }

    public JugadorEquipo(int idJugador, int idEquipo) {
        this.jugadorEquipoPK = new JugadorEquipoPK(idJugador, idEquipo);
    }

    public JugadorEquipoPK getJugadorEquipoPK() {
        return jugadorEquipoPK;
    }

    public void setJugadorEquipoPK(JugadorEquipoPK jugadorEquipoPK) {
        this.jugadorEquipoPK = jugadorEquipoPK;
    }

    public Integer getNJugador() {
        return nJugador;
    }

    public void setNJugador(Integer nJugador) {
        this.nJugador = nJugador;
    }

    @XmlTransient
    public List<Anotacion> getAnotacionList() {
        return anotacionList;
    }

    public void setAnotacionList(List<Anotacion> anotacionList) {
        this.anotacionList = anotacionList;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @XmlTransient
    public List<JugadorEquipoSancion> getJugadorEquipoSancionList() {
        return jugadorEquipoSancionList;
    }

    public void setJugadorEquipoSancionList(List<JugadorEquipoSancion> jugadorEquipoSancionList) {
        this.jugadorEquipoSancionList = jugadorEquipoSancionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jugadorEquipoPK != null ? jugadorEquipoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JugadorEquipo)) {
            return false;
        }
        JugadorEquipo other = (JugadorEquipo) object;
        if ((this.jugadorEquipoPK == null && other.jugadorEquipoPK != null) || (this.jugadorEquipoPK != null && !this.jugadorEquipoPK.equals(other.jugadorEquipoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.JugadorEquipo[ jugadorEquipoPK=" + jugadorEquipoPK + " ]";
    }

    /**
     * @return the foto
     */
    public Byte[] getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(Byte[] foto) {
        this.foto = foto;
    }
    
}
