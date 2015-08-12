/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "tipo_clasificatoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoClasificatoria.findAll", query = "SELECT t FROM TipoClasificatoria t"),
    @NamedQuery(name = "TipoClasificatoria.findByIdTipoClasificatoria", query = "SELECT t FROM TipoClasificatoria t WHERE t.idTipoClasificatoria = :idTipoClasificatoria"),
    @NamedQuery(name = "TipoClasificatoria.findByDescripcion", query = "SELECT t FROM TipoClasificatoria t WHERE t.descripcion = :descripcion")})
public class TipoClasificatoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_clasificatoria")
    private Integer idTipoClasificatoria;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoClasificatoria")
    private List<Clasificatoria> clasificatoriaList;

    public TipoClasificatoria() {
    }

    public TipoClasificatoria(Integer idTipoClasificatoria) {
        this.idTipoClasificatoria = idTipoClasificatoria;
    }

    public Integer getIdTipoClasificatoria() {
        return idTipoClasificatoria;
    }

    public void setIdTipoClasificatoria(Integer idTipoClasificatoria) {
        this.idTipoClasificatoria = idTipoClasificatoria;
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
        hash += (idTipoClasificatoria != null ? idTipoClasificatoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoClasificatoria)) {
            return false;
        }
        TipoClasificatoria other = (TipoClasificatoria) object;
        if ((this.idTipoClasificatoria == null && other.idTipoClasificatoria != null) || (this.idTipoClasificatoria != null && !this.idTipoClasificatoria.equals(other.idTipoClasificatoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoClasificatoria[ idTipoClasificatoria=" + idTipoClasificatoria + " ]";
    }
    
}
