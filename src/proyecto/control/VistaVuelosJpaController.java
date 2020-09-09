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
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import proyecto.control.exceptions.NonexistentEntityException;
import proyecto.control.exceptions.PreexistingEntityException;
import proyecto.entidades.VistaVuelos;

/**
 *
 * @author David
 */
public class VistaVuelosJpaController implements Serializable {

    public VistaVuelosJpaController() {
         this.emf = Persistence.createEntityManagerFactory("Proyecto_DespegarPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VistaVuelos vistaVuelos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(vistaVuelos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVistaVuelos(vistaVuelos.getIdVuelo()) != null) {
                throw new PreexistingEntityException("VistaVuelos " + vistaVuelos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VistaVuelos vistaVuelos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            vistaVuelos = em.merge(vistaVuelos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = vistaVuelos.getIdVuelo();
                if (findVistaVuelos(id) == null) {
                    throw new NonexistentEntityException("The vistaVuelos with id " + id + " no longer exists.");
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
            VistaVuelos vistaVuelos;
            try {
                vistaVuelos = em.getReference(VistaVuelos.class, id);
                vistaVuelos.getIdVuelo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vistaVuelos with id " + id + " no longer exists.", enfe);
            }
            em.remove(vistaVuelos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VistaVuelos> findVistaVuelosEntities() {
        return findVistaVuelosEntities(true, -1, -1);
    }

    public List<VistaVuelos> findVistaVuelosEntities(int maxResults, int firstResult) {
        return findVistaVuelosEntities(false, maxResults, firstResult);
    }

    private List<VistaVuelos> findVistaVuelosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VistaVuelos.class));
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

    public VistaVuelos findVistaVuelos(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VistaVuelos.class, id);
        } finally {
            em.close();
        }
    }

    public int getVistaVuelosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VistaVuelos> rt = cq.from(VistaVuelos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
