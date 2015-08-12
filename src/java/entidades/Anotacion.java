/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eborja
 */
@Entity
@Table(name = "anotacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anotacion.findAll", query = "SELECT a FROM Anotacion a"),
    @NamedQuery(name = "Anotacion.findByIdAnotacion", query = "SELECT a FROM Anotacion a WHERE a.anotacionPK.idAnotacion = :idAnotacion"),
    @NamedQuery(name = "Anotacion.findByIdPartido", query = "SELECT a FROM Anotacion a WHERE a.anotacionPK.idPartido = :idPartido"),
    @NamedQuery(name = "Anotacion.findByIdTorneo", query = "SELECT a FROM Anotacion a WHERE a.anotacionPK.idTorneo = :idTorneo"),
    @NamedQuery(name = "Anotacion.findByIdDisciplina", query = "SELECT a FROM Anotacion a WHERE a.anotacionPK.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "Anotacion.findByIdEncuentro", query = "SELECT a FROM Anotacion a WHERE a.anotacionPK.idEncuentro = :idEncuentro"),
    @NamedQuery(name = "Anotacion.findByIdJugador", query = "SELECT a FROM Anotacion a WHERE a.anotacionPK.idJugador = :idJugador"),
    @NamedQuery(name = "Anotacion.findByIdEquipo", query = "SELECT a FROM Anotacion a WHERE a.anotacionPK.idEquipo = :idEquipo"),
    @NamedQuery(name = "Anotacion.findByCantidad", query = "SELECT a FROM Anotacion a WHERE a.cantidad = :cantidad"),
    @NamedQuery(name = "Anotacion.findByObservacion", query = "SELECT a FROM Anotacion a WHERE a.observacion = :observacion")})
public class Anotacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AnotacionPK anotacionPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private Double cantidad;
    @Size(max = 100)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumns({
        @JoinColumn(name = "id_partido", referencedColumnName = "id_partido", insertable = false, updatable = false),
        @JoinColumn(name = "id_equipos_a_jugar", referencedColumnName = "id_equipos_a_jugar"),
        @JoinColumn(name = "id_encuentro", referencedColumnName = "id_encuentro", insertable = false, updatable = false),
        @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", insertable = false, updatable = false),
        @JoinColumn(name = "id_disciplina", referencedColumnName = "id_disciplina", insertable = false, updatable = false),
        @JoinColumn(name = "id_torneo", referencedColumnName = "id_torneo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Partido partido;
    @JoinColumns({
        @JoinColumn(name = "id_jugador", referencedColumnName = "id_jugador", insertable = false, updatable = false),
        @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private JugadorEquipo jugadorEquipo;

    public Anotacion() {
    }

    public Anotacion(AnotacionPK anotacionPK) {
        this.anotacionPK = anotacionPK;
    }

    public Anotacion(int idAnotacion, int idPartido, int idTorneo, int idDisciplina, int idEncuentro, int idJugador, int idEquipo) {
        this.anotacionPK = new AnotacionPK(idAnotacion, idPartido, idTorneo, idDisciplina, idEncuentro, idJugador, idEquipo);
    }

    public AnotacionPK getAnotacionPK() {
        return anotacionPK;
    }

    public void setAnotacionPK(AnotacionPK anotacionPK) {
        this.anotacionPK = anotacionPK;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
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
        hash += (anotacionPK != null ? anotacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anotacion)) {
            return false;
        }
        Anotacion other = (Anotacion) object;
        if ((this.anotacionPK == null && other.anotacionPK != null) || (this.anotacionPK != null && !this.anotacionPK.equals(other.anotacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Anotacion[ anotacionPK=" + anotacionPK + " ]";
    }
    
}
