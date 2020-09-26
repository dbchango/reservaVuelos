/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.control;

import java.io.Serializable;
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
import proyecto.entidades.Reserva;
import proyecto.entidades.Vuelo;

/**
 *
 * @author David
 */
public class ItinerarioJpaController implements Serializable {

    public ItinerarioJpaController() {
        this.emf = Persistence.createEntityManagerFactory("Proyecto_DespegarPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Itinerario itinerario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reserva idReserva = itinerario.getIdReserva();
            if (idReserva != null) {
                idReserva = em.getReference(idReserva.getClass(), idReserva.getIdReserva());
                itinerario.setIdReserva(idReserva);
            }
            Vuelo idVuelo = itinerario.getIdVuelo();
            if (idVuelo != null) {
                idVuelo = em.getReference(idVuelo.getClass(), idVuelo.getIdVuelo());
                itinerario.setIdVuelo(idVuelo);
            }
            em.persist(itinerario);
            if (idReserva != null) {
                idReserva.getItinerarioList().add(itinerario);
                idReserva = em.merge(idReserva);
            }
            if (idVuelo != null) {
                idVuelo.getItinerarioList().add(itinerario);
                idVuelo = em.merge(idVuelo);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Itinerario itinerario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Itinerario persistentItinerario = em.find(Itinerario.class, itinerario.getIdItinerario());
            Reserva idReservaOld = persistentItinerario.getIdReserva();
            Reserva idReservaNew = itinerario.getIdReserva();
            Vuelo idVueloOld = persistentItinerario.getIdVuelo();
            Vuelo idVueloNew = itinerario.getIdVuelo();
            if (idReservaNew != null) {
                idReservaNew = em.getReference(idReservaNew.getClass(), idReservaNew.getIdReserva());
                itinerario.setIdReserva(idReservaNew);
            }
            if (idVueloNew != null) {
                idVueloNew = em.getReference(idVueloNew.getClass(), idVueloNew.getIdVuelo());
                itinerario.setIdVuelo(idVueloNew);
            }
            itinerario = em.merge(itinerario);
            if (idReservaOld != null && !idReservaOld.equals(idReservaNew)) {
                idReservaOld.getItinerarioList().remove(itinerario);
                idReservaOld = em.merge(idReservaOld);
            }
            if (idReservaNew != null && !idReservaNew.equals(idReservaOld)) {
                idReservaNew.getItinerarioList().add(itinerario);
                idReservaNew = em.merge(idReservaNew);
            }
            if (idVueloOld != null && !idVueloOld.equals(idVueloNew)) {
                idVueloOld.getItinerarioList().remove(itinerario);
                idVueloOld = em.merge(idVueloOld);
            }
            if (idVueloNew != null && !idVueloNew.equals(idVueloOld)) {
                idVueloNew.getItinerarioList().add(itinerario);
                idVueloNew = em.merge(idVueloNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = itinerario.getIdItinerario();
                if (findItinerario(id) == null) {
                    throw new NonexistentEntityException("The itinerario with id " + id + " no longer exists.");
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
            Itinerario itinerario;
            try {
                itinerario = em.getReference(Itinerario.class, id);
                itinerario.getIdItinerario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The itinerario with id " + id + " no longer exists.", enfe);
            }
            Reserva idReserva = itinerario.getIdReserva();
            if (idReserva != null) {
                idReserva.getItinerarioList().remove(itinerario);
                idReserva = em.merge(idReserva);
            }
            Vuelo idVuelo = itinerario.getIdVuelo();
            if (idVuelo != null) {
                idVuelo.getItinerarioList().remove(itinerario);
                idVuelo = em.merge(idVuelo);
            }
            em.remove(itinerario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Itinerario> findItinerarioEntities() {
        return findItinerarioEntities(true, -1, -1);
    }

    public List<Itinerario> findItinerarioEntities(int maxResults, int firstResult) {
        return findItinerarioEntities(false, maxResults, firstResult);
    }

    private List<Itinerario> findItinerarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Itinerario.class));
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

    public Itinerario findItinerario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Itinerario.class, id);
        } finally {
            em.close();
        }
    }

    public int getItinerarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Itinerario> rt = cq.from(Itinerario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
