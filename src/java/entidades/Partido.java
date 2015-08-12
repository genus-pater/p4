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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author eborja
 */
@Entity
@Table(name = "partido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partido.findAll", query = "SELECT p FROM Partido p"),
    @NamedQuery(name = "Partido.findByIdPartido", query = "SELECT p FROM Partido p WHERE p.partidoPK.idPartido = :idPartido"),
    @NamedQuery(name = "Partido.findByIdEquiposAJugar", query = "SELECT p FROM Partido p WHERE p.partidoPK.idEquiposAJugar = :idEquiposAJugar"),
    @NamedQuery(name = "Partido.findByIdEncuentro", query = "SELECT p FROM Partido p WHERE p.partidoPK.idEncuentro = :idEncuentro"),
    @NamedQuery(name = "Partido.findByIdEquipo", query = "SELECT p FROM Partido p WHERE p.partidoPK.idEquipo = :idEquipo"),
    @NamedQuery(name = "Partido.findByIdDisciplina", query = "SELECT p FROM Partido p WHERE p.partidoPK.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "Partido.findByIdTorneo", query = "SELECT p FROM Partido p WHERE p.partidoPK.idTorneo = :idTorneo"),
    @NamedQuery(name = "Partido.findByNueroPartido", query = "SELECT p FROM Partido p WHERE p.nueroPartido = :nueroPartido")})
public class Partido implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PartidoPK partidoPK;
    @Column(name = "nuero_partido")
    private Integer nueroPartido;
    @JoinColumns({
        @JoinColumn(name = "id_equipos_a_jugar", referencedColumnName = "id_equipos_a_jugar", insertable = false, updatable = false),
        @JoinColumn(name = "id_encuentro", referencedColumnName = "id_encuentro", insertable = false, updatable = false),
        @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", insertable = false, updatable = false),
        @JoinColumn(name = "id_disciplina", referencedColumnName = "id_disciplina", insertable = false, updatable = false),
        @JoinColumn(name = "id_torneo", referencedColumnName = "id_torneo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private EquiposAJugar equiposAJugar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partido")
    private List<Anotacion> anotacionList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "partido")
    private ResultadoEquipo resultadoEquipo;

    public Partido() {
    }

    public Partido(PartidoPK partidoPK) {
        this.partidoPK = partidoPK;
    }

    public Partido(int idPartido, int idEquiposAJugar, int idEncuentro, int idEquipo, int idDisciplina, int idTorneo) {
        this.partidoPK = new PartidoPK(idPartido, idEquiposAJugar, idEncuentro, idEquipo, idDisciplina, idTorneo);
    }

    public PartidoPK getPartidoPK() {
        return partidoPK;
    }

    public void setPartidoPK(PartidoPK partidoPK) {
        this.partidoPK = partidoPK;
    }

    public Integer getNueroPartido() {
        return nueroPartido;
    }

    public void setNueroPartido(Integer nueroPartido) {
        this.nueroPartido = nueroPartido;
    }

    public EquiposAJugar getEquiposAJugar() {
        return equiposAJugar;
    }

    public void setEquiposAJugar(EquiposAJugar equiposAJugar) {
        this.equiposAJugar = equiposAJugar;
    }

    @XmlTransient
    public List<Anotacion> getAnotacionList() {
        return anotacionList;
    }

    public void setAnotacionList(List<Anotacion> anotacionList) {
        this.anotacionList = anotacionList;
    }

    public ResultadoEquipo getResultadoEquipo() {
        return resultadoEquipo;
    }

    public void setResultadoEquipo(ResultadoEquipo resultadoEquipo) {
        this.resultadoEquipo = resultadoEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partidoPK != null ? partidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partido)) {
            return false;
        }
        Partido other = (Partido) object;
        if ((this.partidoPK == null && other.partidoPK != null) || (this.partidoPK != null && !this.partidoPK.equals(other.partidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Partido[ partidoPK=" + partidoPK + " ]";
    }
    
}
