/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author eborja
 */
@Entity
@Table(name = "equipos_a_jugar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquiposAJugar.findAll", query = "SELECT e FROM EquiposAJugar e"),
    @NamedQuery(name = "EquiposAJugar.findByIdEquiposAJugar", query = "SELECT e FROM EquiposAJugar e WHERE e.equiposAJugarPK.idEquiposAJugar = :idEquiposAJugar"),
    @NamedQuery(name = "EquiposAJugar.findByIdEncuentro", query = "SELECT e FROM EquiposAJugar e WHERE e.equiposAJugarPK.idEncuentro = :idEncuentro"),
    @NamedQuery(name = "EquiposAJugar.findByIdEquipo", query = "SELECT e FROM EquiposAJugar e WHERE e.equiposAJugarPK.idEquipo = :idEquipo"),
    @NamedQuery(name = "EquiposAJugar.findByIdDisciplina", query = "SELECT e FROM EquiposAJugar e WHERE e.equiposAJugarPK.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "EquiposAJugar.findByIdTorneo", query = "SELECT e FROM EquiposAJugar e WHERE e.equiposAJugarPK.idTorneo = :idTorneo"),
    @NamedQuery(name = "EquiposAJugar.findByNumeroParticipante", query = "SELECT e FROM EquiposAJugar e WHERE e.numeroParticipante = :numeroParticipante")})
public class EquiposAJugar implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EquiposAJugarPK equiposAJugarPK;
    @Column(name = "numero_participante")
    private Integer numeroParticipante;
    @JoinColumns({
        @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", insertable = false, updatable = false),
        @JoinColumn(name = "id_disciplina", referencedColumnName = "id_disciplina", insertable = false, updatable = false),
        @JoinColumn(name = "id_torneo", referencedColumnName = "id_torneo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Inscripcion inscripcion;
    @JoinColumn(name = "id_encuentro", referencedColumnName = "id_encuentro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Encuentro encuentro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equiposAJugar")
    private List<Partido> partidoList;

    public EquiposAJugar() {
    }

    public EquiposAJugar(EquiposAJugarPK equiposAJugarPK) {
        this.equiposAJugarPK = equiposAJugarPK;
    }

    public EquiposAJugar(int idEquiposAJugar, int idEncuentro, int idEquipo, int idDisciplina, int idTorneo) {
        this.equiposAJugarPK = new EquiposAJugarPK(idEquiposAJugar, idEncuentro, idEquipo, idDisciplina, idTorneo);
    }

    public EquiposAJugarPK getEquiposAJugarPK() {
        return equiposAJugarPK;
    }

    public void setEquiposAJugarPK(EquiposAJugarPK equiposAJugarPK) {
        this.equiposAJugarPK = equiposAJugarPK;
    }

    public Integer getNumeroParticipante() {
        return numeroParticipante;
    }

    public void setNumeroParticipante(Integer numeroParticipante) {
        this.numeroParticipante = numeroParticipante;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public Encuentro getEncuentro() {
        return encuentro;
    }

    public void setEncuentro(Encuentro encuentro) {
        this.encuentro = encuentro;
    }

    @XmlTransient
    public List<Partido> getPartidoList() {
        return partidoList;
    }

    public void setPartidoList(List<Partido> partidoList) {
        this.partidoList = partidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equiposAJugarPK != null ? equiposAJugarPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquiposAJugar)) {
            return false;
        }
        EquiposAJugar other = (EquiposAJugar) object;
        if ((this.equiposAJugarPK == null && other.equiposAJugarPK != null) || (this.equiposAJugarPK != null && !this.equiposAJugarPK.equals(other.equiposAJugarPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.EquiposAJugar[ equiposAJugarPK=" + equiposAJugarPK + " ]";
    }
    
}
