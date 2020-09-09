/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.control;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import proyecto.entidades.RefAeropuert;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import proyecto.control.exceptions.NonexistentEntityException;
import proyecto.entidades.Aeropuerto;

/**
 *
 * @author David
 */
public class AeropuertoJpaController implements Serializable {

    public AeropuertoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("Proyecto_DespegarPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Aeropuerto aeropuerto) {
        if (aeropuerto.getRefAeropuertList() == null) {
            aeropuerto.setRefAeropuertList(new ArrayList<RefAeropuert>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<RefAeropuert> attachedRefAeropuertList = new ArrayList<RefAeropuert>();
            for (RefAeropuert refAeropuertListRefAeropuertToAttach : aeropuerto.getRefAeropuertList()) {
                refAeropuertListRefAeropuertToAttach = em.getReference(refAeropuertListRefAeropuertToAttach.getClass(), refAeropuertListRefAeropuertToAttach.getIdReferenciaAer());
                attachedRefAeropuertList.add(refAeropuertListRefAeropuertToAttach);
            }
            aeropuerto.setRefAeropuertList(attachedRefAeropuertList);
            em.persist(aeropuerto);
            for (RefAeropuert refAeropuertListRefAeropuert : aeropuerto.getRefAeropuertList()) {
                Aeropuerto oldIdAeropuertoOfRefAeropuertListRefAeropuert = refAeropuertListRefAeropuert.getIdAeropuerto();
                refAeropuertListRefAeropuert.setIdAeropuerto(aeropuerto);
                refAeropuertListRefAeropuert = em.merge(refAeropuertListRefAeropuert);
                if (oldIdAeropuertoOfRefAeropuertListRefAeropuert != null) {
                    oldIdAeropuertoOfRefAeropuertListRefAeropuert.getRefAeropuertList().remove(refAeropuertListRefAeropuert);
                    oldIdAeropuertoOfRefAeropuertListRefAeropuert = em.merge(oldIdAeropuertoOfRefAeropuertListRefAeropuert);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Aeropuerto aeropuerto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aeropuerto persistentAeropuerto = em.find(Aeropuerto.class, aeropuerto.getIdAeropuerto());
            List<RefAeropuert> refAeropuertListOld = persistentAeropuerto.getRefAeropuertList();
            List<RefAeropuert> refAeropuertListNew = aeropuerto.getRefAeropuertList();
            List<RefAeropuert> attachedRefAeropuertListNew = new ArrayList<RefAeropuert>();
            for (RefAeropuert refAeropuertListNewRefAeropuertToAttach : refAeropuertListNew) {
                refAeropuertListNewRefAeropuertToAttach = em.getReference(refAeropuertListNewRefAeropuertToAttach.getClass(), refAeropuertListNewRefAeropuertToAttach.getIdReferenciaAer());
                attachedRefAeropuertListNew.add(refAeropuertListNewRefAeropuertToAttach);
            }
            refAeropuertListNew = attachedRefAeropuertListNew;
            aeropuerto.setRefAeropuertList(refAeropuertListNew);
            aeropuerto = em.merge(aeropuerto);
            for (RefAeropuert refAeropuertListOldRefAeropuert : refAeropuertListOld) {
                if (!refAeropuertListNew.contains(refAeropuertListOldRefAeropuert)) {
                    refAeropuertListOldRefAeropuert.setIdAeropuerto(null);
                    refAeropuertListOldRefAeropuert = em.merge(refAeropuertListOldRefAeropuert);
                }
            }
            for (RefAeropuert refAeropuertListNewRefAeropuert : refAeropuertListNew) {
                if (!refAeropuertListOld.contains(refAeropuertListNewRefAeropuert)) {
                    Aeropuerto oldIdAeropuertoOfRefAeropuertListNewRefAeropuert = refAeropuertListNewRefAeropuert.getIdAeropuerto();
                    refAeropuertListNewRefAeropuert.setIdAeropuerto(aeropuerto);
                    refAeropuertListNewRefAeropuert = em.merge(refAeropuertListNewRefAeropuert);
                    if (oldIdAeropuertoOfRefAeropuertListNewRefAeropuert != null && !oldIdAeropuertoOfRefAeropuertListNewRefAeropuert.equals(aeropuerto)) {
                        oldIdAeropuertoOfRefAeropuertListNewRefAeropuert.getRefAeropuertList().remove(refAeropuertListNewRefAeropuert);
                        oldIdAeropuertoOfRefAeropuertListNewRefAeropuert = em.merge(oldIdAeropuertoOfRefAeropuertListNewRefAeropuert);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = aeropuerto.getIdAeropuerto();
                if (findAeropuerto(id) == null) {
                    throw new NonexistentEntityException("The aeropuerto with id " + id + " no longer exists.");
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
            Aeropuerto aeropuerto;
            try {
                aeropuerto = em.getReference(Aeropuerto.class, id);
                aeropuerto.getIdAeropuerto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The aeropuerto with id " + id + " no longer exists.", enfe);
            }
            List<RefAeropuert> refAeropuertList = aeropuerto.getRefAeropuertList();
            for (RefAeropuert refAeropuertListRefAeropuert : refAeropuertList) {
                refAeropuertListRefAeropuert.setIdAeropuerto(null);
                refAeropuertListRefAeropuert = em.merge(refAeropuertListRefAeropuert);
            }
            em.remove(aeropuerto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Aeropuerto> findAeropuertoEntities() {
        return findAeropuertoEntities(true, -1, -1);
    }

    public List<Aeropuerto> findAeropuertoEntities(int maxResults, int firstResult) {
        return findAeropuertoEntities(false, maxResults, firstResult);
    }

    private List<Aeropuerto> findAeropuertoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Aeropuerto.class));
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

    public Aeropuerto findAeropuerto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Aeropuerto.class, id);
        } finally {
            em.close();
        }
    }

    public int getAeropuertoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Aeropuerto> rt = cq.from(Aeropuerto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
