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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eborja
 */
@Entity
@Table(name = "marcador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marcador.findAll", query = "SELECT m FROM Marcador m"),
    @NamedQuery(name = "Marcador.findByIdMarcador", query = "SELECT m FROM Marcador m WHERE m.marcadorPK.idMarcador = :idMarcador"),
    @NamedQuery(name = "Marcador.findByIdDisciplina", query = "SELECT m FROM Marcador m WHERE m.marcadorPK.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "Marcador.findByDescripcion", query = "SELECT m FROM Marcador m WHERE m.descripcion = :descripcion")})
public class Marcador implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MarcadorPK marcadorPK;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id_discilina", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Disciplina disciplina;

    public Marcador() {
    }

    public Marcador(MarcadorPK marcadorPK) {
        this.marcadorPK = marcadorPK;
    }

    public Marcador(int idMarcador, int idDisciplina) {
        this.marcadorPK = new MarcadorPK(idMarcador, idDisciplina);
    }

    public MarcadorPK getMarcadorPK() {
        return marcadorPK;
    }

    public void setMarcadorPK(MarcadorPK marcadorPK) {
        this.marcadorPK = marcadorPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (marcadorPK != null ? marcadorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marcador)) {
            return false;
        }
        Marcador other = (Marcador) object;
        if ((this.marcadorPK == null && other.marcadorPK != null) || (this.marcadorPK != null && !this.marcadorPK.equals(other.marcadorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Marcador[ marcadorPK=" + marcadorPK + " ]";
    }
    
}
