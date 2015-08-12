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
@Table(name = "clasificatoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clasificatoria.findAll", query = "SELECT c FROM Clasificatoria c"),
    @NamedQuery(name = "Clasificatoria.findByIdClasificatoria", query = "SELECT c FROM Clasificatoria c WHERE c.clasificatoriaPK.idClasificatoria = :idClasificatoria"),
    @NamedQuery(name = "Clasificatoria.findByIdTipoClasificatoria", query = "SELECT c FROM Clasificatoria c WHERE c.clasificatoriaPK.idTipoClasificatoria = :idTipoClasificatoria"),
    @NamedQuery(name = "Clasificatoria.findByIdTorneo", query = "SELECT c FROM Clasificatoria c WHERE c.clasificatoriaPK.idTorneo = :idTorneo"),
    @NamedQuery(name = "Clasificatoria.findByIdEquipo", query = "SELECT c FROM Clasificatoria c WHERE c.clasificatoriaPK.idEquipo = :idEquipo"),
    @NamedQuery(name = "Clasificatoria.findByDescripcion", query = "SELECT c FROM Clasificatoria c WHERE c.descripcion = :descripcion")})
public class Clasificatoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClasificatoriaPK clasificatoriaPK;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_tipo_clasificatoria", referencedColumnName = "id_tipo_clasificatoria", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoClasificatoria tipoClasificatoria;
    @JoinColumns({
        @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", insertable = false, updatable = false),
        @JoinColumn(name = "id_disciplina", referencedColumnName = "id_disciplina"),
        @JoinColumn(name = "id_torneo", referencedColumnName = "id_torneo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Inscripcion inscripcion;
    @JoinColumn(name = "id_estado_clasificatoria", referencedColumnName = "id_estado_clasificatoria")
    @ManyToOne
    private EstadoClasificatoria idEstadoClasificatoria;

    public Clasificatoria() {
    }

    public Clasificatoria(ClasificatoriaPK clasificatoriaPK) {
        this.clasificatoriaPK = clasificatoriaPK;
    }

    public Clasificatoria(int idClasificatoria, int idTipoClasificatoria, int idTorneo, int idEquipo) {
        this.clasificatoriaPK = new ClasificatoriaPK(idClasificatoria, idTipoClasificatoria, idTorneo, idEquipo);
    }

    public ClasificatoriaPK getClasificatoriaPK() {
        return clasificatoriaPK;
    }

    public void setClasificatoriaPK(ClasificatoriaPK clasificatoriaPK) {
        this.clasificatoriaPK = clasificatoriaPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoClasificatoria getTipoClasificatoria() {
        return tipoClasificatoria;
    }

    public void setTipoClasificatoria(TipoClasificatoria tipoClasificatoria) {
        this.tipoClasificatoria = tipoClasificatoria;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public EstadoClasificatoria getIdEstadoClasificatoria() {
        return idEstadoClasificatoria;
    }

    public void setIdEstadoClasificatoria(EstadoClasificatoria idEstadoClasificatoria) {
        this.idEstadoClasificatoria = idEstadoClasificatoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clasificatoriaPK != null ? clasificatoriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clasificatoria)) {
            return false;
        }
        Clasificatoria other = (Clasificatoria) object;
        if ((this.clasificatoriaPK == null && other.clasificatoriaPK != null) || (this.clasificatoriaPK != null && !this.clasificatoriaPK.equals(other.clasificatoriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Clasificatoria[ clasificatoriaPK=" + clasificatoriaPK + " ]";
    }
    
}
