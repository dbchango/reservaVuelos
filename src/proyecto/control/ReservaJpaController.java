/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import proyecto.control.exceptions.NonexistentEntityException;
import proyecto.entidades.Itinerario;
import proyecto.entidades.Pago;
import proyecto.entidades.Pasajero;
import proyecto.entidades.Reserva;
import proyecto.entidades.Usuario;

/**
 *
 * @author David
 */
public class ReservaJpaController implements Serializable {

    public ReservaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("Proyecto_DespegarPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reserva reserva) {
        if (reserva.getItinerarioList() == null) {
            reserva.setItinerarioList(new ArrayList<Itinerario>());
        }
        if (reserva.getPagoList() == null) {
            reserva.setPagoList(new ArrayList<Pago>());
        }
        if (reserva.getPasajeroList() == null) {
            reserva.setPasajeroList(new ArrayList<Pasajero>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario idUsuario = reserva.getIdUsuario();
            if (idUsuario != null) {
                idUsuario = em.getReference(idUsuario.getClass(), idUsuario.getIdUsuario());
                reserva.setIdUsuario(idUsuario);
            }
            List<Itinerario> attachedItinerarioList = new ArrayList<Itinerario>();
            for (Itinerario itinerarioListItinerarioToAttach : reserva.getItinerarioList()) {
                itinerarioListItinerarioToAttach = em.getReference(itinerarioListItinerarioToAttach.getClass(), itinerarioListItinerarioToAttach.getIdItinerario());
                attachedItinerarioList.add(itinerarioListItinerarioToAttach);
            }
            reserva.setItinerarioList(attachedItinerarioList);
            List<Pago> attachedPagoList = new ArrayList<Pago>();
            for (Pago pagoListPagoToAttach : reserva.getPagoList()) {
                pagoListPagoToAttach = em.getReference(pagoListPagoToAttach.getClass(), pagoListPagoToAttach.getIdPago());
                attachedPagoList.add(pagoListPagoToAttach);
            }
            reserva.setPagoList(attachedPagoList);
            List<Pasajero> attachedPasajeroList = new ArrayList<Pasajero>();
            for (Pasajero pasajeroListPasajeroToAttach : reserva.getPasajeroList()) {
                pasajeroListPasajeroToAttach = em.getReference(pasajeroListPasajeroToAttach.getClass(), pasajeroListPasajeroToAttach.getIdPasajero());
                attachedPasajeroList.add(pasajeroListPasajeroToAttach);
            }
            reserva.setPasajeroList(attachedPasajeroList);
            em.persist(reserva);
            if (idUsuario != null) {
                idUsuario.getReservaList().add(reserva);
                idUsuario = em.merge(idUsuario);
            }
            for (Itinerario itinerarioListItinerario : reserva.getItinerarioList()) {
                Reserva oldIdReservaOfItinerarioListItinerario = itinerarioListItinerario.getIdReserva();
                itinerarioListItinerario.setIdReserva(reserva);
                itinerarioListItinerario = em.merge(itinerarioListItinerario);
                if (oldIdReservaOfItinerarioListItinerario != null) {
                    oldIdReservaOfItinerarioListItinerario.getItinerarioList().remove(itinerarioListItinerario);
                    oldIdReservaOfItinerarioListItinerario = em.merge(oldIdReservaOfItinerarioListItinerario);
                }
            }
            for (Pago pagoListPago : reserva.getPagoList()) {
                Reserva oldIdReservaOfPagoListPago = pagoListPago.getIdReserva();
                pagoListPago.setIdReserva(reserva);
                pagoListPago = em.merge(pagoListPago);
                if (oldIdReservaOfPagoListPago != null) {
                    oldIdReservaOfPagoListPago.getPagoList().remove(pagoListPago);
                    oldIdReservaOfPagoListPago = em.merge(oldIdReservaOfPagoListPago);
                }
            }
            for (Pasajero pasajeroListPasajero : reserva.getPasajeroList()) {
                Reserva oldIdReservaOfPasajeroListPasajero = pasajeroListPasajero.getIdReserva();
                pasajeroListPasajero.setIdReserva(reserva);
                pasajeroListPasajero = em.merge(pasajeroListPasajero);
                if (oldIdReservaOfPasajeroListPasajero != null) {
                    oldIdReservaOfPasajeroListPasajero.getPasajeroList().remove(pasajeroListPasajero);
                    oldIdReservaOfPasajeroListPasajero = em.merge(oldIdReservaOfPasajeroListPasajero);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reserva reserva) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reserva persistentReserva = em.find(Reserva.class, reserva.getIdReserva());
            Usuario idUsuarioOld = persistentReserva.getIdUsuario();
            Usuario idUsuarioNew = reserva.getIdUsuario();
            List<Itinerario> itinerarioListOld = persistentReserva.getItinerarioList();
            List<Itinerario> itinerarioListNew = reserva.getItinerarioList();
            List<Pago> pagoListOld = persistentReserva.getPagoList();
            List<Pago> pagoListNew = reserva.getPagoList();
            List<Pasajero> pasajeroListOld = persistentReserva.getPasajeroList();
            List<Pasajero> pasajeroListNew = reserva.getPasajeroList();
            if (idUsuarioNew != null) {
                idUsuarioNew = em.getReference(idUsuarioNew.getClass(), idUsuarioNew.getIdUsuario());
                reserva.setIdUsuario(idUsuarioNew);
            }
            List<Itinerario> attachedItinerarioListNew = new ArrayList<Itinerario>();
            for (Itinerario itinerarioListNewItinerarioToAttach : itinerarioListNew) {
                itinerarioListNewItinerarioToAttach = em.getReference(itinerarioListNewItinerarioToAttach.getClass(), itinerarioListNewItinerarioToAttach.getIdItinerario());
                attachedItinerarioListNew.add(itinerarioListNewItinerarioToAttach);
            }
            itinerarioListNew = attachedItinerarioListNew;
            reserva.setItinerarioList(itinerarioListNew);
            List<Pago> attachedPagoListNew = new ArrayList<Pago>();
            for (Pago pagoListNewPagoToAttach : pagoListNew) {
                pagoListNewPagoToAttach = em.getReference(pagoListNewPagoToAttach.getClass(), pagoListNewPagoToAttach.getIdPago());
                attachedPagoListNew.add(pagoListNewPagoToAttach);
            }
            pagoListNew = attachedPagoListNew;
            reserva.setPagoList(pagoListNew);
            List<Pasajero> attachedPasajeroListNew = new ArrayList<Pasajero>();
            for (Pasajero pasajeroListNewPasajeroToAttach : pasajeroListNew) {
                pasajeroListNewPasajeroToAttach = em.getReference(pasajeroListNewPasajeroToAttach.getClass(), pasajeroListNewPasajeroToAttach.getIdPasajero());
                attachedPasajeroListNew.add(pasajeroListNewPasajeroToAttach);
            }
            pasajeroListNew = attachedPasajeroListNew;
            reserva.setPasajeroList(pasajeroListNew);
            reserva = em.merge(reserva);
            if (idUsuarioOld != null && !idUsuarioOld.equals(idUsuarioNew)) {
                idUsuarioOld.getReservaList().remove(reserva);
                idUsuarioOld = em.merge(idUsuarioOld);
            }
            if (idUsuarioNew != null && !idUsuarioNew.equals(idUsuarioOld)) {
                idUsuarioNew.getReservaList().add(reserva);
                idUsuarioNew = em.merge(idUsuarioNew);
            }
            for (Itinerario itinerarioListOldItinerario : itinerarioListOld) {
                if (!itinerarioListNew.contains(itinerarioListOldItinerario)) {
                    itinerarioListOldItinerario.setIdReserva(null);
                    itinerarioListOldItinerario = em.merge(itinerarioListOldItinerario);
                }
            }
            for (Itinerario itinerarioListNewItinerario : itinerarioListNew) {
                if (!itinerarioListOld.contains(itinerarioListNewItinerario)) {
                    Reserva oldIdReservaOfItinerarioListNewItinerario = itinerarioListNewItinerario.getIdReserva();
                    itinerarioListNewItinerario.setIdReserva(reserva);
                    itinerarioListNewItinerario = em.merge(itinerarioListNewItinerario);
                    if (oldIdReservaOfItinerarioListNewItinerario != null && !oldIdReservaOfItinerarioListNewItinerario.equals(reserva)) {
                        oldIdReservaOfItinerarioListNewItinerario.getItinerarioList().remove(itinerarioListNewItinerario);
                        oldIdReservaOfItinerarioListNewItinerario = em.merge(oldIdReservaOfItinerarioListNewItinerario);
                    }
                }
            }
            for (Pago pagoListOldPago : pagoListOld) {
                if (!pagoListNew.contains(pagoListOldPago)) {
                    pagoListOldPago.setIdReserva(null);
                    pagoListOldPago = em.merge(pagoListOldPago);
                }
            }
            for (Pago pagoListNewPago : pagoListNew) {
                if (!pagoListOld.contains(pagoListNewPago)) {
                    Reserva oldIdReservaOfPagoListNewPago = pagoListNewPago.getIdReserva();
                    pagoListNewPago.setIdReserva(reserva);
                    pagoListNewPago = em.merge(pagoListNewPago);
                    if (oldIdReservaOfPagoListNewPago != null && !oldIdReservaOfPagoListNewPago.equals(reserva)) {
                        oldIdReservaOfPagoListNewPago.getPagoList().remove(pagoListNewPago);
                        oldIdReservaOfPagoListNewPago = em.merge(oldIdReservaOfPagoListNewPago);
                    }
                }
            }
            for (Pasajero pasajeroListOldPasajero : pasajeroListOld) {
                if (!pasajeroListNew.contains(pasajeroListOldPasajero)) {
                    pasajeroListOldPasajero.setIdReserva(null);
                    pasajeroListOldPasajero = em.merge(pasajeroListOldPasajero);
                }
            }
            for (Pasajero pasajeroListNewPasajero : pasajeroListNew) {
                if (!pasajeroListOld.contains(pasajeroListNewPasajero)) {
                    Reserva oldIdReservaOfPasajeroListNewPasajero = pasajeroListNewPasajero.getIdReserva();
                    pasajeroListNewPasajero.setIdReserva(reserva);
                    pasajeroListNewPasajero = em.merge(pasajeroListNewPasajero);
                    if (oldIdReservaOfPasajeroListNewPasajero != null && !oldIdReservaOfPasajeroListNewPasajero.equals(reserva)) {
                        oldIdReservaOfPasajeroListNewPasajero.getPasajeroList().remove(pasajeroListNewPasajero);
                        oldIdReservaOfPasajeroListNewPasajero = em.merge(oldIdReservaOfPasajeroListNewPasajero);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = reserva.getIdReserva();
                if (findReserva(id) == null) {
                    throw new NonexistentEntityException("The reserva with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reserva reserva;
            try {
                reserva = em.getReference(Reserva.class, id);
                reserva.getIdReserva();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reserva with id " + id + " no longer exists.", enfe);
            }
            Usuario idUsuario = reserva.getIdUsuario();
            if (idUsuario != null) {
                idUsuario.getReservaList().remove(reserva);
                idUsuario = em.merge(idUsuario);
            }
            List<Itinerario> itinerarioList = reserva.getItinerarioList();
            for (Itinerario itinerarioListItinerario : itinerarioList) {
                itinerarioListItinerario.setIdReserva(null);
                itinerarioListItinerario = em.merge(itinerarioListItinerario);
            }
            List<Pago> pagoList = reserva.getPagoList();
            for (Pago pagoListPago : pagoList) {
                pagoListPago.setIdReserva(null);
                pagoListPago = em.merge(pagoListPago);
            }
            List<Pasajero> pasajeroList = reserva.getPasajeroList();
            for (Pasajero pasajeroListPasajero : pasajeroList) {
                pasajeroListPasajero.setIdReserva(null);
                pasajeroListPasajero = em.merge(pasajeroListPasajero);
            }
            em.remove(reserva);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reserva> findReservaEntities() {
        return findReservaEntities(true, -1, -1);
    }

    public List<Reserva> findReservaEntities(int maxResults, int firstResult) {
        return findReservaEntities(false, maxResults, firstResult);
    }

    private List<Reserva> findReservaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reserva.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Reserva findReserva(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reserva.class, id);
        } finally {
            em.close();
        }
    }

    public int getReservaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reserva> rt = cq.from(Reserva.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
