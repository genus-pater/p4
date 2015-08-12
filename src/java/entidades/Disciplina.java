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
@Table(name = "disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disciplina.findAll", query = "SELECT d FROM Disciplina d"),
    @NamedQuery(name = "Disciplina.findByIdDiscilina", query = "SELECT d FROM Disciplina d WHERE d.idDiscilina = :idDiscilina"),
    @NamedQuery(name = "Disciplina.findByNombre", query = "SELECT d FROM Disciplina d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Disciplina.findByEstado", query = "SELECT d FROM Disciplina d WHERE d.estado = :estado"),
    @NamedQuery(name = "Disciplina.findByCosto", query = "SELECT d FROM Disciplina d WHERE d.costo = :costo")})
public class Disciplina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_discilina")
    private Integer idDiscilina;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "estado")
    private Boolean estado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo")
    private Double costo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private List<DisciplinaTorneo> disciplinaTorneoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private List<Marcador> marcadorList;

    public Disciplina() {
    }

    public Disciplina(Integer idDiscilina) {
        this.idDiscilina = idDiscilina;
    }

    public Integer getIdDiscilina() {
        return idDiscilina;
    }

    public void setIdDiscilina(Integer idDiscilina) {
        this.idDiscilina = idDiscilina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    @XmlTransient
    public List<DisciplinaTorneo> getDisciplinaTorneoList() {
        return disciplinaTorneoList;
    }

    public void setDisciplinaTorneoList(List<DisciplinaTorneo> disciplinaTorneoList) {
        this.disciplinaTorneoList = disciplinaTorneoList;
    }

    @XmlTransient
    public List<Marcador> getMarcadorList() {
        return marcadorList;
    }

    public void setMarcadorList(List<Marcador> marcadorList) {
        this.marcadorList = marcadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiscilina != null ? idDiscilina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.idDiscilina == null && other.idDiscilina != null) || (this.idDiscilina != null && !this.idDiscilina.equals(other.idDiscilina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Disciplina[ idDiscilina=" + idDiscilina + " ]";
    }
    
}
