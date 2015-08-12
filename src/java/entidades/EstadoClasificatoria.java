/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author eborja
 */
@Entity
@Table(name = "estado_clasificatoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoClasificatoria.findAll", query = "SELECT e FROM EstadoClasificatoria e"),
    @NamedQuery(name = "EstadoClasificatoria.findByIdEstadoClasificatoria", query = "SELECT e FROM EstadoClasificatoria e WHERE e.idEstadoClasificatoria = :idEstadoClasificatoria"),
    @NamedQuery(name = "EstadoClasificatoria.findByDescripcion", query = "SELECT e FROM EstadoClasificatoria e WHERE e.descripcion = :descripcion")})
public class EstadoClasificatoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estado_clasificatoria")
    private Integer idEstadoClasificatoria;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idEstadoClasificatoria")
    private List<Clasificatoria> clasificatoriaList;

    public EstadoClasificatoria() {
    }

    public EstadoClasificatoria(Integer idEstadoClasificatoria) {
        this.idEstadoClasificatoria = idEstadoClasificatoria;
    }

    public Integer getIdEstadoClasificatoria() {
        return idEstadoClasificatoria;
    }

    public void setIdEstadoClasificatoria(Integer idEstadoClasificatoria) {
        this.idEstadoClasificatoria = idEstadoClasificatoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Clasificatoria> getClasificatoriaList() {
        return clasificatoriaList;
    }

    public void setClasificatoriaList(List<Clasificatoria> clasificatoriaList) {
        this.clasificatoriaList = clasificatoriaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoClasificatoria != null ? idEstadoClasificatoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoClasificatoria)) {
            return false;
        }
        EstadoClasificatoria other = (EstadoClasificatoria) object;
        if ((this.idEstadoClasificatoria == null && other.idEstadoClasificatoria != null) || (this.idEstadoClasificatoria != null && !this.idEstadoClasificatoria.equals(other.idEstadoClasificatoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.EstadoClasificatoria[ idEstadoClasificatoria=" + idEstadoClasificatoria + " ]";
    }
    
}
