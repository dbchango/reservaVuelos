/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.entidades;

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

/**
 *
 * @author David
 */
@Entity
@Table(name = "AEROLINEA")
@NamedQueries({
    @NamedQuery(name = "Aerolinea.findAll", query = "SELECT a FROM Aerolinea a")})
public class Aerolinea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_AEROLINEA")
    private Integer idAerolinea;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "PAGINAWEB")
    private String paginaweb;
    @OneToMany(mappedBy = "idAerolinea")
    private List<Avion> avionList;

    public Aerolinea() {
    }

    public Aerolinea(Integer idAerolinea) {
        this.idAerolinea = idAerolinea;
    }

    public Integer getIdAerolinea() {
        return idAerolinea;
    }

    public void setIdAerolinea(Integer idAerolinea) {
        this.idAerolinea = idAerolinea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaginaweb() {
        return paginaweb;
    }

    public void setPaginaweb(String paginaweb) {
        this.paginaweb = paginaweb;
    }

    public List<Avion> getAvionList() {
        return avionList;
    }

    public void setAvionList(List<Avion> avionList) {
        this.avionList = avionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAerolinea != null ? idAerolinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aerolinea)) {
            return false;
        }
        Aerolinea other = (Aerolinea) object;
        if ((this.idAerolinea == null && other.idAerolinea != null) || (this.idAerolinea != null && !this.idAerolinea.equals(other.idAerolinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idAerolinea+"";
    }
    
}
