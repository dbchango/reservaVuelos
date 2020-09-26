/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.entidades;

import proyecto.entidades.Reserva;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author David
 */
@Entity
@Table(name = "ITINERARIO")
@NamedQueries({
    @NamedQuery(name = "Itinerario.findAll", query = "SELECT i FROM Itinerario i")})
public class Itinerario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ITINERARIO")
    private Integer idItinerario;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "ID_RESERVA", referencedColumnName = "ID_RESERVA")
    @ManyToOne
    private Reserva idReserva;
    @JoinColumn(name = "ID_VUELO", referencedColumnName = "ID_VUELO")
    @ManyToOne
    private Vuelo idVuelo;

    public Itinerario() {
    }

    public Itinerario(Integer idItinerario) {
        this.idItinerario = idItinerario;
    }

    public Integer getIdItinerario() {
        return idItinerario;
    }

    public void setIdItinerario(Integer idItinerario) {
        this.idItinerario = idItinerario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Reserva getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Reserva idReserva) {
        this.idReserva = idReserva;
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
        hash += (idItinerario != null ? idItinerario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itinerario)) {
            return false;
        }
        Itinerario other = (Itinerario) object;
        if ((this.idItinerario == null && other.idItinerario != null) || (this.idItinerario != null && !this.idItinerario.equals(other.idItinerario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyecto.entidades.Itinerario[ idItinerario=" + idItinerario + " ]";
    }
    
}
