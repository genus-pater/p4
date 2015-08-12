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
@Table(name = "disciplina_torneo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DisciplinaTorneo.findAll", query = "SELECT d FROM DisciplinaTorneo d"),
    @NamedQuery(name = "DisciplinaTorneo.findByIdTorneo", query = "SELECT d FROM DisciplinaTorneo d WHERE d.disciplinaTorneoPK.idTorneo = :idTorneo"),
    @NamedQuery(name = "DisciplinaTorneo.findByIdDisciplina", query = "SELECT d FROM DisciplinaTorneo d WHERE d.disciplinaTorneoPK.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "DisciplinaTorneo.findByFecha", query = "SELECT d FROM DisciplinaTorneo d WHERE d.fecha = :fecha")})
public class DisciplinaTorneo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DisciplinaTorneoPK disciplinaTorneoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_torneo", referencedColumnName = "id_torneo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Torneo torneo;
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id_discilina", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Disciplina disciplina;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplinaTorneo")
    private List<Inscripcion> inscripcionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplinaTorneo")
    private List<Encuentro> encuentroList;

    public DisciplinaTorneo() {
    }

    public DisciplinaTorneo(DisciplinaTorneoPK disciplinaTorneoPK) {
        this.disciplinaTorneoPK = disciplinaTorneoPK;
    }

    public DisciplinaTorneo(DisciplinaTorneoPK disciplinaTorneoPK, Date fecha) {
        this.disciplinaTorneoPK = disciplinaTorneoPK;
        this.fecha = fecha;
    }

    public DisciplinaTorneo(int idTorneo, int idDisciplina) {
        this.disciplinaTorneoPK = new DisciplinaTorneoPK(idTorneo, idDisciplina);
    }

    public DisciplinaTorneoPK getDisciplinaTorneoPK() {
        return disciplinaTorneoPK;
    }

    public void setDisciplinaTorneoPK(DisciplinaTorneoPK disciplinaTorneoPK) {
        this.disciplinaTorneoPK = disciplinaTorneoPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @XmlTransient
    public List<Inscripcion> getInscripcionList() {
        return inscripcionList;
    }

    public void setInscripcionList(List<Inscripcion> inscripcionList) {
        this.inscripcionList = inscripcionList;
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
        hash += (disciplinaTorneoPK != null ? disciplinaTorneoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisciplinaTorneo)) {
            return false;
        }
        DisciplinaTorneo other = (DisciplinaTorneo) object;
        if ((this.disciplinaTorneoPK == null && other.disciplinaTorneoPK != null) || (this.disciplinaTorneoPK != null && !this.disciplinaTorneoPK.equals(other.disciplinaTorneoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DisciplinaTorneo[ disciplinaTorneoPK=" + disciplinaTorneoPK + " ]";
    }
    
}
