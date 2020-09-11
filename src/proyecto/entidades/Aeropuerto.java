/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.entidades;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author David
 */
@Entity
@Table(name = "AEROPUERTO")
@NamedQueries({
    @NamedQuery(name = "Aeropuerto.findAll", query = "SELECT a FROM Aeropuerto a")})
public class Aeropuerto implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_AEROPUERTO")
    private Integer idAeropuerto;
    @Column(name = "NOMBRE_AEROPUERTO")
    private String nombreAeropuerto;
    @Column(name = "PAGINAWEB")
    private String paginaweb;
    @Column(name = "CIUDAD")
    private String ciudad;
    @Column(name = "PAIS")
    private String pais;
    @OneToMany(mappedBy = "idAeropuerto")
    private List<RefAeropuert> refAeropuertList;

    public Aeropuerto() {
    }

    public Aeropuerto(Integer idAeropuerto) {
        this.idAeropuerto = idAeropuerto;
    }

    public Integer getIdAeropuerto() {
        return idAeropuerto;
    }

    public void setIdAeropuerto(Integer idAeropuerto) {
        Integer oldIdAeropuerto = this.idAeropuerto;
        this.idAeropuerto = idAeropuerto;
        changeSupport.firePropertyChange("idAeropuerto", oldIdAeropuerto, idAeropuerto);
    }

    public String getNombreAeropuerto() {
        return nombreAeropuerto;
    }

    public void setNombreAeropuerto(String nombreAeropuerto) {
        String oldNombreAeropuerto = this.nombreAeropuerto;
        this.nombreAeropuerto = nombreAeropuerto;
        changeSupport.firePropertyChange("nombreAeropuerto", oldNombreAeropuerto, nombreAeropuerto);
    }

    public String getPaginaweb() {
        return paginaweb;
    }

    public void setPaginaweb(String paginaweb) {
        String oldPaginaweb = this.paginaweb;
        this.paginaweb = paginaweb;
        changeSupport.firePropertyChange("paginaweb", oldPaginaweb, paginaweb);
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        String oldCiudad = this.ciudad;
        this.ciudad = ciudad;
        changeSupport.firePropertyChange("ciudad", oldCiudad, ciudad);
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        String oldPais = this.pais;
        this.pais = pais;
        changeSupport.firePropertyChange("pais", oldPais, pais);
    }

    public List<RefAeropuert> getRefAeropuertList() {
        return refAeropuertList;
    }

    public void setRefAeropuertList(List<RefAeropuert> refAeropuertList) {
        this.refAeropuertList = refAeropuertList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAeropuerto != null ? idAeropuerto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aeropuerto)) {
            return false;
        }
        Aeropuerto other = (Aeropuerto) object;
        if ((this.idAeropuerto == null && other.idAeropuerto != null) || (this.idAeropuerto != null && !this.idAeropuerto.equals(other.idAeropuerto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyecto.entidades.Aeropuerto[ idAeropuerto=" + idAeropuerto + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
