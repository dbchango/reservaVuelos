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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "AVION")
@NamedQueries({
    @NamedQuery(name = "Avion.findAll", query = "SELECT a FROM Avion a")})
public class Avion implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_AVION")
    private Integer idAvion;
    @Column(name = "CAPACIDAD")
    private Integer capacidad;
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "MODELO")
    private String modelo;
    @OneToMany(mappedBy = "idAvion")
    private List<Vuelo> vueloList;
    @JoinColumn(name = "ID_AEROLINEA", referencedColumnName = "ID_AEROLINEA")
    @ManyToOne
    private Aerolinea idAerolinea;

    public Avion() {
    }

    public Avion(Integer idAvion) {
        this.idAvion = idAvion;
    }

    public Integer getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(Integer idAvion) {
        Integer oldIdAvion = this.idAvion;
        this.idAvion = idAvion;
        changeSupport.firePropertyChange("idAvion", oldIdAvion, idAvion);
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        Integer oldCapacidad = this.capacidad;
        this.capacidad = capacidad;
        changeSupport.firePropertyChange("capacidad", oldCapacidad, capacidad);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        String oldMarca = this.marca;
        this.marca = marca;
        changeSupport.firePropertyChange("marca", oldMarca, marca);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        String oldModelo = this.modelo;
        this.modelo = modelo;
        changeSupport.firePropertyChange("modelo", oldModelo, modelo);
    }

    public List<Vuelo> getVueloList() {
        return vueloList;
    }

    public void setVueloList(List<Vuelo> vueloList) {
        this.vueloList = vueloList;
    }

    public Aerolinea getIdAerolinea() {
        return idAerolinea;
    }

    public void setIdAerolinea(Aerolinea idAerolinea) {
        Aerolinea oldIdAerolinea = this.idAerolinea;
        this.idAerolinea = idAerolinea;
        changeSupport.firePropertyChange("idAerolinea", oldIdAerolinea, idAerolinea);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAvion != null ? idAvion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avion)) {
            return false;
        }
        Avion other = (Avion) object;
        if ((this.idAvion == null && other.idAvion != null) || (this.idAvion != null && !this.idAvion.equals(other.idAvion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo: "+modelo+" => " + idAvion;
    }

    public String toStringId() {
        return idAvion.toString();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
