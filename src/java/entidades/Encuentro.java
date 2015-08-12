/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author eborja
 */
@Entity
@Table(name = "encuentro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encuentro.findAll", query = "SELECT e FROM Encuentro e"),
    @NamedQuery(name = "Encuentro.findByIdEncuentro", query = "SELECT e FROM Encuentro e WHERE e.idEncuentro = :idEncuentro"),
    @NamedQuery(name = "Encuentro.findByFecha", query = "SELECT e FROM Encuentro e WHERE e.fecha = :fecha")})
public class Encuentro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_encuentro")
    private Integer idEncuentro;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "encuentro")
    private List<EquiposAJugar> equiposAJugarList;
    @JoinColumns({
        @JoinColumn(name = "id_torneo", referencedColumnName = "id_torneo"),
        @JoinColumn(name = "id_disciplina", referencedColumnName = "id_disciplina")})
    @ManyToOne(optional = false)
    private DisciplinaTorneo disciplinaTorneo;
    @JoinColumn(name = "id_cancha", referencedColumnName = "id_cancha")
    @ManyToOne(optional = false)
    private Cancha idCancha;
    @JoinColumn(name = "id_arbitro", referencedColumnName = "id_arbitro")
    @ManyToOne(optional = false)
    private Arbitro idArbitro;

    public Encuentro() {
    }

    public Encuentro(Integer idEncuentro) {
        this.idEncuentro = idEncuentro;
    }

    public Integer getIdEncuentro() {
        return idEncuentro;
    }

    public void setIdEncuentro(Integer idEncuentro) {
        this.idEncuentro = idEncuentro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<EquiposAJugar> getEquiposAJugarList() {
        return equiposAJugarList;
    }

    public void setEquiposAJugarList(List<EquiposAJugar> equiposAJugarList) {
        this.equiposAJugarList = equiposAJugarList;
    }

    public DisciplinaTorneo getDisciplinaTorneo() {
        return disciplinaTorneo;
    }

    public void setDisciplinaTorneo(DisciplinaTorneo disciplinaTorneo) {
        this.disciplinaTorneo = disciplinaTorneo;
    }

    public Cancha getIdCancha() {
        return idCancha;
    }

    public void setIdCancha(Cancha idCancha) {
        this.idCancha = idCancha;
    }

    public Arbitro getIdArbitro() {
        return idArbitro;
    }

    public void setIdArbitro(Arbitro idArbitro) {
        this.idArbitro = idArbitro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEncuentro != null ? idEncuentro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encuentro)) {
            return false;
        }
        Encuentro other = (Encuentro) object;
        if ((this.idEncuentro == null && other.idEncuentro != null) || (this.idEncuentro != null && !this.idEncuentro.equals(other.idEncuentro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Encuentro[ idEncuentro=" + idEncuentro + " ]";
    }
    
}
