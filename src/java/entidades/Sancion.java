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
@Table(name = "sancion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sancion.findAll", query = "SELECT s FROM Sancion s"),
    @NamedQuery(name = "Sancion.findByIdSancion", query = "SELECT s FROM Sancion s WHERE s.idSancion = :idSancion"),
    @NamedQuery(name = "Sancion.findByNombre", query = "SELECT s FROM Sancion s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Sancion.findByDescripcion", query = "SELECT s FROM Sancion s WHERE s.descripcion = :descripcion")})
public class Sancion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sancion")
    private Integer idSancion;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sancion")
    private List<JugadorEquipoSancion> jugadorEquipoSancionList;

    public Sancion() {
    }

    public Sancion(Integer idSancion) {
        this.idSancion = idSancion;
    }

    public Integer getIdSancion() {
        return idSancion;
    }

    public void setIdSancion(Integer idSancion) {
        this.idSancion = idSancion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idSancion != null ? idSancion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sancion)) {
            return false;
        }
        Sancion other = (Sancion) object;
        if ((this.idSancion == null && other.idSancion != null) || (this.idSancion != null && !this.idSancion.equals(other.idSancion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Sancion[ idSancion=" + idSancion + " ]";
    }
    
}
