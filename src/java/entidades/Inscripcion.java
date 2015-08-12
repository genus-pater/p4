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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "inscripcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscripcion.findAll", query = "SELECT i FROM Inscripcion i"),
    @NamedQuery(name = "Inscripcion.findByIdEquipo", query = "SELECT i FROM Inscripcion i WHERE i.inscripcionPK.idEquipo = :idEquipo"),
    @NamedQuery(name = "Inscripcion.findByIdDisciplina", query = "SELECT i FROM Inscripcion i WHERE i.inscripcionPK.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "Inscripcion.findByIdTorneo", query = "SELECT i FROM Inscripcion i WHERE i.inscripcionPK.idTorneo = :idTorneo"),
    @NamedQuery(name = "Inscripcion.findByFecha", query = "SELECT i FROM Inscripcion i WHERE i.fecha = :fecha")})
public class Inscripcion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InscripcionPK inscripcionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inscripcion")
    private List<Clasificatoria> clasificatoriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inscripcion")
    private List<EquiposAJugar> equiposAJugarList;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipo equipo;
    @JoinColumns({
        @JoinColumn(name = "id_disciplina", referencedColumnName = "id_disciplina", insertable = false, updatable = false),
        @JoinColumn(name = "id_torneo", referencedColumnName = "id_torneo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private DisciplinaTorneo disciplinaTorneo;

    public Inscripcion() {
    }

    public Inscripcion(InscripcionPK inscripcionPK) {
        this.inscripcionPK = inscripcionPK;
    }

    public Inscripcion(InscripcionPK inscripcionPK, Date fecha) {
        this.inscripcionPK = inscripcionPK;
        this.fecha = fecha;
    }

    public Inscripcion(int idEquipo, int idDisciplina, int idTorneo) {
        this.inscripcionPK = new InscripcionPK(idEquipo, idDisciplina, idTorneo);
    }

    public InscripcionPK getInscripcionPK() {
        return inscripcionPK;
    }

    public void setInscripcionPK(InscripcionPK inscripcionPK) {
        this.inscripcionPK = inscripcionPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<Clasificatoria> getClasificatoriaList() {
        return clasificatoriaList;
    }

    public void setClasificatoriaList(List<Clasificatoria> clasificatoriaList) {
        this.clasificatoriaList = clasificatoriaList;
    }

    @XmlTransient
    public List<EquiposAJugar> getEquiposAJugarList() {
        return equiposAJugarList;
    }

    public void setEquiposAJugarList(List<EquiposAJugar> equiposAJugarList) {
        this.equiposAJugarList = equiposAJugarList;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public DisciplinaTorneo getDisciplinaTorneo() {
        return disciplinaTorneo;
    }

    public void setDisciplinaTorneo(DisciplinaTorneo disciplinaTorneo) {
        this.disciplinaTorneo = disciplinaTorneo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inscripcionPK != null ? inscripcionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscripcion)) {
            return false;
        }
        Inscripcion other = (Inscripcion) object;
        if ((this.inscripcionPK == null && other.inscripcionPK != null) || (this.inscripcionPK != null && !this.inscripcionPK.equals(other.inscripcionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Inscripcion[ inscripcionPK=" + inscripcionPK + " ]";
    }
    
}
