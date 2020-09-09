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
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import proyecto.control.exceptions.NonexistentEntityException;
import proyecto.control.exceptions.PreexistingEntityException;
import proyecto.entidades.VistaReserva;

/**
 *
 * @author David
 */
public class VistaReservaJpaController implements Serializable {

    public VistaReservaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VistaReserva vistaReserva) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(vistaReserva);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVistaReserva(vistaReserva.getIdReserva()) != null) {
                throw new PreexistingEntityException("VistaReserva " + vistaReserva + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VistaReserva vistaReserva) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            vistaReserva = em.merge(vistaReserva);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = vistaReserva.getIdReserva();
                if (findVistaReserva(id) == null) {
                    throw new NonexistentEntityException("The vistaReserva with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VistaReserva vistaReserva;
            try {
                vistaReserva = em.getReference(VistaReserva.class, id);
                vistaReserva.getIdReserva();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vistaReserva with id " + id + " no longer exists.", enfe);
            }
            em.remove(vistaReserva);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VistaReserva> findVistaReservaEntities() {
        return findVistaReservaEntities(true, -1, -1);
    }

    public List<VistaReserva> findVistaReservaEntities(int maxResults, int firstResult) {
        return findVistaReservaEntities(false, maxResults, firstResult);
    }

    private List<VistaReserva> findVistaReservaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VistaReserva.class));
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

    public VistaReserva findVistaReserva(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VistaReserva.class, id);
        } finally {
            em.close();
        }
    }

    public int getVistaReservaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VistaReserva> rt = cq.from(VistaReserva.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
