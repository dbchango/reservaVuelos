/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author David
 */
@Entity
@Table(name = "REF_AEROPUERT")
@NamedQueries({
    @NamedQuery(name = "RefAeropuert.findAll", query = "SELECT r FROM RefAeropuert r")})
public class RefAeropuert implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_REFERENCIA_AER")
    private Integer idReferenciaAer;
    @Column(name = "NOMBRE")
    private String nombre;
    @JoinColumn(name = "ID_AEROPUERTO", referencedColumnName = "ID_AEROPUERTO")
    @ManyToOne
    private Aeropuerto idAeropuerto;
    @JoinColumn(name = "ID_VUELO", referencedColumnName = "ID_VUELO")
    @ManyToOne
    private Vuelo idVuelo;

    public RefAeropuert() {
    }

    public RefAeropuert(Integer idReferenciaAer) {
        this.idReferenciaAer = idReferenciaAer;
    }

    public Integer getIdReferenciaAer() {
        return idReferenciaAer;
    }

    public void setIdReferenciaAer(Integer idReferenciaAer) {
        this.idReferenciaAer = idReferenciaAer;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Aeropuerto getIdAeropuerto() {
        return idAeropuerto;
    }

    public void setIdAeropuerto(Aeropuerto idAeropuerto) {
        this.idAeropuerto = idAeropuerto;
    }

    public Vuelo getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(Vuelo idVuelo) {
        this.idVuelo = idVuelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReferenciaAer != null ? idReferenciaAer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RefAeropuert)) {
            return false;
        }
        RefAeropuert other = (RefAeropuert) object;
        if ((this.idReferenciaAer == null && other.idReferenciaAer != null) || (this.idReferenciaAer != null && !this.idReferenciaAer.equals(other.idReferenciaAer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyecto.entidades.RefAeropuert[ idReferenciaAer=" + idReferenciaAer + " ]";
    }
    
}
