/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.entidades;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author David
 */
@Entity
@Table(name = "VUELO")
@NamedQueries({
    @NamedQuery(name = "Vuelo.findAll", query = "SELECT v FROM Vuelo v")})
public class Vuelo implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_VUELO")
    private Integer idVuelo;
    @Column(name = "ORIGEN")
    private String origen;
    @Column(name = "DESTINO")
    private String destino;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "VACANTES")
    private Integer vacantes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TIEMPO_ESTIMADO")
    private BigDecimal tiempoEstimado;
    @OneToMany(mappedBy = "idVuelo")
    private List<RefAeropuert> refAeropuertList;
    @OneToMany(mappedBy = "idVuelo")
    private List<Itinerario> itinerarioList;
    @JoinColumn(name = "ID_AVION", referencedColumnName = "ID_AVION")
    @ManyToOne
    private Avion idAvion;

    public Vuelo() {
    }

    public Vuelo(Integer idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Integer getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(Integer idVuelo) {
        Integer oldIdVuelo = this.idVuelo;
        this.idVuelo = idVuelo;
        changeSupport.firePropertyChange("idVuelo", oldIdVuelo, idVuelo);
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        String oldOrigen = this.origen;
        this.origen = origen;
        changeSupport.firePropertyChange("origen", oldOrigen, origen);
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        String oldDestino = this.destino;
        this.destino = destino;
        changeSupport.firePropertyChange("destino", oldDestino, destino);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = this.fecha;
        this.fecha = fecha;
        changeSupport.firePropertyChange("fecha", oldFecha, fecha);
    }

    public Integer getVacantes() {
        return vacantes;
    }

    public void setVacantes(Integer vacantes) {
        Integer oldVacantes = this.vacantes;
        this.vacantes = vacantes;
        changeSupport.firePropertyChange("vacantes", oldVacantes, vacantes);
    }

    public BigDecimal getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(BigDecimal tiempoEstimado) {
        BigDecimal oldTiempoEstimado = this.tiempoEstimado;
        this.tiempoEstimado = tiempoEstimado;
        changeSupport.firePropertyChange("tiempoEstimado", oldTiempoEstimado, tiempoEstimado);
    }

    public List<RefAeropuert> getRefAeropuertList() {
        return refAeropuertList;
    }

    public void setRefAeropuertList(List<RefAeropuert> refAeropuertList) {
        this.refAeropuertList = refAeropuertList;
    }

    public List<Itinerario> getItinerarioList() {
        return itinerarioList;
    }

    public void setItinerarioList(List<Itinerario> itinerarioList) {
        this.itinerarioList = itinerarioList;
    }

    public Avion getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(Avion idAvion) {
        Avion oldIdAvion = this.idAvion;
        this.idAvion = idAvion;
        changeSupport.firePropertyChange("idAvion", oldIdAvion, idAvion);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVuelo != null ? idVuelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vuelo)) {
            return false;
        }
        Vuelo other = (Vuelo) object;
        if ((this.idVuelo == null && other.idVuelo != null) || (this.idVuelo != null && !this.idVuelo.equals(other.idVuelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyecto.entidades.Vuelo[ idVuelo=" + idVuelo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
