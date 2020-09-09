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
import proyecto.entidades.Aerolinea;
import proyecto.entidades.Vuelo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import proyecto.control.exceptions.NonexistentEntityException;
import proyecto.entidades.Avion;

/**
 *
 * @author David
 */
public class AvionJpaController implements Serializable {

    public AvionJpaController() {
        this.emf = Persistence.createEntityManagerFactory("Proyecto_DespegarPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Avion avion) {
        if (avion.getVueloList() == null) {
            avion.setVueloList(new ArrayList<Vuelo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aerolinea idAerolinea = avion.getIdAerolinea();
            if (idAerolinea != null) {
                idAerolinea = em.getReference(idAerolinea.getClass(), idAerolinea.getIdAerolinea());
                avion.setIdAerolinea(idAerolinea);
            }
            List<Vuelo> attachedVueloList = new ArrayList<Vuelo>();
            for (Vuelo vueloListVueloToAttach : avion.getVueloList()) {
                vueloListVueloToAttach = em.getReference(vueloListVueloToAttach.getClass(), vueloListVueloToAttach.getIdVuelo());
                attachedVueloList.add(vueloListVueloToAttach);
            }
            avion.setVueloList(attachedVueloList);
            em.persist(avion);
            if (idAerolinea != null) {
                idAerolinea.getAvionList().add(avion);
                idAerolinea = em.merge(idAerolinea);
            }
            for (Vuelo vueloListVuelo : avion.getVueloList()) {
                Avion oldIdAvionOfVueloListVuelo = vueloListVuelo.getIdAvion();
                vueloListVuelo.setIdAvion(avion);
                vueloListVuelo = em.merge(vueloListVuelo);
                if (oldIdAvionOfVueloListVuelo != null) {
                    oldIdAvionOfVueloListVuelo.getVueloList().remove(vueloListVuelo);
                    oldIdAvionOfVueloListVuelo = em.merge(oldIdAvionOfVueloListVuelo);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Avion avion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Avion persistentAvion = em.find(Avion.class, avion.getIdAvion());
            Aerolinea idAerolineaOld = persistentAvion.getIdAerolinea();
            Aerolinea idAerolineaNew = avion.getIdAerolinea();
            List<Vuelo> vueloListOld = persistentAvion.getVueloList();
            List<Vuelo> vueloListNew = avion.getVueloList();
            if (idAerolineaNew != null) {
                idAerolineaNew = em.getReference(idAerolineaNew.getClass(), idAerolineaNew.getIdAerolinea());
                avion.setIdAerolinea(idAerolineaNew);
            }
            List<Vuelo> attachedVueloListNew = new ArrayList<Vuelo>();
            for (Vuelo vueloListNewVueloToAttach : vueloListNew) {
                vueloListNewVueloToAttach = em.getReference(vueloListNewVueloToAttach.getClass(), vueloListNewVueloToAttach.getIdVuelo());
                attachedVueloListNew.add(vueloListNewVueloToAttach);
            }
            vueloListNew = attachedVueloListNew;
            avion.setVueloList(vueloListNew);
            avion = em.merge(avion);
            if (idAerolineaOld != null && !idAerolineaOld.equals(idAerolineaNew)) {
                idAerolineaOld.getAvionList().remove(avion);
                idAerolineaOld = em.merge(idAerolineaOld);
            }
            if (idAerolineaNew != null && !idAerolineaNew.equals(idAerolineaOld)) {
                idAerolineaNew.getAvionList().add(avion);
                idAerolineaNew = em.merge(idAerolineaNew);
            }
            for (Vuelo vueloListOldVuelo : vueloListOld) {
                if (!vueloListNew.contains(vueloListOldVuelo)) {
                    vueloListOldVuelo.setIdAvion(null);
                    vueloListOldVuelo = em.merge(vueloListOldVuelo);
                }
            }
            for (Vuelo vueloListNewVuelo : vueloListNew) {
                if (!vueloListOld.contains(vueloListNewVuelo)) {
                    Avion oldIdAvionOfVueloListNewVuelo = vueloListNewVuelo.getIdAvion();
                    vueloListNewVuelo.setIdAvion(avion);
                    vueloListNewVuelo = em.merge(vueloListNewVuelo);
                    if (oldIdAvionOfVueloListNewVuelo != null && !oldIdAvionOfVueloListNewVuelo.equals(avion)) {
                        oldIdAvionOfVueloListNewVuelo.getVueloList().remove(vueloListNewVuelo);
                        oldIdAvionOfVueloListNewVuelo = em.merge(oldIdAvionOfVueloListNewVuelo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = avion.getIdAvion();
                if (findAvion(id) == null) {
                    throw new NonexistentEntityException("The avion with id " + id + " no longer exists.");
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
            Avion avion;
            try {
                avion = em.getReference(Avion.class, id);
                avion.getIdAvion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The avion with id " + id + " no longer exists.", enfe);
            }
            Aerolinea idAerolinea = avion.getIdAerolinea();
            if (idAerolinea != null) {
                idAerolinea.getAvionList().remove(avion);
                idAerolinea = em.merge(idAerolinea);
            }
            List<Vuelo> vueloList = avion.getVueloList();
            for (Vuelo vueloListVuelo : vueloList) {
                vueloListVuelo.setIdAvion(null);
                vueloListVuelo = em.merge(vueloListVuelo);
            }
            em.remove(avion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Avion> findAvionEntities() {
        return findAvionEntities(true, -1, -1);
    }

    public List<Avion> findAvionEntities(int maxResults, int firstResult) {
        return findAvionEntities(false, maxResults, firstResult);
    }

    private List<Avion> findAvionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Avion.class));
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

    public Avion findAvion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Avion.class, id);
        } finally {
            em.close();
        }
    }

    public int getAvionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Avion> rt = cq.from(Avion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
