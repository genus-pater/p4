/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eborja
 */
@Entity
@Table(name = "resultado_equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResultadoEquipo.findAll", query = "SELECT r FROM ResultadoEquipo r"),
    @NamedQuery(name = "ResultadoEquipo.findByIdPartido", query = "SELECT r FROM ResultadoEquipo r WHERE r.resultadoEquipoPK.idPartido = :idPartido"),
    @NamedQuery(name = "ResultadoEquipo.findByIdEquiposAJugar", query = "SELECT r FROM ResultadoEquipo r WHERE r.resultadoEquipoPK.idEquiposAJugar = :idEquiposAJugar"),
    @NamedQuery(name = "ResultadoEquipo.findByIdEncuentro", query = "SELECT r FROM ResultadoEquipo r WHERE r.resultadoEquipoPK.idEncuentro = :idEncuentro"),
    @NamedQuery(name = "ResultadoEquipo.findByIdEquipo", query = "SELECT r FROM ResultadoEquipo r WHERE r.resultadoEquipoPK.idEquipo = :idEquipo"),
    @NamedQuery(name = "ResultadoEquipo.findByIdDisciplina", query = "SELECT r FROM ResultadoEquipo r WHERE r.resultadoEquipoPK.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "ResultadoEquipo.findByIdTorneo", query = "SELECT r FROM ResultadoEquipo r WHERE r.resultadoEquipoPK.idTorneo = :idTorneo"),
    @NamedQuery(name = "ResultadoEquipo.findByResultadoEquipo", query = "SELECT r FROM ResultadoEquipo r WHERE r.resultadoEquipo = :resultadoEquipo")})
public class ResultadoEquipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResultadoEquipoPK resultadoEquipoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "resultado_equipo")
    private Double resultadoEquipo;
    @JoinColumns({
        @JoinColumn(name = "id_partido", referencedColumnName = "id_partido", insertable = false, updatable = false),
        @JoinColumn(name = "id_equipos_a_jugar", referencedColumnName = "id_equipos_a_jugar", insertable = false, updatable = false),
        @JoinColumn(name = "id_encuentro", referencedColumnName = "id_encuentro", insertable = false, updatable = false),
        @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", insertable = false, updatable = false),
        @JoinColumn(name = "id_disciplina", referencedColumnName = "id_disciplina", insertable = false, updatable = false),
        @JoinColumn(name = "id_torneo", referencedColumnName = "id_torneo", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Partido partido;

    public ResultadoEquipo() {
    }

    public ResultadoEquipo(ResultadoEquipoPK resultadoEquipoPK) {
        this.resultadoEquipoPK = resultadoEquipoPK;
    }

    public ResultadoEquipo(int idPartido, int idEquiposAJugar, int idEncuentro, int idEquipo, int idDisciplina, int idTorneo) {
        this.resultadoEquipoPK = new ResultadoEquipoPK(idPartido, idEquiposAJugar, idEncuentro, idEquipo, idDisciplina, idTorneo);
    }

    public ResultadoEquipoPK getResultadoEquipoPK() {
        return resultadoEquipoPK;
    }

    public void setResultadoEquipoPK(ResultadoEquipoPK resultadoEquipoPK) {
        this.resultadoEquipoPK = resultadoEquipoPK;
    }

    public Double getResultadoEquipo() {
        return resultadoEquipo;
    }

    public void setResultadoEquipo(Double resultadoEquipo) {
        this.resultadoEquipo = resultadoEquipo;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resultadoEquipoPK != null ? resultadoEquipoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResultadoEquipo)) {
            return false;
        }
        ResultadoEquipo other = (ResultadoEquipo) object;
        if ((this.resultadoEquipoPK == null && other.resultadoEquipoPK != null) || (this.resultadoEquipoPK != null && !this.resultadoEquipoPK.equals(other.resultadoEquipoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ResultadoEquipo[ resultadoEquipoPK=" + resultadoEquipoPK + " ]";
    }
    
}
