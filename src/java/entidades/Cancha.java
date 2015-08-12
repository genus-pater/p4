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
@Table(name = "cancha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cancha.findAll", query = "SELECT c FROM Cancha c"),
    @NamedQuery(name = "Cancha.findByIdCancha", query = "SELECT c FROM Cancha c WHERE c.idCancha = :idCancha"),
    @NamedQuery(name = "Cancha.findByUbicacion", query = "SELECT c FROM Cancha c WHERE c.ubicacion = :ubicacion")})
public class Cancha implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cancha")
    private Integer idCancha;
    @Size(max = 50)
    @Column(name = "ubicacion")
    private String ubicacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCancha")
    private List<Encuentro> encuentroList;

    public Cancha() {
    }

    public Cancha(Integer idCancha) {
        this.idCancha = idCancha;
    }

    public Integer getIdCancha() {
        return idCancha;
    }

    public void setIdCancha(Integer idCancha) {
        this.idCancha = idCancha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @XmlTransient
    public List<Encuentro> getEncuentroList() {
        return encuentroList;
    }

    public void setEncuentroList(List<Encuentro> encuentroList) {
        this.encuentroList = encuentroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCancha != null ? idCancha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cancha)) {
            return false;
        }
        Cancha other = (Cancha) object;
        if ((this.idCancha == null && other.idCancha != null) || (this.idCancha != null && !this.idCancha.equals(other.idCancha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Cancha[ idCancha=" + idCancha + " ]";
    }
    
}
