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
import proyecto.entidades.VistaAviones;

/**
 *
 * @author David
 */
public class VistaAvionesJpaController implements Serializable {

    public VistaAvionesJpaController() {
        this.emf = Persistence.createEntityManagerFactory("Proyecto_DespegarPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VistaAviones vistaAviones) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(vistaAviones);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVistaAviones(vistaAviones.getIdAvion()) != null) {
                throw new PreexistingEntityException("VistaAviones " + vistaAviones + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VistaAviones vistaAviones) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            vistaAviones = em.merge(vistaAviones);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = vistaAviones.getIdAvion();
                if (findVistaAviones(id) == null) {
                    throw new NonexistentEntityException("The vistaAviones with id " + id + " no longer exists.");
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
            VistaAviones vistaAviones;
            try {
                vistaAviones = em.getReference(VistaAviones.class, id);
                vistaAviones.getIdAvion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vistaAviones with id " + id + " no longer exists.", enfe);
            }
            em.remove(vistaAviones);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VistaAviones> findVistaAvionesEntities() {
        return findVistaAvionesEntities(true, -1, -1);
    }

    public List<VistaAviones> findVistaAvionesEntities(int maxResults, int firstResult) {
        return findVistaAvionesEntities(false, maxResults, firstResult);
    }

    private List<VistaAviones> findVistaAvionesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VistaAviones.class));
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

    public VistaAviones findVistaAviones(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VistaAviones.class, id);
        } finally {
            em.close();
        }
    }

    public int getVistaAvionesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VistaAviones> rt = cq.from(VistaAviones.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
