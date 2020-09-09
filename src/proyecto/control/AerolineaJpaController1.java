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
import proyecto.entidades.Avion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import proyecto.control.exceptions.NonexistentEntityException;
import proyecto.entidades.Aerolinea;

/**
 *
 * @author David
 */
public class AerolineaJpaController1 implements Serializable {

    public AerolineaJpaController1() {
        this.emf = Persistence.createEntityManagerFactory("Proyecto_DespegarPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Aerolinea aerolinea) {
        if (aerolinea.getAvionList() == null) {
            aerolinea.setAvionList(new ArrayList<Avion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Avion> attachedAvionList = new ArrayList<Avion>();
            for (Avion avionListAvionToAttach : aerolinea.getAvionList()) {
                avionListAvionToAttach = em.getReference(avionListAvionToAttach.getClass(), avionListAvionToAttach.getIdAvion());
                attachedAvionList.add(avionListAvionToAttach);
            }
            aerolinea.setAvionList(attachedAvionList);
            em.persist(aerolinea);
            for (Avion avionListAvion : aerolinea.getAvionList()) {
                Aerolinea oldIdAerolineaOfAvionListAvion = avionListAvion.getIdAerolinea();
                avionListAvion.setIdAerolinea(aerolinea);
                avionListAvion = em.merge(avionListAvion);
                if (oldIdAerolineaOfAvionListAvion != null) {
                    oldIdAerolineaOfAvionListAvion.getAvionList().remove(avionListAvion);
                    oldIdAerolineaOfAvionListAvion = em.merge(oldIdAerolineaOfAvionListAvion);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Aerolinea aerolinea) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aerolinea persistentAerolinea = em.find(Aerolinea.class, aerolinea.getIdAerolinea());
            List<Avion> avionListOld = persistentAerolinea.getAvionList();
            List<Avion> avionListNew = aerolinea.getAvionList();
            List<Avion> attachedAvionListNew = new ArrayList<Avion>();
            for (Avion avionListNewAvionToAttach : avionListNew) {
                avionListNewAvionToAttach = em.getReference(avionListNewAvionToAttach.getClass(), avionListNewAvionToAttach.getIdAvion());
                attachedAvionListNew.add(avionListNewAvionToAttach);
            }
            avionListNew = attachedAvionListNew;
            aerolinea.setAvionList(avionListNew);
            aerolinea = em.merge(aerolinea);
            for (Avion avionListOldAvion : avionListOld) {
                if (!avionListNew.contains(avionListOldAvion)) {
                    avionListOldAvion.setIdAerolinea(null);
                    avionListOldAvion = em.merge(avionListOldAvion);
                }
            }
            for (Avion avionListNewAvion : avionListNew) {
                if (!avionListOld.contains(avionListNewAvion)) {
                    Aerolinea oldIdAerolineaOfAvionListNewAvion = avionListNewAvion.getIdAerolinea();
                    avionListNewAvion.setIdAerolinea(aerolinea);
                    avionListNewAvion = em.merge(avionListNewAvion);
                    if (oldIdAerolineaOfAvionListNewAvion != null && !oldIdAerolineaOfAvionListNewAvion.equals(aerolinea)) {
                        oldIdAerolineaOfAvionListNewAvion.getAvionList().remove(avionListNewAvion);
                        oldIdAerolineaOfAvionListNewAvion = em.merge(oldIdAerolineaOfAvionListNewAvion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = aerolinea.getIdAerolinea();
                if (findAerolinea(id) == null) {
                    throw new NonexistentEntityException("The aerolinea with id " + id + " no longer exists.");
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
            Aerolinea aerolinea;
            try {
                aerolinea = em.getReference(Aerolinea.class, id);
                aerolinea.getIdAerolinea();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The aerolinea with id " + id + " no longer exists.", enfe);
            }
            List<Avion> avionList = aerolinea.getAvionList();
            for (Avion avionListAvion : avionList) {
                avionListAvion.setIdAerolinea(null);
                avionListAvion = em.merge(avionListAvion);
            }
            em.remove(aerolinea);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Aerolinea> findAerolineaEntities() {
        return findAerolineaEntities(true, -1, -1);
    }

    public List<Aerolinea> findAerolineaEntities(int maxResults, int firstResult) {
        return findAerolineaEntities(false, maxResults, firstResult);
    }

    private List<Aerolinea> findAerolineaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Aerolinea.class));
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

    public Aerolinea findAerolinea(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Aerolinea.class, id);
        } finally {
            em.close();
        }
    }

    public int getAerolineaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Aerolinea> rt = cq.from(Aerolinea.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
