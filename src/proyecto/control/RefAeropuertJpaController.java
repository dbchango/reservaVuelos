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
import proyecto.entidades.Aeropuerto;
import proyecto.entidades.RefAeropuert;
import proyecto.entidades.Vuelo;

/**
 *
 * @author David
 */
public class RefAeropuertJpaController implements Serializable {

    public RefAeropuertJpaController() {
        this.emf = Persistence.createEntityManagerFactory("Proyecto_DespegarPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RefAeropuert refAeropuert) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aeropuerto idAeropuerto = refAeropuert.getIdAeropuerto();
            if (idAeropuerto != null) {
                idAeropuerto = em.getReference(idAeropuerto.getClass(), idAeropuerto.getIdAeropuerto());
                refAeropuert.setIdAeropuerto(idAeropuerto);
            }
            Vuelo idVuelo = refAeropuert.getIdVuelo();
            if (idVuelo != null) {
                idVuelo = em.getReference(idVuelo.getClass(), idVuelo.getIdVuelo());
                refAeropuert.setIdVuelo(idVuelo);
            }
            em.persist(refAeropuert);
            if (idAeropuerto != null) {
                idAeropuerto.getRefAeropuertList().add(refAeropuert);
                idAeropuerto = em.merge(idAeropuerto);
            }
            if (idVuelo != null) {
                idVuelo.getRefAeropuertList().add(refAeropuert);
                idVuelo = em.merge(idVuelo);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RefAeropuert refAeropuert) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RefAeropuert persistentRefAeropuert = em.find(RefAeropuert.class, refAeropuert.getIdReferenciaAer());
            Aeropuerto idAeropuertoOld = persistentRefAeropuert.getIdAeropuerto();
            Aeropuerto idAeropuertoNew = refAeropuert.getIdAeropuerto();
            Vuelo idVueloOld = persistentRefAeropuert.getIdVuelo();
            Vuelo idVueloNew = refAeropuert.getIdVuelo();
            if (idAeropuertoNew != null) {
                idAeropuertoNew = em.getReference(idAeropuertoNew.getClass(), idAeropuertoNew.getIdAeropuerto());
                refAeropuert.setIdAeropuerto(idAeropuertoNew);
            }
            if (idVueloNew != null) {
                idVueloNew = em.getReference(idVueloNew.getClass(), idVueloNew.getIdVuelo());
                refAeropuert.setIdVuelo(idVueloNew);
            }
            refAeropuert = em.merge(refAeropuert);
            if (idAeropuertoOld != null && !idAeropuertoOld.equals(idAeropuertoNew)) {
                idAeropuertoOld.getRefAeropuertList().remove(refAeropuert);
                idAeropuertoOld = em.merge(idAeropuertoOld);
            }
            if (idAeropuertoNew != null && !idAeropuertoNew.equals(idAeropuertoOld)) {
                idAeropuertoNew.getRefAeropuertList().add(refAeropuert);
                idAeropuertoNew = em.merge(idAeropuertoNew);
            }
            if (idVueloOld != null && !idVueloOld.equals(idVueloNew)) {
                idVueloOld.getRefAeropuertList().remove(refAeropuert);
                idVueloOld = em.merge(idVueloOld);
            }
            if (idVueloNew != null && !idVueloNew.equals(idVueloOld)) {
                idVueloNew.getRefAeropuertList().add(refAeropuert);
                idVueloNew = em.merge(idVueloNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = refAeropuert.getIdReferenciaAer();
                if (findRefAeropuert(id) == null) {
                    throw new NonexistentEntityException("The refAeropuert with id " + id + " no longer exists.");
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
            RefAeropuert refAeropuert;
            try {
                refAeropuert = em.getReference(RefAeropuert.class, id);
                refAeropuert.getIdReferenciaAer();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The refAeropuert with id " + id + " no longer exists.", enfe);
            }
            Aeropuerto idAeropuerto = refAeropuert.getIdAeropuerto();
            if (idAeropuerto != null) {
                idAeropuerto.getRefAeropuertList().remove(refAeropuert);
                idAeropuerto = em.merge(idAeropuerto);
            }
            Vuelo idVuelo = refAeropuert.getIdVuelo();
            if (idVuelo != null) {
                idVuelo.getRefAeropuertList().remove(refAeropuert);
                idVuelo = em.merge(idVuelo);
            }
            em.remove(refAeropuert);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RefAeropuert> findRefAeropuertEntities() {
        return findRefAeropuertEntities(true, -1, -1);
    }

    public List<RefAeropuert> findRefAeropuertEntities(int maxResults, int firstResult) {
        return findRefAeropuertEntities(false, maxResults, firstResult);
    }

    private List<RefAeropuert> findRefAeropuertEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RefAeropuert.class));
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

    public RefAeropuert findRefAeropuert(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RefAeropuert.class, id);
        } finally {
            em.close();
        }
    }

    public int getRefAeropuertCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RefAeropuert> rt = cq.from(RefAeropuert.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
